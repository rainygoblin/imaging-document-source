package com.axonmed.xds.source.model;

import java.util.Date;

import com.axonmed.xds.source.enumeration.QueueStudyStateEnum;
import com.axonmed.xds.source.enumeration.StudyStatusEnum;

public class StudyStorage {
	private long id;
	private ServerPartition serverPartition;
	private String studyInstanceUid;
	private Date insertTime;
	private Date lastAccessedTime;
	private boolean writeLock;
	private short readLock;
	private StudyStatusEnum studyStatusEnum;
	private QueueStudyStateEnum queueStudyStateEnum;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ServerPartition getServerPartition() {
		return serverPartition;
	}

	public void setServerPartition(ServerPartition serverPartition) {
		this.serverPartition = serverPartition;
	}

	public String getStudyInstanceUid() {
		return studyInstanceUid;
	}

	public void setStudyInstanceUid(String studyInstanceUid) {
		this.studyInstanceUid = studyInstanceUid;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getLastAccessedTime() {
		return lastAccessedTime;
	}

	public void setLastAccessedTime(Date lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

	public boolean isWriteLock() {
		return writeLock;
	}

	public void setWriteLock(boolean writeLock) {
		this.writeLock = writeLock;
	}

	public short getReadLock() {
		return readLock;
	}

	public void setReadLock(short readLock) {
		this.readLock = readLock;
	}

	public StudyStatusEnum getStudyStatusEnum() {
		return studyStatusEnum;
	}

	public void setStudyStatusEnum(StudyStatusEnum studyStatusEnum) {
		this.studyStatusEnum = studyStatusEnum;
	}

	public QueueStudyStateEnum getQueueStudyStateEnum() {
		return queueStudyStateEnum;
	}

	public void setQueueStudyStateEnum(QueueStudyStateEnum queueStudyStateEnum) {
		this.queueStudyStateEnum = queueStudyStateEnum;
	}

}