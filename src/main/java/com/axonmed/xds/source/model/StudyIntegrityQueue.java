package com.axonmed.xds.source.model;

import java.util.Date;


public class StudyIntegrityQueue {
	private long id;
	private long serverPartitionId;
	private long studyStorageId;
	private Date insertTime;
	private String description;
	private String studyData;
	private String details;
	private String studyIntegrityReasonEnum;
	private String groupID;
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
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStudyData() {
		return studyData;
	}
	public void setStudyData(String studyData) {
		this.studyData = studyData;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getStudyIntegrityReasonEnum() {
		return studyIntegrityReasonEnum;
	}
	public void setStudyIntegrityReasonEnum(String studyIntegrityReasonEnum) {
		this.studyIntegrityReasonEnum = studyIntegrityReasonEnum;
	}
	public String getGroupID() {
		return groupID;
	}
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}


}