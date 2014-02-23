package com.axonmed.xds.source.model;

public class FilesystemStudyStorage {
	private Integer id;
	private StudyStorage studyStorage;
	private String filesystemGUID;
	private ServerTransferSyntax serverTransferSyntax;
	private String studyFolder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StudyStorage getStudyStorage() {
		return studyStorage;
	}

	public void setStudyStorage(StudyStorage studyStorage) {
		this.studyStorage = studyStorage;
	}

	public String getFilesystemGUID() {
		return filesystemGUID;
	}

	public void setFilesystemGUID(String filesystemGUID) {
		this.filesystemGUID = filesystemGUID;
	}

	public ServerTransferSyntax getServerTransferSyntax() {
		return serverTransferSyntax;
	}

	public void setServerTransferSyntax(
			ServerTransferSyntax serverTransferSyntax) {
		this.serverTransferSyntax = serverTransferSyntax;
	}

	public String getStudyFolder() {
		return studyFolder;
	}

	public void setStudyFolder(String studyFolder) {
		this.studyFolder = studyFolder;
	}

}