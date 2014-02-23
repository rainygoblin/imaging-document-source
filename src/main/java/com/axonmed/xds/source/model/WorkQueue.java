package com.axonmed.xds.source.model;

import java.util.Date;

import com.axonmed.xds.source.enumeration.WorkQueuePriorityEnum;
import com.axonmed.xds.source.enumeration.WorkQueueStatusEnum;
import com.axonmed.xds.source.enumeration.WorkQueueTypeEnum;

public class WorkQueue {
	private long id;
	private long serverPartitionId;
	private long studyStorageId;
	private long deviceId;
	private long studyHistoryId;
	private WorkQueueTypeEnum workQueueTypeEnum;
	private WorkQueueStatusEnum workQueueStatusEnum;
	private WorkQueuePriorityEnum workQueuePriorityEnum;
	private String processorID;
	private String groupID;
	private Date expirationTime;
	private Date scheduledTime;
	private Date insertTime;
	private Date lastUpdatedTime;
	private short failureCount;
	private String failureDescription;
	private String data;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getServerPartitionId() {
		return serverPartitionId;
	}

	public void setServerPartitionId(long serverPartitionId) {
		this.serverPartitionId = serverPartitionId;
	}

	public long getStudyStorageId() {
		return studyStorageId;
	}

	public void setStudyStorageId(long studyStorageId) {
		this.studyStorageId = studyStorageId;
	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public long getStudyHistoryId() {
		return studyHistoryId;
	}

	public void setStudyHistoryId(long studyHistoryId) {
		this.studyHistoryId = studyHistoryId;
	}

	public WorkQueueTypeEnum getWorkQueueTypeEnum() {
		return workQueueTypeEnum;
	}

	public void setWorkQueueTypeEnum(WorkQueueTypeEnum workQueueTypeEnum) {
		this.workQueueTypeEnum = workQueueTypeEnum;
	}

	public WorkQueueStatusEnum getWorkQueueStatusEnum() {
		return workQueueStatusEnum;
	}

	public void setWorkQueueStatusEnum(WorkQueueStatusEnum workQueueStatusEnum) {
		this.workQueueStatusEnum = workQueueStatusEnum;
	}

	public WorkQueuePriorityEnum getWorkQueuePriorityEnum() {
		return workQueuePriorityEnum;
	}

	public void setWorkQueuePriorityEnum(
			WorkQueuePriorityEnum workQueuePriorityEnum) {
		this.workQueuePriorityEnum = workQueuePriorityEnum;
	}

	public String getProcessorID() {
		return processorID;
	}

	public void setProcessorID(String processorID) {
		this.processorID = processorID;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	public Date getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(Date scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public short getFailureCount() {
		return failureCount;
	}

	public void setFailureCount(short failureCount) {
		this.failureCount = failureCount;
	}

	public String getFailureDescription() {
		return failureDescription;
	}

	public void setFailureDescription(String failureDescription) {
		this.failureDescription = failureDescription;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
