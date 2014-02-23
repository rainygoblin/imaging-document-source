package com.axonmed.xds.source.model;

import com.axonmed.xds.source.enumeration.ServerObjectPairClass;

public class ServiceObjectPair {

	private long id;
	private Series series;
	private String sopInstanceUid;
	private String instanceNumber;
	private long size;
	private String manufacturer;
	private String numberOfFrames;
	private String md5;
	private ServerObjectPairClass sopClass;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public String getSopInstanceUid() {
		return sopInstanceUid;
	}

	public void setSopInstanceUid(String sopInstanceUid) {
		this.sopInstanceUid = sopInstanceUid;
	}

	public String getInstanceNumber() {
		return instanceNumber;
	}

	public void setInstanceNumber(String instanceNumber) {
		this.instanceNumber = instanceNumber;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getNumberOfFrames() {
		return numberOfFrames;
	}

	public void setNumberOfFrames(String numberOfFrames) {
		this.numberOfFrames = numberOfFrames;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public ServerObjectPairClass getSopClass() {
		return sopClass;
	}

	public void setSopClass(ServerObjectPairClass sopClass) {
		this.sopClass = sopClass;
	}

}