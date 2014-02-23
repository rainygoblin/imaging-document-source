package com.axonmed.xds.source.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axonmed.xds.source.bo.ServerFilesystemInfo;
import com.axonmed.xds.source.bo.StudyStorageLocation;
import com.axonmed.xds.source.enumeration.QueueStudyStateEnum;
import com.axonmed.xds.source.enumeration.StudyStatusEnum;
import com.axonmed.xds.source.exception.NoWritableFilesystemException;
import com.axonmed.xds.source.exception.StudyIsNearlineException;
import com.axonmed.xds.source.exception.StudyNotFoundException;
import com.axonmed.xds.source.model.Filesystem;
import com.axonmed.xds.source.model.RestoreQueue;
import com.axonmed.xds.source.model.ServerPartition;
import com.axonmed.xds.source.model.ServerTransferSyntax;
import com.axonmed.xds.source.model.StudyStorage;
import com.axonmed.xds.source.repository.FilesystemMapper;
import com.axonmed.xds.source.repository.RestoreQueueMapper;
import com.axonmed.xds.source.repository.ServerPartitionMapper;
import com.axonmed.xds.source.repository.ServerTransferSyntaxMapper;
import com.axonmed.xds.source.repository.StudyStorageMapper;

@Service
@Transactional(readOnly = true)
public class FilesystemService {
	private static final Logger logger = LoggerFactory
			.getLogger(FilesystemService.class);

	@Autowired
	private FilesystemMapper filesystemMapper;

	@Autowired
	private ServerTransferSyntaxMapper serverTransferSyntaxMapper;

	@Autowired
	private StudyStorageMapper studyStorageMapper;

	@Autowired
	private ServerPartitionMapper serverPartitionMapper;

	@Autowired
	private RestoreQueueMapper restoreQueueMapper;

	/**
	 * select the writable max free file system
	 * 
	 * @return
	 */
	public ServerFilesystemInfo selectFilesystem() {
		ServerFilesystemInfo result = null;
		List<Filesystem> filesystems = filesystemMapper.loadAll();
		if (filesystems != null) {
			for (Filesystem filesystem : filesystems) {
				if (filesystem.isWriteOnly()) {
					ServerFilesystemInfo serverFilesystemInfo = new ServerFilesystemInfo(
							filesystem);
					if (result != null) {
						if (serverFilesystemInfo.getFreeBytes() > result
								.getFreeBytes()) {
							result = serverFilesystemInfo;
						}
					} else {
						result = serverFilesystemInfo;
					}
				}

			}
		}
		return result;
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional
	public StudyStorageLocation getOrCreateWritableStudyStorageLocation(
			long serverPartitionId, String studyInstanceUid, String studyDate,
			String syntax, ServerFilesystemInfo serverFilesystemInfo)
			throws NoWritableFilesystemException, StudyIsNearlineException {
		StudyStorageLocation location = null;
		try {
			location = getWritableStudyStorageLocation(serverPartitionId,
					studyInstanceUid, true);
			if (location != null)
				return location;
		} catch (StudyNotFoundException e) {
			logger.error("Get the writeable study localtion error.", e);
		}

		StudyStatusEnum studyStatusEnum = null;

		List<ServerTransferSyntax> serverTransferSyntaxs = serverTransferSyntaxMapper
				.loadAll();
		for (ServerTransferSyntax serverTransferSyntax : serverTransferSyntaxs) {
			if (serverTransferSyntax.getUid().equals(syntax)) {
				if (serverTransferSyntax.isLossless()) {
					studyStatusEnum = StudyStatusEnum.OnlineLossless;
					break;
				} else {
					studyStatusEnum = StudyStatusEnum.OnlineLossy;
					break;
				}
			}
		}
		if (studyStatusEnum == null) {
			studyStatusEnum = StudyStatusEnum.Online;
		}

		Map<String, Object> insertStudyStorageParameters = new HashMap<String, Object>();
		insertStudyStorageParameters
				.put("serverPartitionId", serverPartitionId);
		insertStudyStorageParameters.put("studyInstanceUid", studyInstanceUid);
		insertStudyStorageParameters.put("folder", studyDate);
		insertStudyStorageParameters.put("filesystemId", serverFilesystemInfo
				.getFilesystem().getId());
		insertStudyStorageParameters.put("queueStudyStateEnum",
				QueueStudyStateEnum.Idle.getLookup());
		insertStudyStorageParameters.put("transferSyntaxUid", syntax);
		insertStudyStorageParameters.put("studyStatusEnum",
				studyStatusEnum);

		studyStorageMapper.insertStudyStorage(insertStudyStorageParameters);
		List<StudyStorageLocation> locationList = (List<StudyStorageLocation>) insertStudyStorageParameters
				.get("curResult");

		if (locationList != null && locationList.size() > 0) {
			location = locationList.get(0);
			loadStudyLocation(location);
		}
		return location;

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public StudyStorageLocation getWritableStudyStorageLocation(
			long serverPartitionId, String studyInstanceUid, boolean restore)
			throws StudyIsNearlineException, StudyNotFoundException {
		StudyStorageLocation location = null;
		Map<String, Object> studyStorageLocationQueryParameters = new HashMap<String, Object>();
		studyStorageLocationQueryParameters.put("serverPartitionId",
				serverPartitionId);
		studyStorageLocationQueryParameters.put("studyInstanceUid",
				studyInstanceUid);

		studyStorageMapper
				.queryStudyStorageLocation(studyStorageLocationQueryParameters);
		List<StudyStorageLocation> locationList = (List<StudyStorageLocation>) studyStorageLocationQueryParameters
				.get("curResult");
		for (StudyStorageLocation studyLocation : locationList) {
			if (studyLocation.isWriteOnly()) {
				location = studyLocation;
				if (location != null) {
					loadStudyLocation(location);

					if (location.getQueueStudyStateEnum() != QueueStudyStateEnum.Idle
							&& location.getQueueStudyStateEnum() != QueueStudyStateEnum.ProcessingScheduled) {
						String failureMessage = String
								.format("Study %s on partition %s is being processed: %s, can't accept new images.",
										studyInstanceUid, serverPartitionId,
										location.getQueueStudyStateEnum());
						logger.error(failureMessage);
						location = null;
					}
				}
				return location;
			}

		}

		checkForStudyRestore(serverPartitionId, studyInstanceUid, restore);
		return location;

	}

	@SuppressWarnings("unchecked")
	private void checkForStudyRestore(long partitionId,
			String studyInstanceUid, boolean restore)
			throws StudyIsNearlineException, StudyNotFoundException {
		Map<String, Object> parms = new HashMap<String, Object>();
		parms.put("studyInstanceUid", studyInstanceUid);
		parms.put("serverPartitionId", partitionId);
		StudyStorage storage = studyStorageMapper
				.findByStudyInstanceUidAndServerPartitionId(parms);
		if (storage != null) {
			if (restore == true) {
				Map<String, Object> insertRestoreQueueParameters = new HashMap<String, Object>();
				insertRestoreQueueParameters.put("studyStorageId",
						storage.getId());

				restoreQueueMapper
						.insertRestoreQueue(insertRestoreQueueParameters);
				List<RestoreQueue> restoreQueues = (List<RestoreQueue>) insertRestoreQueueParameters
						.get("curResult");

				if (restoreQueues != null && restoreQueues.size() > 1)
					throw new StudyIsNearlineException(true);
			}

			throw new StudyIsNearlineException(false);
		}

		throw new StudyNotFoundException(studyInstanceUid);
	}

	private void loadStudyLocation(StudyStorageLocation studyStorageLocation) {
		ServerPartition serverPartition = serverPartitionMapper
				.findById(studyStorageLocation.getServerPartitionId());
		if (serverPartition != null) {
			studyStorageLocation.setServerPartition(serverPartition);
		}

		StudyStorage studyStorage = studyStorageMapper
				.findById(studyStorageLocation.getId());
		if (studyStorage != null) {
			studyStorageLocation.setStudyStorage(studyStorage);
		}

	}

}