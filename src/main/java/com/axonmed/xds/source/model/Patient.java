package com.axonmed.xds.source.model;


import java.util.ArrayList;
import java.util.List;

public class Patient {
	private Integer id;
	private ServerPartition serverPartition;
	private String patientsName;
	private String patientId;
	private String issuerOfPatientId;
	private int numberOfPatientRelatedStudies;
	private int numberOfPatientRelatedSeries;
	private int numberOfPatientRelatedInstances;
	private String specificCharacterSet;
	private List<Study> studies = new ArrayList<Study>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ServerPartition getServerPartition() {
		return serverPartition;
	}

	public void setServerPartition(ServerPartition serverPartition) {
		this.serverPartition = serverPartition;
	}

	public String getPatientsName() {
		return patientsName;
	}

	public void setPatientsName(String patientsName) {
		this.patientsName = patientsName;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getIssuerOfPatientId() {
		return issuerOfPatientId;
	}

	public void setIssuerOfPatientId(String issuerOfPatientId) {
		this.issuerOfPatientId = issuerOfPatientId;
	}

	public int getNumberOfPatientRelatedStudies() {
		return numberOfPatientRelatedStudies;
	}

	public void setNumberOfPatientRelatedStudies(
			int numberOfPatientRelatedStudies) {
		this.numberOfPatientRelatedStudies = numberOfPatientRelatedStudies;
	}

	public int getNumberOfPatientRelatedSeries() {
		return numberOfPatientRelatedSeries;
	}

	public void setNumberOfPatientRelatedSeries(int numberOfPatientRelatedSeries) {
		this.numberOfPatientRelatedSeries = numberOfPatientRelatedSeries;
	}

	public int getNumberOfPatientRelatedInstances() {
		return numberOfPatientRelatedInstances;
	}

	public void setNumberOfPatientRelatedInstances(
			int numberOfPatientRelatedInstances) {
		this.numberOfPatientRelatedInstances = numberOfPatientRelatedInstances;
	}

	public String getSpecificCharacterSet() {
		return specificCharacterSet;
	}

	public void setSpecificCharacterSet(String specificCharacterSet) {
		this.specificCharacterSet = specificCharacterSet;
	}

	public List<Study> getStudies() {
		return studies;
	}

	public void setStudies(List<Study> studies) {
		this.studies = studies;
	}

}