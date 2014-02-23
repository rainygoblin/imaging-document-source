package com.axonmed.xds.source.model;


public class StudyIntegrityQueueUid {
	private long id;
	private long studyIntegrityQueueId;
	private String seriesDescription;
	private String seriesInstanceUid;
	private String sopInstanceUid;
	private String relativePath;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStudyIntegrityQueueId() {
		return studyIntegrityQueueId;
	}

	public void setStudyIntegrityQueueId(long studyIntegrityQueueId) {
		this.studyIntegrityQueueId = studyIntegrityQueueId;
	}

	public String getSeriesDescription() {
		return seriesDescription;
	}

	public void setSeriesDescription(String seriesDescription) {
		this.seriesDescription = seriesDescription;
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

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

}