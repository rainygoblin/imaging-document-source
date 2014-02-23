package com.axonmed.xds.source.model;

public class WorkQueueUid implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 643336087361686223L;
	private long id;
	private long workQueueId;
	private String seriesInstanceUid;
	private String sopInstanceUid;
	private boolean failed;
	private boolean duplicate;
	private String extension;
	private short failureCount;
	private String groupID;
	private String relativePath;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getWorkQueueId() {
		return workQueueId;
	}

	public void setWorkQueueId(long workQueueId) {
		this.workQueueId = workQueueId;
	}

	public String getSeriesInstanceUid() {
		return seriesInstanceUid;
	}

	public void setSeriesInstanceUid(String seriesInstanceUid) {
		this.seriesInstanceUid = seriesInstanceUid;
	}

	public String getSopInstanceUid() {
		return sopInstanceUid;
	}

	public void setSopInstanceUid(String sopInstanceUid) {
		this.sopInstanceUid = sopInstanceUid;
	}

	public boolean isFailed() {
		return failed;
	}

	public void setFailed(boolean failed) {
		this.failed = failed;
	}

	public boolean isDuplicate() {
		return duplicate;
	}

	public void setDuplicate(boolean duplicate) {
		this.duplicate = duplicate;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public short getFailureCount() {
		return failureCount;
	}

	public void setFailureCount(short failureCount) {
		this.failureCount = failureCount;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

}