package com.axonmed.xds.source.scp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.dcm4che.data.Attributes;
import org.dcm4che.data.Tag;
import org.dcm4che.io.DicomOutputStream;
import org.dcm4che.net.ApplicationEntity;
import org.dcm4che.net.Association;
import org.dcm4che.net.PDVInputStream;
import org.dcm4che.net.Status;
import org.dcm4che.net.pdu.PresentationContext;
import org.dcm4che.net.service.BasicCStoreSCP;
import org.dcm4che.net.service.DicomServiceException;
import org.dcm4che.util.SafeClose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import com.axonmed.xds.source.bo.ServerFilesystemInfo;
import com.axonmed.xds.source.bo.StudyStorageLocation;
import com.axonmed.xds.source.callback.DicomStreamWriteCallback;
import com.axonmed.xds.source.enumeration.DuplicateSopPolicyEnum;
import com.axonmed.xds.source.enumeration.WorkQueueTypeEnum;
import com.axonmed.xds.source.exception.NoWritableFilesystemException;
import com.axonmed.xds.source.exception.StudyIsNearlineException;
import com.axonmed.xds.source.exception.StudyNotFoundException;
import com.axonmed.xds.source.model.Device;
import com.axonmed.xds.source.model.ServerPartition;
import com.axonmed.xds.source.model.Study;
import com.axonmed.xds.source.service.DeviceService;
import com.axonmed.xds.source.service.FilesystemService;
import com.axonmed.xds.source.service.StudyIntegrityQueueService;
import com.axonmed.xds.source.service.StudyService;
import com.axonmed.xds.source.service.WorkQueueService;

@Component
public final class StorageSCP extends BasicCStoreSCP {
	private static final Logger logger = LoggerFactory
			.getLogger(StorageSCP.class);

	@Autowired
	private TaskExecutor taskExecutor;

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private FilesystemService filesystemService;

	@Autowired
	private WorkQueueService workQueueService;

	@Autowired
	private StudyIntegrityQueueService studyIntegrityQueueService;

	@Autowired
	private StudyService studyService;

	public StorageSCP() {
		/**
		 * support all the transfer uids
		 */
		super("*");
	}

	/**
	 * Overwrite {@link StorageService#cstore} to send delayed C-STORE RSP by
	 * separate Thread, so reading of following received C-STORE RQs from the
	 * open association is not blocked.
	 */
	@Override
	protected void store(Association as, PresentationContext pc, Attributes rq,
			PDVInputStream data, Attributes rsp) throws IOException {

		logger.info("1. Get the server partition from the application entity");
		ServerPartition serverPartition = getServerPartition(as);

		logger.info("2. Get the remote device from the aeTitle "
				+ as.getCallingAET() + " to the aeTitle " + as.getCalledAET());
		com.axonmed.xds.source.model.Device remoteDevice = getRemoteDevice(as,
				serverPartition);

		logger.info("3. Get the right file system to store the images.");
		ServerFilesystemInfo serverFilesystemInfo = getServerFileSystemInfo();

		String tempFileName = FilenameUtils
				.concat(serverFilesystemInfo.getTempDir(), UUID.randomUUID()
						.toString());
		logger.info("4. Write the dicom inputstream to the temp folder:"
				+ tempFileName);
		Attributes dicomHeader = write2TempFile(as, pc, rq, data,
				serverFilesystemInfo, tempFileName);

		String transferSyntaxUID = dicomHeader.getString(Tag.TransferSyntaxUID);
		String studyInstanceUid = dicomHeader.getString(Tag.StudyInstanceUID);
		String seriesInstanceUid = dicomHeader.getString(Tag.SeriesInstanceUID);
		String sopInstanceUid = dicomHeader.getString(Tag.SOPInstanceUID);
		String studyDate = dicomHeader.getString(Tag.StudyDate);

		StudyStorageLocation studyLocation = null;
		String failureMessage = null;
		try {
			studyLocation = getWritableOnlineStorage(serverPartition,
					studyInstanceUid, studyDate, transferSyntaxUID,
					serverFilesystemInfo);

			String finalDest = studyLocation.getSopInstancePath(
					seriesInstanceUid, sopInstanceUid);

			if (hasUnprocessedCopy(studyLocation.getId(), seriesInstanceUid,
					sopInstanceUid)) {
				failureMessage = String
						.format("Another copy of the SOP Instance was received but has not been processed: %s",
								sopInstanceUid);
				logger.error(failureMessage);
				throw new DicomServiceException(Status.DuplicateSOPinstance,
						failureMessage);
			}
			File finalDestFile = new File(finalDest);
			if (finalDestFile.exists()) {
				String reconcileSopInstancePath = FilenameUtils.concat(
						serverFilesystemInfo.getReconcileStorageFolder(),
						studyLocation.getReconcileSopInstancePath(
								remoteDevice.getAeTitle(), studyInstanceUid,
								seriesInstanceUid, sopInstanceUid));
				handleDuplicate(serverPartition, sopInstanceUid,
						seriesInstanceUid, studyInstanceUid, tempFileName,
						reconcileSopInstancePath, remoteDevice, studyLocation);

			} else {
				handleNonDuplicate(seriesInstanceUid, sopInstanceUid,
						studyLocation, tempFileName, finalDest, remoteDevice);
			}
		} catch (NoWritableFilesystemException e) {
			failureMessage = String
					.format("Unable to process image, no writable filesystem found for Study UID %s.",
							sopInstanceUid);
			logger.error(failureMessage);
			throw new DicomServiceException(Status.ProcessingFailure,
					failureMessage);
		} catch (StudyIsNearlineException e) {
			failureMessage = e.isRestoreRequested() ? String.format(
					"%s. Restore has been requested.", e.getMessage()) : e
					.getMessage();

			logger.error(failureMessage);
			throw new DicomServiceException(Status.ProcessingFailure,
					failureMessage);
		} catch (StudyNotFoundException e) {
			failureMessage = String.format("%s.  Rolling back operation.",
					e.getMessage());
			logger.error(failureMessage);
			throw new DicomServiceException(Status.ProcessingFailure,
					failureMessage);
		}

	}

	private void handleDuplicate(ServerPartition currentServerPartition,
			String sopInstanceUid, String seriesInstanceUid,
			String studyInstanceUid,  String tempFileName,
			String reconcileSopInstancePath, Device remoteDevice,
			StudyStorageLocation studyLocation) throws IOException {
		Study study = studyService.findStudy(studyInstanceUid, currentServerPartition.getId());

		if (study != null) {
			logger.info(String
					.format("Received duplicate SOP %s (A#:%s StudyUid:%s  Patient: %s  ID:%s)",
							sopInstanceUid, study.getAccessionNumber(),
							study.getStudyInstanceUid(),
							study.getPatientsName(), study.getPatientId()));
		} else {
			logger.info(String
					.format("Received duplicate SOP %s (StudyUid:%s). Existing files haven't been processed.",
							sopInstanceUid, studyInstanceUid));
		}
		String failureMessage;

		if (DuplicateSopPolicyEnum.SendSuccess.getLookup().equals(
				currentServerPartition.getDuplicateSopPolicy())) {
			logger.info(String
					.format("Duplicate SOP Instance received, sending success response %s",
							sopInstanceUid));
			return;
		}
		if (DuplicateSopPolicyEnum.RejectDuplicates.getLookup().equals(
				currentServerPartition.getDuplicateSopPolicy())) {
			failureMessage = String.format(
					"Duplicate SOP Instance received, rejecting %s",
					sopInstanceUid);
			logger.error(failureMessage);
			throw new DicomServiceException(Status.DuplicateSOPinstance,
					failureMessage);
		}
		if (DuplicateSopPolicyEnum.CompareDuplicates.getLookup().equals(
				currentServerPartition.getDuplicateSopPolicy())) {
			FileUtils.moveFile(new File(tempFileName), new File(reconcileSopInstancePath));

			Map<String, Object> parms = new HashMap<String, Object>();
			parms.put("deviceId", remoteDevice.getId());
			parms.put("scheduledTime", new Date());
			parms.put("seriesInstanceUid", seriesInstanceUid);
			parms.put("serverPartitionId", studyLocation.getServerPartitionId());
			parms.put("sopInstanceUid", sopInstanceUid);
			parms.put("studyStorageId", studyLocation.getId());
			
			parms.put("duplicate", true);
			parms.put("studyStorageId", "dup");
			parms.put("uidGroupId", remoteDevice.getAeTitle());

			parms.put("WorkQueueTypeEnum",
					WorkQueueTypeEnum.StudyProcess.getLookup());
			workQueueService.insertWorkQueue(parms);
		} else {
			failureMessage = String
					.format("Duplicate SOP Instance received. Unsupported duplicate policy %s.",
							currentServerPartition.getDuplicateSopPolicy());
			logger.error(failureMessage);
			throw new DicomServiceException(Status.DuplicateSOPinstance,
					failureMessage);
		}

	}

	private void handleNonDuplicate(String seriesInstanceUid,
			String sopInstanceUid, StudyStorageLocation studyLocation,
			String tempFileName, String finalDest, Device remoteDevice)
			throws IOException {
		FileUtils.moveFile(new File(tempFileName), new File(finalDest));

		Map<String, Object> parms = new HashMap<String, Object>();
		parms.put("deviceId", remoteDevice.getId());
		parms.put("scheduledTime", new Date());
		parms.put("seriesInstanceUid", seriesInstanceUid);
		parms.put("serverPartitionId", studyLocation.getServerPartitionId());
		parms.put("sopInstanceUid", sopInstanceUid);
		parms.put("studyStorageId", studyLocation.getId());
		parms.put("WorkQueueTypeEnum",
				WorkQueueTypeEnum.StudyProcess.getLookup());
		workQueueService.insertWorkQueue(parms);

	}

	private boolean hasUnprocessedCopy(long studyStorageId,
			String seriesInstanceUid, String sopInstanceUid) {
		if (workQueueService.workQueueUidExists(studyStorageId,
				seriesInstanceUid, sopInstanceUid))
			return true;
		return studyIntegrityQueueService.studyIntegrityUidExists(
				studyStorageId, seriesInstanceUid, sopInstanceUid);
	}

	private StudyStorageLocation getWritableOnlineStorage(
			ServerPartition serverPartition, String studyInstanceUid,
			String studyDate, String transferSyntaxUID,
			ServerFilesystemInfo serverFilesystemInfo)
			throws NoWritableFilesystemException, StudyIsNearlineException,
			StudyNotFoundException {
		StudyStorageLocation studyLocation = filesystemService
				.getOrCreateWritableStudyStorageLocation(
						serverPartition.getId(), studyInstanceUid, studyDate,
						transferSyntaxUID, serverFilesystemInfo);

		return studyLocation;
	}

	private Attributes write2TempFile(Association as, PresentationContext pc,
			Attributes rq, PDVInputStream data,
			ServerFilesystemInfo serverFilesystemInfo, String tempFileName)
			throws DicomServiceException, FileNotFoundException {
		String cuid = rq.getString(Tag.AffectedSOPClassUID);
		String iuid = rq.getString(Tag.AffectedSOPInstanceUID);
		String tsuid = pc.getTransferSyntax();
		Attributes fileMetaInformation = as.createFileMetaInformation(iuid,
				cuid, tsuid);
		DicomStreamWriteCallback newDicomStreamWriteCallback = new DicomStreamWriteCallback();

		newDicomStreamWriteCallback.setFileMetaInfoObject(fileMetaInformation);
		newDicomStreamWriteCallback
				.doWrite(data, new FileOutputStream(new File(
						"src/test/resources/sample_files/test1/image115.dcm")));

		newDicomStreamWriteCallback.doWrite(data, new FileOutputStream(
				tempFileName));

		Attributes dicomHeader = newDicomStreamWriteCallback.getDicomHeader();
		if (dicomHeader == null) {
			throw new DicomServiceException(Status.ProcessingFailure,
					"Can not get the Dicom header");
		}

		return dicomHeader;
	}

	private ServerFilesystemInfo getServerFileSystemInfo()
			throws DicomServiceException {
		ServerFilesystemInfo serverFilesystemInfo = filesystemService
				.selectFilesystem();
		if (serverFilesystemInfo == null) {
			throw new DicomServiceException(Status.ProcessingFailure,
					"Can not get the file system.");
		}
		return serverFilesystemInfo;
	}

	private com.axonmed.xds.source.model.Device getRemoteDevice(Association as,
			ServerPartition serverPartition) throws DicomServiceException {
		com.axonmed.xds.source.model.Device remoteDevice = null;

		SocketAddress remoteSocketAddress = as.getSocket()
				.getRemoteSocketAddress();

		if (remoteSocketAddress instanceof InetSocketAddress) {
			InetSocketAddress inetSocketAddress = (InetSocketAddress) remoteSocketAddress;
			remoteDevice = deviceService.lookupDevice(serverPartition, as
					.getCallingAET(), inetSocketAddress.getAddress()
					.getHostAddress());
		} else {
			throw new DicomServiceException(Status.ProcessingFailure,
					"Can not get the Dicom header");
		}

		if (remoteDevice == null) {
			throw new DicomServiceException(Status.ProcessingFailure,
					"Can not get the remote device");

		}
		return remoteDevice;
	}

	private ServerPartition getServerPartition(Association as)
			throws DicomServiceException {
		ApplicationEntity ae = as.getApplicationEntity();

		com.axonmed.xds.source.dto.ArchiveAEExtension archiveAEExtension = ae
				.getAEExtension(com.axonmed.xds.source.dto.ArchiveAEExtension.class);

		if (archiveAEExtension == null) {
			logger.error("should configure the applicaion entity extension");
			throw new DicomServiceException(Status.ProcessingFailure,
					"should configure the applicaion entity extension");
		}

		ServerPartition serverPartition = archiveAEExtension
				.getServerPartition();

		if (serverPartition == null) {
			logger.error("should configure the server partition");
			throw new DicomServiceException(Status.ProcessingFailure,
					"should configure the server partition");
		}
		return serverPartition;
	}

	private void storeTo(Association as, Attributes fmi, PDVInputStream data,
			File file) throws IOException {
		logger.info("{}: M-WRITE {}", as, file);
		file.getParentFile().mkdirs();
		DicomOutputStream out = new DicomOutputStream(file);
		try {
			out.writeFileMetaInformation(fmi);
			data.copyTo(out);
		} finally {
			SafeClose.close(out);
		}
	}

	private void renameTo(Association as, File from, File dest)
			throws IOException {
		logger.info("{}: M-RENAME {}", new Object[] { as, from, dest });
		dest.getParentFile().mkdirs();
		if (!from.renameTo(dest))
			throw new IOException("Failed to rename " + from + " to " + dest);
	}

	private void deleteFile(Association as, File file) {
		if (file.delete())
			logger.info("{}: M-DELETE {}", as, file);
		else
			logger.warn("{}: M-DELETE {} failed!", as, file);
	}

}