package com.axonmed.xds.source.model;


import java.util.ArrayList;
import java.util.List;

public class Study {
	private Integer id;
	private ServerPartition serverPartition;
	private StudyStorage studyStorage;
	private Patient patient;
	private String specificCharacterSet;
	private String studyInstanceUid;
	private String patientsName;
	private String patientId;
	private String issuerOfPatientId;
	private String patientsBirthDate;
	private String patientsAge;
	private String patientsSex;
	private String studyDate;
	private String studyTime;
	private String accessionNumber;
	private String studyId;
	private String studyDescription;
	private String referringPhysiciansName;
	private int numberOfStudyRelatedSeries;
	private int numberOfStudyRelatedInstances;
	private long studySizeInKB;
	private List<Series> series = new ArrayList<Series>();

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

	public StudyStorage getStudyStorage() {
		return studyStorage;
	}

	public void setStudyStorage(StudyStorage studyStorage) {
		this.studyStorage = studyStorage;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getSpecificCharacterSet() {
		return specificCharacterSet;
	}

	public void setSpecificCharacterSet(String specificCharacterSet) {
		this.specificCharacterSet = specificCharacterSet;
	}

	public String getStudyInstanceUid() {
		return studyInstanceUid;
	}

	public void setStudyInstanceUid(String studyInstanceUid) {
		this.studyInstanceUid = studyInstanceUid;
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

	public String getPatientsBirthDate() {
		return patientsBirthDate;
	}

	public void setPatientsBirthDate(String patientsBirthDate) {
		this.patientsBirthDate = patientsBirthDate;
	}

	public String getPatientsAge() {
		return patientsAge;
	}

	public void setPatientsAge(String patientsAge) {
		this.patientsAge = patientsAge;
	}

	public String getPatientsSex() {
		return patientsSex;
	}

	public void setPatientsSex(String patientsSex) {
		this.patientsSex = patientsSex;
	}

	public String getStudyDate() {
		return studyDate;
	}

	public void setStudyDate(String studyDate) {
		this.studyDate = studyDate;
	}

	public String getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}

	public String getAccessionNumber() {
		return accessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public String getStudyId() {
		return studyId;
	}

	public void setStudyId(String studyId) {
		this.studyId = studyId;
	}

	public String getStudyDescription() {
		return studyDescription;
	}

	public void setStudyDescription(String studyDescription) {
		this.studyDescription = studyDescription;
	}

	public String getReferringPhysiciansName() {
		return referringPhysiciansName;
	}

	public void setReferringPhysiciansName(String referringPhysiciansName) {
		this.referringPhysiciansName = referringPhysiciansName;
	}

	public int getNumberOfStudyRelatedSeries() {
		return numberOfStudyRelatedSeries;
	}

	public void setNumberOfStudyRelatedSeries(int numberOfStudyRelatedSeries) {
		this.numberOfStudyRelatedSeries = numberOfStudyRelatedSeries;
	}

	public int getNumberOfStudyRelatedInstances() {
		return numberOfStudyRelatedInstances;
	}

	public void setNumberOfStudyRelatedInstances(
			int numberOfStudyRelatedInstances) {
		this.numberOfStudyRelatedInstances = numberOfStudyRelatedInstances;
	}

	public long getStudySizeInKB() {
		return studySizeInKB;
	}

	public void setStudySizeInKB(long studySizeInKB) {
		this.studySizeInKB = studySizeInKB;
	}

	public List<Series> getSeries() {
		return series;
	}

	public void setSeries(List<Series> series) {
		this.series = series;
	}

}