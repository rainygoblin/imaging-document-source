package com.axonmed.xds.source.model;

import java.util.Date;

public class Device {
	private long id;
	private ServerPartition serverPartition;
	private String name;
	private String type;
	private String comment;
	private String ipAddress;
	private int port;
	private String aeTitle;
	private boolean dhcp = false;
	private boolean enabled = true;
	private boolean allowStorage = true;
	private boolean acceptKOPR = true;
	private boolean allowRetrieve = true;
	private boolean allowQuery = true;
	private boolean allowAutoRoute = true;
	private Date lastAccessedTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ServerPartition getServerPartition() {
		return serverPartition;
	}

	public void setServerPartition(ServerPartition serverPartition) {
		this.serverPartition = serverPartition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getAeTitle() {
		return aeTitle;
	}

	public void setAeTitle(String aeTitle) {
		this.aeTitle = aeTitle;
	}

	public boolean isDhcp() {
		return dhcp;
	}

	public void setDhcp(boolean dhcp) {
		this.dhcp = dhcp;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAllowStorage() {
		return allowStorage;
	}

	public void setAllowStorage(boolean allowStorage) {
		this.allowStorage = allowStorage;
	}

	public boolean isAcceptKOPR() {
		return acceptKOPR;
	}

	public void setAcceptKOPR(boolean acceptKOPR) {
		this.acceptKOPR = acceptKOPR;
	}

	public boolean isAllowRetrieve() {
		return allowRetrieve;
	}

	public void setAllowRetrieve(boolean allowRetrieve) {
		this.allowRetrieve = allowRetrieve;
	}

	public boolean isAllowQuery() {
		return allowQuery;
	}

	public void setAllowQuery(boolean allowQuery) {
		this.allowQuery = allowQuery;
	}

	public boolean isAllowAutoRoute() {
		return allowAutoRoute;
	}

	public void setAllowAutoRoute(boolean allowAutoRoute) {
		this.allowAutoRoute = allowAutoRoute;
	}

	public Date getLastAccessedTime() {
		return lastAccessedTime;
	}

	public void setLastAccessedTime(Date lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

}