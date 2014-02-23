package com.axonmed.xds.source.model;


public class ServerPartition {
	private Integer id;
	private boolean enabled;
	private String name;
	private String comment;
	private String aeTitle;
	private int numberOfThreads = 3;
	private int port;
	private int stgCmtPort = 104;
	/**
	 * The server partition relative sub-path
	 */
	private String partitionFolder;
	private boolean acceptAnyDevice;
	private boolean auditDeleteStudy;
	private boolean autoInsertDevice;
	private int defaultRemotePort;
	private int studyCount = 0;
	private String duplicateSopPolicy;
	private int dimseRspDelay;
	private int idleTimeout;
	private int dimseRspTimeout;
	private boolean matchAccessionNumber;
	private boolean matchIssuerOfPatientId;
	private boolean matchPatientId;
	private boolean matchPatientsBirthDate;
	private boolean matchPatientsName;
	private boolean matchPatientsSex;
	private boolean stgcmtEnabled = true;
	private int associationReaperPeriod;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAeTitle() {
		return aeTitle;
	}

	public void setAeTitle(String aeTitle) {
		this.aeTitle = aeTitle;
	}

	public int getNumberOfThreads() {
		return numberOfThreads;
	}

	public void setNumberOfThreads(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getStgCmtPort() {
		return stgCmtPort;
	}

	public void setStgCmtPort(int stgCmtPort) {
		this.stgCmtPort = stgCmtPort;
	}

	public String getPartitionFolder() {
		return partitionFolder;
	}

	public void setPartitionFolder(String partitionFolder) {
		this.partitionFolder = partitionFolder;
	}

	public boolean isAcceptAnyDevice() {
		return acceptAnyDevice;
	}

	public void setAcceptAnyDevice(boolean acceptAnyDevice) {
		this.acceptAnyDevice = acceptAnyDevice;
	}

	public boolean isAuditDeleteStudy() {
		return auditDeleteStudy;
	}

	public void setAuditDeleteStudy(boolean auditDeleteStudy) {
		this.auditDeleteStudy = auditDeleteStudy;
	}

	public boolean isAutoInsertDevice() {
		return autoInsertDevice;
	}

	public void setAutoInsertDevice(boolean autoInsertDevice) {
		this.autoInsertDevice = autoInsertDevice;
	}

	public int getDefaultRemotePort() {
		return defaultRemotePort;
	}

	public void setDefaultRemotePort(int defaultRemotePort) {
		this.defaultRemotePort = defaultRemotePort;
	}

	public int getStudyCount() {
		return studyCount;
	}

	public void setStudyCount(int studyCount) {
		this.studyCount = studyCount;
	}

	public String getDuplicateSopPolicy() {
		return duplicateSopPolicy;
	}

	public void setDuplicateSopPolicy(String duplicateSopPolicy) {
		this.duplicateSopPolicy = duplicateSopPolicy;
	}

	public int getDimseRspDelay() {
		return dimseRspDelay;
	}

	public void setDimseRspDelay(int dimseRspDelay) {
		this.dimseRspDelay = dimseRspDelay;
	}

	public int getIdleTimeout() {
		return idleTimeout;
	}

	public void setIdleTimeout(int idleTimeout) {
		this.idleTimeout = idleTimeout;
	}

	public int getDimseRspTimeout() {
		return dimseRspTimeout;
	}

	public void setDimseRspTimeout(int dimseRspTimeout) {
		this.dimseRspTimeout = dimseRspTimeout;
	}

	public boolean isMatchAccessionNumber() {
		return matchAccessionNumber;
	}

	public void setMatchAccessionNumber(boolean matchAccessionNumber) {
		this.matchAccessionNumber = matchAccessionNumber;
	}

	public boolean isMatchIssuerOfPatientId() {
		return matchIssuerOfPatientId;
	}

	public void setMatchIssuerOfPatientId(boolean matchIssuerOfPatientId) {
		this.matchIssuerOfPatientId = matchIssuerOfPatientId;
	}

	public boolean isMatchPatientId() {
		return matchPatientId;
	}

	public void setMatchPatientId(boolean matchPatientId) {
		this.matchPatientId = matchPatientId;
	}

	public boolean isMatchPatientsBirthDate() {
		return matchPatientsBirthDate;
	}

	public void setMatchPatientsBirthDate(boolean matchPatientsBirthDate) {
		this.matchPatientsBirthDate = matchPatientsBirthDate;
	}

	public boolean isMatchPatientsName() {
		return matchPatientsName;
	}

	public void setMatchPatientsName(boolean matchPatientsName) {
		this.matchPatientsName = matchPatientsName;
	}

	public boolean isMatchPatientsSex() {
		return matchPatientsSex;
	}

	public void setMatchPatientsSex(boolean matchPatientsSex) {
		this.matchPatientsSex = matchPatientsSex;
	}

	public boolean isStgcmtEnabled() {
		return stgcmtEnabled;
	}

	public void setStgcmtEnabled(boolean stgcmtEnabled) {
		this.stgcmtEnabled = stgcmtEnabled;
	}

	public int getAssociationReaperPeriod() {
		return associationReaperPeriod;
	}

	public void setAssociationReaperPeriod(int associationReaperPeriod) {
		this.associationReaperPeriod = associationReaperPeriod;
	}

}