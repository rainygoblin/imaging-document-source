package com.axonmed.xds.source.model;


public class Series {
	private long id;
	private ServerPartition serverPartition;
	private Study study;
	private String seriesInstanceUid;
	private String modality;
	private String seriesNumber;
	private String seriesDescription;
	private int numberOfSeriesRelatedInstances;
	private String performedProcedureStepStartDate;
	private String performedProcedureStepStartTime;
	private String sourceApplicationEntityTitle;

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

	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	public String getSeriesInstanceUid() {
		return seriesInstanceUid;
	}

	public void setSeriesInstanceUid(String seriesInstanceUid) {
		this.seriesInstanceUid = seriesInstanceUid;
	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public String getSeriesNumber() {
		return seriesNumber;
	}

	public void setSeriesNumber(String seriesNumber) {
		this.seriesNumber = seriesNumber;
	}

	public String getSeriesDescription() {
		return seriesDescription;
	}

	public void setSeriesDescription(String seriesDescription) {
		this.seriesDescription = seriesDescription;
	}

	public int getNumberOfSeriesRelatedInstances() {
		return numberOfSeriesRelatedInstances;
	}

	public void setNumberOfSeriesRelatedInstances(
			int numberOfSeriesRelatedInstances) {
		this.numberOfSeriesRelatedInstances = numberOfSeriesRelatedInstances;
	}

	public String getPerformedProcedureStepStartDate() {
		return performedProcedureStepStartDate;
	}

	public void setPerformedProcedureStepStartDate(
			String performedProcedureStepStartDate) {
		this.performedProcedureStepStartDate = performedProcedureStepStartDate;
	}

	public String getPerformedProcedureStepStartTime() {
		return performedProcedureStepStartTime;
	}

	public void setPerformedProcedureStepStartTime(
			String performedProcedureStepStartTime) {
		this.performedProcedureStepStartTime = performedProcedureStepStartTime;
	}

	public String getSourceApplicationEntityTitle() {
		return sourceApplicationEntityTitle;
	}

	public void setSourceApplicationEntityTitle(
			String sourceApplicationEntityTitle) {
		this.sourceApplicationEntityTitle = sourceApplicationEntityTitle;
	}

}