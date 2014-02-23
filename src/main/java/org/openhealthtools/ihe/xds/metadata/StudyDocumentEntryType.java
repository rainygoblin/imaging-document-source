package org.openhealthtools.ihe.xds.metadata;

public interface StudyDocumentEntryType extends DocumentEntryType {
	public abstract String getStudyDescription();

	public abstract void setStudyDescription(String studyDescription);

	public abstract String getStudyInstanceUID();

	public abstract void setStudyInstanceUID(String studyInstanceUID);

	public abstract String getStudyInstitution();

	public abstract void setStudyInstitution(String studyInstitution);

	public abstract String getModalityList();

	public abstract void setModalityList(String modalityList);

	public abstract String getSeriesCount();

	public abstract void setSeriesCount(String seriesCount);

	public abstract String getImagesCount();

	public abstract void setImagesCount(String imagesCount);

	public abstract String getStudyID();

	public abstract void setStudyID(String studyID) ;
	
	public abstract String getAccessionNumber();

	public abstract void setAccessionNumber(String accessionNumber);

	public abstract String getCaseNumber();

	public abstract void setCaseNumber(String caseNumber);

	public abstract String getStudyStatus() ;

	public abstract void setStudyStatus(String studyStatus) ;
	
	public abstract String getLogicalAccessionNumber() ;

	public void setLogicalAccessionNumber(String logicalAccessionNumber) ;
}