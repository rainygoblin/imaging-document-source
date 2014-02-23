package com.axonmed.xds.source.model;

import java.util.Date;

import com.axonmed.xds.source.enumeration.RestoreQueueStatusEnum;

public class RestoreQueue {
	private long id;
	private long archiveStudyStorageId;
	private long studyStorageId;
	private Date scheduledTime;
	private RestoreQueueStatusEnum restoreQueueStatusEnum;
	private String processorId;
	private String failureDescription;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getArchiveStudyStorageId() {
		return archiveStudyStorageId;
	}

	public void setArchiveStudyStorageId(long archiveStudyStorageId) {
		this.archiveStudyStorageId = archiveStudyStorageId;
	}

	public long getStudyStorageId() {
		return studyStorageId;
	}

	public void setStudyStorageId(long studyStorageId) {
		this.studyStorageId = studyStorageId;
	}

	public Date getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(Date scheduledTime) {
		this.scheduledTime = scheduledTime;
	}


	public String getProcessorId() {
		return processorId;
	}

	public void setProcessorId(String processorId) {
		this.processorId = processorId;
	}

	public String getFailureDescription() {
		return failureDescription;
	}

	public void setFailureDescription(String failureDescription) {
		this.failureDescription = failureDescription;
	}

}