package com.axonmed.xds.source.model;

public class DocumentRepository {
	private long id;

	private boolean active;

	private boolean secure;

	private String address;

	private String name;

	private String uid;

	private String comment;

	private String keyStoreFileName;

	private String trustKeyStoreFileName;

	private String keyStorePassword;

	private String trustKeyStorePassword;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getKeyStoreFileName() {
		return keyStoreFileName;
	}

	public void setKeyStoreFileName(String keyStoreFileName) {
		this.keyStoreFileName = keyStoreFileName;
	}

	public String getTrustKeyStoreFileName() {
		return trustKeyStoreFileName;
	}

	public void setTrustKeyStoreFileName(String trustKeyStoreFileName) {
		this.trustKeyStoreFileName = trustKeyStoreFileName;
	}

	public String getKeyStorePassword() {
		return keyStorePassword;
	}

	public void setKeyStorePassword(String keyStorePassword) {
		this.keyStorePassword = keyStorePassword;
	}

	public String getTrustKeyStorePassword() {
		return trustKeyStorePassword;
	}

	public void setTrustKeyStorePassword(String trustKeyStorePassword) {
		this.trustKeyStorePassword = trustKeyStorePassword;
	}

}