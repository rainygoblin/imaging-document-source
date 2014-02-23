package com.axonmed.xds.source.model;

import com.axonmed.xds.source.enumeration.FilesystemTierEnum;

public class Filesystem {
	private long id;
	private String filesystemPath;
	private boolean enabled = true;
	private boolean readOnly;
	private boolean writeOnly = true;
	private FilesystemTierEnum filesystemTierEnum;
	private long lowWatermark;
	private long highWatermark;
	private String comment;
	private String tempDir = "tmp";
	private String reconcileDir = "reconcile";

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFilesystemPath() {
		return filesystemPath;
	}

	public void setFilesystemPath(String filesystemPath) {
		this.filesystemPath = filesystemPath;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public boolean isWriteOnly() {
		return writeOnly;
	}

	public void setWriteOnly(boolean writeOnly) {
		this.writeOnly = writeOnly;
	}

	public FilesystemTierEnum getFilesystemTierEnum() {
		return filesystemTierEnum;
	}

	public void setFilesystemTierEnum(FilesystemTierEnum filesystemTierEnum) {
		this.filesystemTierEnum = filesystemTierEnum;
	}

	public long getLowWatermark() {
		return lowWatermark;
	}

	public void setLowWatermark(long lowWatermark) {
		this.lowWatermark = lowWatermark;
	}

	public long getHighWatermark() {
		return highWatermark;
	}

	public void setHighWatermark(long highWatermark) {
		this.highWatermark = highWatermark;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTempDir() {
		return tempDir;
	}

	public void setTempDir(String tempDir) {
		this.tempDir = tempDir;
	}

	public String getReconcileDir() {
		return reconcileDir;
	}

	public void setReconcileDir(String reconcileDir) {
		this.reconcileDir = reconcileDir;
	}

}