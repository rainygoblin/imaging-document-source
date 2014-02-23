package com.axonmed.xds.source.model;


import java.util.Date;

public class ArchiveStudyStorage {
	private long id;
	private long partitionArchiveId;
	private long studyStorageId;
	private long serverTransferSyntaxId;
	private Date archiveTime;
	private String archiveXml;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPartitionArchiveId() {
		return partitionArchiveId;
	}

	public void setPartitionArchiveId(long partitionArchiveId) {
		this.partitionArchiveId = partitionArchiveId;
	}

	public long getStudyStorageId() {
		return studyStorageId;
	}

	public void setStudyStorageId(long studyStorageId) {
		this.studyStorageId = studyStorageId;
	}

	public long getServerTransferSyntaxId() {
		return serverTransferSyntaxId;
	}

	public void setServerTransferSyntaxId(long serverTransferSyntaxId) {
		this.serverTransferSyntaxId = serverTransferSyntaxId;
	}

	public Date getArchiveTime() {
		return archiveTime;
	}

	public void setArchiveTime(Date archiveTime) {
		this.archiveTime = archiveTime;
	}

	public String getArchiveXml() {
		return archiveXml;
	}

	public void setArchiveXml(String archiveXml) {
		this.archiveXml = archiveXml;
	}

}