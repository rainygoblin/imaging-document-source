package com.axonmed.xds.source.model;


import java.util.Date;

import com.axonmed.xds.source.enumeration.AlertCategoryEnum;
import com.axonmed.xds.source.enumeration.AlertLevelEnum;

public class Alert {

	private long id;
	private Date insertTime;
	private String component;
	private int typeCode;
	private String source;
	private AlertLevelEnum alertLevelEnum;
	private AlertCategoryEnum alertCategoryEnum;
	private String content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public int getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public AlertLevelEnum getAlertLevelEnum() {
		return alertLevelEnum;
	}

	public void setAlertLevelEnum(AlertLevelEnum alertLevelEnum) {
		this.alertLevelEnum = alertLevelEnum;
	}

	public AlertCategoryEnum getAlertCategoryEnum() {
		return alertCategoryEnum;
	}

	public void setAlertCategoryEnum(AlertCategoryEnum alertCategoryEnum) {
		this.alertCategoryEnum = alertCategoryEnum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}