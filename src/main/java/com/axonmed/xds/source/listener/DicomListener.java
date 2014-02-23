package com.axonmed.xds.source.listener;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.dcm4che.data.Attributes;
import org.dcm4che.data.Tag;
import org.dcm4che.data.VR;
import org.dcm4che.io.DicomOutputStream;
import org.dcm4che.net.ApplicationEntity;
import org.dcm4che.net.Association;
import org.dcm4che.net.Connection;
import org.dcm4che.net.Device;
import org.dcm4che.net.PDVInputStream;
import org.dcm4che.net.Status;
import org.dcm4che.net.TransferCapability;
import org.dcm4che.net.pdu.PresentationContext;
import org.dcm4che.net.service.BasicCEchoSCP;
import org.dcm4che.net.service.BasicCStoreSCP;
import org.dcm4che.net.service.DicomService;
import org.dcm4che.net.service.DicomServiceException;
import org.dcm4che.net.service.DicomServiceRegistry;
import org.dcm4che.util.SafeClose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import com.axonmed.xds.source.model.ServerPartition;
import com.axonmed.xds.source.repository.ServerPartitionMapper;
import com.axonmed.xds.source.scp.StorageSCP;

/**
 * Thread to start some dicom listeners based on database configuration
 * 
 * @author Kai Zhang
 * @version 6/14/2011
 */
@Component
public class DicomListener extends Thread {
	private static final Logger logger = LoggerFactory
			.getLogger(DicomListener.class);

	private List<Device> workingDevices = new ArrayList<Device>();

	@Resource(name = "deviceTaskExecutor")
	private TaskExecutor taskExecutor;

	@Autowired
	private ServerPartitionMapper serverPartitionMapper;

	@Autowired
	private StorageSCP storageSCP;
	
	@PostConstruct
	public void init() {
		logger.info("Start the Dicom Receive Service to receive dicom message.");
		setDaemon(true);
		setName("DICOM Start Service");
		start();
	}

	@PreDestroy
	public void cleanup() {
		for (Device workingDevice : workingDevices) {
			workingDevice.unbindConnections();
		}
	}

	public void start() {
		List<ServerPartition> serverPartitions = serverPartitionMapper
				.loadAll();
		for (ServerPartition serverPartition : serverPartitions) {
			DicomListenerThread dicomListenerThread = new DicomListenerThread(
					serverPartition);
			taskExecutor.execute(dicomListenerThread);
		}
	}

	private void initTransferCapability(ApplicationEntity ae,
			List<DicomService> dicomServices, boolean isStgcmtEnabled) {

		ae.addTransferCapability(new TransferCapability(null, "*",
				TransferCapability.Role.SCP, "*"));
	}

	private final class DicomListenerThread implements Runnable {

		private ServerPartition serverPartition;

		public DicomListenerThread(ServerPartition serverPartition) {
			this.serverPartition = serverPartition;
		}

		@Override
		public void run() {
			// initial the network connection
			Connection nc = new Connection();
			nc.setPort(serverPartition.getPort());
			nc.setTcpNoDelay(true);

			// initial the ApplicationEntity
			ApplicationEntity ae = new ApplicationEntity(
					serverPartition.getName());
			ae.setAETitle(serverPartition.getAeTitle());
			ae.setAssociationAcceptor(true);
			ae.addConnection(nc);
			List<DicomService> dicomServices = new ArrayList<DicomService>();

			initTransferCapability(ae, dicomServices, false);
			// serverPartition.isStgcmtEnabled());

			// new Device to construct and initial
			Device device = new Device(serverPartition.getName());
			// must first add connection
			device.addConnection(nc);
			// then add the ae
			device.addApplicationEntity(ae);
			device.setDimseRQHandler(createServiceRegistry());
			workingDevices.add(device);

			ExecutorService executorService = Executors.newCachedThreadPool();
			ScheduledExecutorService scheduledExecutorService = Executors
					.newSingleThreadScheduledExecutor();
			device.setScheduledExecutor(scheduledExecutorService);
			device.setExecutor(executorService);
			// start to listening
			try {
				logger.info("start on the port:" + serverPartition.getPort()
						+ ",for the aetitle:" + serverPartition.getAeTitle());
				device.bindConnections();
			} catch (IOException e) {
				logger.error("get error", e);
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private DicomServiceRegistry createServiceRegistry() {
			DicomServiceRegistry serviceRegistry = new DicomServiceRegistry();
			serviceRegistry.addDicomService(new BasicCEchoSCP());
			serviceRegistry.addDicomService(storageSCP);
			return serviceRegistry;
		}

	}

	private final BasicCStoreSCP cstoreSCP = new BasicCStoreSCP("*") {

		@Override
		protected void store(Association as, PresentationContext pc,
				Attributes rq, PDVInputStream data, Attributes rsp)
				throws IOException {
			rsp.setInt(Tag.Status, VR.US, 0);

			String cuid = rq.getString(Tag.AffectedSOPClassUID);
			String iuid = rq.getString(Tag.AffectedSOPInstanceUID);
			String tsuid = pc.getTransferSyntax();
			File file = new File("logs/", iuid + ".part");
			try {
				storeTo(as, as.createFileMetaInformation(iuid, cuid, tsuid),
						data, file);
				renameTo(as, file, new File("logs/", iuid));
			} catch (Exception e) {
				deleteFile(as, file);
				throw new DicomServiceException(Status.ProcessingFailure, e);
			}
		}

	};

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

	private static void renameTo(Association as, File from, File dest)
			throws IOException {
		logger.info("{}: M-RENAME {}", new Object[] { as, from, dest });
		dest.getParentFile().mkdirs();
		if (!from.renameTo(dest))
			throw new IOException("Failed to rename " + from + " to " + dest);
	}

	private static void deleteFile(Association as, File file) {
		if (file.delete())
			logger.info("{}: M-DELETE {}", as, file);
		else
			logger.warn("{}: M-DELETE {} failed!", as, file);
	}
}