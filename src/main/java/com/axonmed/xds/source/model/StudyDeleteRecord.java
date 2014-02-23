package com.axonmed.xds.source.model;


import java.util.Date;

public class StudyDeleteRecord {
	private long id;
	private Date timestamp;
	private String reason;
	private String serverPartitionAE;
	private long filesystemId;
	private String backupPath;
	private String studyInstanceUid;
	private String accessionNumber;
	private String patientId;
	private String patientsName;
	private String studyId;
	private String studyDescription;
	private String studyDate;
	private String studyTime;
	private String archiveInfo;
	private String extendedInfo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getServerPartitionAE() {
		return serverPartitionAE;
	}

	public void setServerPartitionAE(String serverPartitionAE) {
		this.serverPartitionAE = serverPartitionAE;
	}

	public long getFilesystemId() {
		return filesystemId;
	}

	public void setFilesystemId(long filesystemId) {
		this.filesystemId = filesystemId;
	}

	public String getBackupPath() {
		return backupPath;
	}

	public void setBackupPath(String backupPath) {
		this.backupPath = backupPath;
	}

	public String getStudyInstanceUid() {
		return studyInstanceUid;
	}

	public void setStudyInstanceUid(String studyInstanceUid) {
		this.studyInstanceUid = studyInstanceUid;
	}

	public String getAccessionNumber() {
		return accessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientsName() {
		return patientsName;
	}

	public void setPatientsName(String patientsName) {
		this.patientsName = patientsName;
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

	public String getArchiveInfo() {
		return archiveInfo;
	}

	public void setArchiveInfo(String archiveInfo) {
		this.archiveInfo = archiveInfo;
	}

	public String getExtendedInfo() {
		return extendedInfo;
	}

	public void setExtendedInfo(String extendedInfo) {
		this.extendedInfo = extendedInfo;
	}

}