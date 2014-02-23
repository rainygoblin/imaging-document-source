package com.axonmed.xds.source.model;

import com.axonmed.xds.source.enumeration.QueueStudyStateEnum;
import com.axonmed.xds.source.enumeration.WorkQueuePriorityEnum;
import com.axonmed.xds.source.enumeration.WorkQueueTypeEnum;

public class WorkQueueTypeProperties {
	private long id;
	private WorkQueueTypeEnum workQueueTypeEnum;
	private WorkQueuePriorityEnum workQueuePriorityEnum;
	private boolean memoryLimited;
	private boolean alertFailedWorkQueue;
	private int maxFailureCount;
	private int processDelaySeconds;
	private int failureDelaySeconds;
	private int deleteDelaySeconds;
	private int postponeDelaySeconds;
	private int expireDelaySeconds;
	private int maxBatchSize;
	private QueueStudyStateEnum queueStudyStateEnum;
	private short queueStudyStateOrder;
	private boolean readLock;
	private boolean writeLock;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public WorkQueueTypeEnum getWorkQueueTypeEnum() {
		return workQueueTypeEnum;
	}

	public void setWorkQueueTypeEnum(WorkQueueTypeEnum workQueueTypeEnum) {
		this.workQueueTypeEnum = workQueueTypeEnum;
	}

	public WorkQueuePriorityEnum getWorkQueuePriorityEnum() {
		return workQueuePriorityEnum;
	}

	public void setWorkQueuePriorityEnum(
			WorkQueuePriorityEnum workQueuePriorityEnum) {
		this.workQueuePriorityEnum = workQueuePriorityEnum;
	}

	public boolean isMemoryLimited() {
		return memoryLimited;
	}

	public void setMemoryLimited(boolean memoryLimited) {
		this.memoryLimited = memoryLimited;
	}

	public boolean isAlertFailedWorkQueue() {
		return alertFailedWorkQueue;
	}

	public void setAlertFailedWorkQueue(boolean alertFailedWorkQueue) {
		this.alertFailedWorkQueue = alertFailedWorkQueue;
	}

	public int getMaxFailureCount() {
		return maxFailureCount;
	}

	public void setMaxFailureCount(int maxFailureCount) {
		this.maxFailureCount = maxFailureCount;
	}

	public int getProcessDelaySeconds() {
		return processDelaySeconds;
	}

	public void setProcessDelaySeconds(int processDelaySeconds) {
		this.processDelaySeconds = processDelaySeconds;
	}

	public int getFailureDelaySeconds() {
		return failureDelaySeconds;
	}

	public void setFailureDelaySeconds(int failureDelaySeconds) {
		this.failureDelaySeconds = failureDelaySeconds;
	}

	public int getDeleteDelaySeconds() {
		return deleteDelaySeconds;
	}

	public void setDeleteDelaySeconds(int deleteDelaySeconds) {
		this.deleteDelaySeconds = deleteDelaySeconds;
	}

	public int getPostponeDelaySeconds() {
		return postponeDelaySeconds;
	}

	public void setPostponeDelaySeconds(int postponeDelaySeconds) {
		this.postponeDelaySeconds = postponeDelaySeconds;
	}

	public int getExpireDelaySeconds() {
		return expireDelaySeconds;
	}

	public void setExpireDelaySeconds(int expireDelaySeconds) {
		this.expireDelaySeconds = expireDelaySeconds;
	}

	public int getMaxBatchSize() {
		return maxBatchSize;
	}

	public void setMaxBatchSize(int maxBatchSize) {
		this.maxBatchSize = maxBatchSize;
	}

	public QueueStudyStateEnum getQueueStudyStateEnum() {
		return queueStudyStateEnum;
	}

	public void setQueueStudyStateEnum(QueueStudyStateEnum queueStudyStateEnum) {
		this.queueStudyStateEnum = queueStudyStateEnum;
	}

	public short getQueueStudyStateOrder() {
		return queueStudyStateOrder;
	}

	public void setQueueStudyStateOrder(short queueStudyStateOrder) {
		this.queueStudyStateOrder = queueStudyStateOrder;
	}

	public boolean isReadLock() {
		return readLock;
	}

	public void setReadLock(boolean readLock) {
		this.readLock = readLock;
	}

	public boolean isWriteLock() {
		return writeLock;
	}

	public void setWriteLock(boolean writeLock) {
		this.writeLock = writeLock;
	}

}