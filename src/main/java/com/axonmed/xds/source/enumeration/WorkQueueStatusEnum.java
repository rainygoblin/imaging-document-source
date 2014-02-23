package com.axonmed.xds.source.enumeration;


public enum WorkQueueStatusEnum {
	Idle("Idle", "Waiting to expire or for more images"), Pending("Pending",
			"Pending"), InProgress("InProgress",
			"In Progress"), Completed("Completed",
			"The Queue entry is completed."), Failed("Failed",
			"The Queue entry has failed.");

	private String lookup;
	private String description;

	private WorkQueueStatusEnum(String lookup, String description) {
		this.lookup = lookup;
		this.description = description;
	}

	public String getLookup() {
		return lookup;
	}

	public String getDescription() {
		return description;
	}
}
