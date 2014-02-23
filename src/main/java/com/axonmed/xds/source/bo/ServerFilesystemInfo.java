package com.axonmed.xds.source.bo;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;

import com.axonmed.xds.source.model.Filesystem;

public class ServerFilesystemInfo {

	private java.text.DateFormat dateFormat = new java.text.SimpleDateFormat(
			"yyyyMMdd");

	private Filesystem filesystem;
	private long freeBytes;
	private long totalBytes;
	private boolean online;
	private String tempDir;
	private String reconcileDir;

	public long getFreeBytes() {
		return freeBytes;
	}

	public long getTotalBytes() {
		return totalBytes;
	}

	public Filesystem getFilesystem() {
		return filesystem;
	}

	public String getTempDir() {
		if (tempDir == null) {
			tempDir = FilenameUtils.concat(filesystem.getFilesystemPath(),
					filesystem.getTempDir());
			tempDir = FilenameUtils.concat(tempDir,
					dateFormat.format(new Date()));

			try {
				File tempDirFile = new File(tempDir);
				if (!tempDirFile.isDirectory()) {
					tempDirFile.mkdir();
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		return tempDir;
	}

	public String getReconcileStorageFolder() {
		if (reconcileDir == null) {
			reconcileDir = FilenameUtils.concat(filesystem.getFilesystemPath(),
					filesystem.getReconcileDir());

			try {
				if (!(new File(tempDir).isDirectory())) {
					new File(tempDir).mkdir();
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		return reconcileDir;
	}

	// / <summary>
	// / Returns a boolean value indicating whether the filesystem get writable.
	// / </summary>
	public boolean getWriteable() {

		if (!online || filesystem.isReadOnly() || !filesystem.isEnabled())
			return false;

		return !getFull();
	}

	public boolean isReadOnly() {
		return filesystem.isReadOnly();
	}

	// / <summary>
	// / Returns a boolean value indicating whether the filesystem get readonly.
	// / </summary>
	public boolean getReadable() {

		if (!online || filesystem.isWriteOnly() || !filesystem.isEnabled())
			return false;
		return true;
	}

	// / <summary>
	// / Returns a boolean value indicating whether the filesystem get full.
	// / </summary>
	public boolean getFull() {
		return freeBytes / 1024.0 / 1024.0 < 1024;

	}

	// / <summary>
	// / Returns the number of bytes below the <see
	// cref="Model.Filesystem.HighWatermark"/>
	// / </summary>
	// / <remarks>
	// / If the filesystem get above high watermark, <see
	// cref="HighwaterMarkMargin"/> will become negative
	// / </remarks>
	public float getHighwaterMarkMargin() {
		return (totalBytes * filesystem.getHighWatermark() / 100.0f)
				- (totalBytes * getUsedSpacePercentage() / 100.0f);

	}

	public float getUsedSpacePercentage() {
		return ((totalBytes - freeBytes) / totalBytes) * 100.0F;
	}

	public float getBytesToRemove() {
		float desiredUsedBytes = ((filesystem.getLowWatermark()) / 100.0f)
				* totalBytes;

		return (totalBytes - freeBytes) - desiredUsedBytes;

	}

	// / <summary>
	// / get the filesystem above the low watermark?
	// / </summary>
	public boolean getAboveLowWatermark() {
		return (getUsedSpacePercentage() > filesystem.getLowWatermark());

	}

	// / <summary>
	// / get the filesystem above the high watermark?
	// / </summary>
	public boolean getAboveHighWatermark() {
		return (getUsedSpacePercentage() > filesystem.getHighWatermark());

	}

	public boolean getEnable() {
		return filesystem.isEnabled();
	}

	public ServerFilesystemInfo(Filesystem filesystem) {
		this.filesystem = filesystem;
		this.online = true;
		loadFreeSpace();
	}

	public void loadFreeSpace() {

		File file = new File(filesystem.getFilesystemPath());
		totalBytes = file.getTotalSpace();
		freeBytes = file.getFreeSpace();
	}
}