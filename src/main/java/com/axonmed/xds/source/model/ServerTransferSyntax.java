package com.axonmed.xds.source.model;

public class ServerTransferSyntax {
	private long id;
	private String uid;
	private String description;
	private boolean lossless;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isLossless() {
		return lossless;
	}

	public void setLossless(boolean lossless) {
		this.lossless = lossless;
	}

}
