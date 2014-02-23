package com.axonmed.xds.source.model;


import java.util.Date;

public class ArchiveQueue {
	private long guid;
	private long partitionArchiveId;
	private Date scheduledTime;
	private long studyStorageId;
	private String archiveQueueStatusEnum;
	private String processorId;
	private String failureDescription;

	public long getGuid() {
		return guid;
	}

	public void setGuid(long guid) {
		this.guid = guid;
	}

	public long getPartitionArchiveId() {
		return partitionArchiveId;
	}

	public void setPartitionArchiveId(long partitionArchiveId) {
		this.partitionArchiveId = partitionArchiveId;
	}

	public Date getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(Date scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public long getStudyStorageId() {
		return studyStorageId;
	}

	public void setStudyStorageId(long studyStorageId) {
		this.studyStorageId = studyStorageId;
	}

	public String getArchiveQueueStatusEnum() {
		return archiveQueueStatusEnum;
	}

	public void setArchiveQueueStatusEnum(String archiveQueueStatusEnum) {
		this.archiveQueueStatusEnum = archiveQueueStatusEnum;
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