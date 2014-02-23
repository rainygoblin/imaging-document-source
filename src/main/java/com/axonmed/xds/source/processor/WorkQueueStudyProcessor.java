package com.axonmed.xds.source.processor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axonmed.xds.source.bo.StudyStorageLocation;
import com.axonmed.xds.source.enumeration.StudyStatusEnum;
import com.axonmed.xds.source.exception.WorkQueueProcessingException;
import com.axonmed.xds.source.model.WorkQueue;
import com.axonmed.xds.source.model.WorkQueueTypeProperties;
import com.axonmed.xds.source.model.WorkQueueUid;
import com.axonmed.xds.source.service.FilesystemService;
import com.axonmed.xds.source.service.WorkQueueService;

@Component
public class WorkQueueStudyProcessor {

	private static final Logger logger = LoggerFactory
			.getLogger(WorkQueueStudyProcessor.class);

	@Autowired
	private FilesystemService filesystemService;

	@Autowired
	private WorkQueueService workQueueService;

	public void process(final WorkQueue workQueue) {
		logger.info("process the study.");
		boolean successful = false;
		boolean idle = false;

		StudyStorageLocation storageLocation = null;//filesystemService
//				.getWritableStudyStorageLocation(workQueue.getStudyStorageId());
		if (storageLocation != null) {

		} else {
			logger.error("Can not get the study storage location according the study storage id:"
					+ workQueue.getStudyStorageId());
		}

		WorkQueueTypeProperties workQueueProperties = workQueueService
				.getWorkQueueProperties(workQueue.getWorkQueueTypeEnum());
		if (workQueueProperties != null) {

		} else {
			logger.error("Can not get the Work Queue Type Properties according the  WorkQueueTypeEnum:"
					+ workQueue.getWorkQueueTypeEnum());
		}

		try {
			checkIfStudyIsLossy(workQueue, storageLocation);

			List<WorkQueueUid> workQueueUidList = workQueueService
					.findWorkQueueUidByWorkQueueId(workQueue.getId());

			if (workQueueUidList != null && workQueueUidList.size() > 0) {

			}
			
			successful = true;
		} catch (WorkQueueProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void checkIfStudyIsLossy(final WorkQueue workQueue,
			final StudyStorageLocation storageLocation)
			throws WorkQueueProcessingException {
		logger.info(String.format("check If Study IsLossy in the %s workQueue",
				workQueue.getId()));

		if (StudyStatusEnum.OnlineLossy == storageLocation.getStudyStatusEnum()
				&& storageLocation.isLatestArchiveLossless()) {
			// This should fail the entry and force user to restore the study
			throw new WorkQueueProcessingException(null,
					"Unexpected study state: the study is lossy compressed.");
		}
	}
}