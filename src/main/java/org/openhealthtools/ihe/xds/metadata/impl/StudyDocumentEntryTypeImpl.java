package org.openhealthtools.ihe.xds.metadata.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.openhealthtools.ihe.xds.metadata.MetadataPackage;
import org.openhealthtools.ihe.xds.metadata.StudyDocumentEntryType;

public class StudyDocumentEntryTypeImpl extends DocumentEntryTypeImpl implements
		StudyDocumentEntryType {

	private String studyDescription;
	private String studyInstanceUID;
	private String studyInstitution;
	private String modalityList;
	private String seriesCount;
	private String imagesCount;
	private String accessionNumber;
	private String caseNumber;
	private String studyID;
	private String studyStatus;
	private String logicalAccessionNumber;

	public StudyDocumentEntryTypeImpl() {
		super();
	}

	public String getStudyDescription() {
		return studyDescription;
	}

	public void setStudyDescription(String studyDescription) {
		String oldStudyDescription = this.studyDescription;
		this.studyDescription = studyDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH,
					oldStudyDescription, studyDescription));
	}

	public String getStudyInstanceUID() {
		return studyInstanceUID;
	}

	public void setStudyInstanceUID(String studyInstanceUID) {
		String oldStudyInstanceUID = this.studyInstanceUID;
		this.studyInstanceUID = studyInstanceUID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH,
					oldStudyInstanceUID, studyInstanceUID));
	}

	public String getStudyInstitution() {
		return studyInstitution;
	}

	public void setStudyInstitution(String studyInstitution) {
		String oldStudyInstitution = this.studyInstitution;
		this.studyInstitution = studyInstitution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH,
					oldStudyInstitution, studyInstitution));
	}

	public String getModalityList() {
		return modalityList;
	}

	public void setModalityList(String modalityList) {
		String oldModalityList = this.modalityList;
		this.modalityList = modalityList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH, oldModalityList,
					oldModalityList));
	}

	public String getSeriesCount() {
		return seriesCount;
	}

	public void setSeriesCount(String seriesCount) {
		String oldSeriesCount = this.seriesCount;
		this.seriesCount = seriesCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH, oldSeriesCount,
					seriesCount));
	}

	public String getImagesCount() {
		return imagesCount;
	}

	public void setImagesCount(String imagesCount) {
		String oldImagesCount = this.imagesCount;
		this.imagesCount = imagesCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH, oldImagesCount,
					imagesCount));
	}

	public String getAccessionNumber() {
		return accessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		String oldAccessionNumber = this.accessionNumber;
		this.accessionNumber = accessionNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH,
					oldAccessionNumber, accessionNumber));
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		String oldCaseNumber = this.caseNumber;
		this.caseNumber = caseNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH, oldCaseNumber,
					caseNumber));
	}

	public String getStudyID() {
		return studyID;
	}

	public void setStudyID(String studyID) {
		String oldStudyID = this.studyID;
		this.studyID = studyID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH, oldStudyID,
					studyID));
	}

	public String getStudyStatus() {
		return studyStatus;
	}

	public void setStudyStatus(String studyStatus) {
		String oldStudyStatus = this.studyStatus;
		this.studyStatus = studyStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH, oldStudyStatus,
					studyStatus));
	}

	public String getLogicalAccessionNumber() {
		return logicalAccessionNumber;
	}

	public void setLogicalAccessionNumber(String logicalAccessionNumber) {

		String oldLogicalAccessionNumber = this.logicalAccessionNumber;
		this.logicalAccessionNumber = logicalAccessionNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH, oldLogicalAccessionNumber,
					logicalAccessionNumber));
	}

}