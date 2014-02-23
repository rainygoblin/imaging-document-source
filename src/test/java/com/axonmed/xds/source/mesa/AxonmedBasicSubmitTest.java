/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.axonmed.xds.source.mesa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openhealthtools.ihe.common.hl7v2.CX;
import org.openhealthtools.ihe.common.hl7v2.Hl7v2Factory;
import org.openhealthtools.ihe.common.hl7v2.SourcePatientInfoType;
import org.openhealthtools.ihe.common.hl7v2.XPN;
import org.openhealthtools.ihe.common.hl7v2.format.HL7V2MessageFormat;
import org.openhealthtools.ihe.common.hl7v2.format.MessageDelimiters;
import org.openhealthtools.ihe.utils.OID;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.document.XDSDocumentFromFile;
import org.openhealthtools.ihe.xds.metadata.ExtensionType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;
import org.openhealthtools.ihe.xds.metadata.SubmissionSetType;
import org.openhealthtools.ihe.xds.response.XDSResponseType;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

/**
 * Prior to running this test you will need to set the appropriate parameters in 
 * TestConfiguration.java
 * <br>
 * Submission of two documnets with automatic metadata extraction from CDA R2
 * Data for this test is in ./resources/sample_files/test1/ and ./resources/sample_files/test2/. 
 * Submission set metadata is taken from ./resources/sample_files/test2/
 * <br>
 * Corresponds to Connectathon 2008-2009 Test: 11747
 * <br>
 * http://ihewiki.wustl.edu/wiki/index.php/XDS_Test_Kit_2007-2008_Test_Descriptions#11747
 * 
 * @author <a href="mailto:seknoop@us.ibm.com">Sarah Knoop</a>
 */
@SuppressWarnings("unchecked")
public class AxonmedBasicSubmitTest extends B_SourceMesaTest {

	// logger
	private static final Logger logger = Logger.getLogger(AxonmedBasicSubmitTest.class);
	
	private MetadataFactory metadataFactory = MetadataFactory.eINSTANCE;

	/**
	 * Submission of two documnets with automatic metadata extraction from CDA R2
	 * Data for this test is in ./resources/sample_files/test1/ and ./resources/sample_files/test2/. 
	 * Submission set metadata is taken from ./resources/sample_files/test2/
	 * <br>
	 * Corresponds to Connectathon 2008-2009 Test: 11747
	 * <br>
	 * http://ihewiki.wustl.edu/wiki/index.php/XDS_Test_Kit_2007-2008_Test_Descriptions#11747
	 * 
	 * @throws Throwable
	 */
	@Test
	public void test() throws Throwable {
		logger.debug("BEGIN MESA 11747 with metadata extraction from CDA");

		SourcePatientInfoType sourcePatientInfo = Hl7v2Factory.eINSTANCE.createSourcePatientInfoType();
		sourcePatientInfo.setPatientDateOfBirth("20130101");
		sourcePatientInfo.setPatientSex("F");
		CX cx = HL7V2MessageFormat.buildCXFromMessageString("patilocalid",
				MessageDelimiters.COMPONENT, 
				MessageDelimiters.SUBCOMPONENT);
		
		sourcePatientInfo.getPatientIdentifier().add(cx);

		XPN xpn = HL7V2MessageFormat.buildXPNFromMessageString(
				"name",
				MessageDelimiters.COMPONENT);
		sourcePatientInfo.getPatientName().add(xpn);
		SubmitTransactionData txnData = new SubmitTransactionData();
		// invoke transformation for metadata extraction on test files
		
		// document 1
		logger.debug("Adding input document 1, and metadata.");
		XDSDocument clinicalDocument1 = new XDSDocumentFromFile(new DocumentDescriptor("DICOM-KOS","application/dicom-kos"),"src/test/resources/sample_files/test1/input.xml");
		String docEntryUUID1 = txnData.addDocument(clinicalDocument1);
		
		
		logger.debug("Supplementing Document Entry metadata for document 1");
		// set classCode
		txnData.getDocumentEntry(docEntryUUID1).setClassCode(TestConfiguration.CLASS_CODE);
		// re-set conf code
		txnData.getDocumentEntry(docEntryUUID1).getConfidentialityCode().clear();
		txnData.getDocumentEntry(docEntryUUID1).getConfidentialityCode().addAll(TestConfiguration.ADDITIONAL_CONFIDENTIALITY_CODE_CLAUSES);
		// format code
		txnData.getDocumentEntry(docEntryUUID1).setFormatCode(TestConfiguration.FORMAT_CODE);
		// healthcare facilty code
		txnData.getDocumentEntry(docEntryUUID1).setHealthCareFacilityTypeCode(TestConfiguration.HEALTHCARE_FACILITY_CODE);
		// patient Id
		txnData.getDocumentEntry(docEntryUUID1).setPatientId(TestConfiguration.PATIENT_ID);
		// prac setting code
		txnData.getDocumentEntry(docEntryUUID1).setPracticeSettingCode(TestConfiguration.PRACTICE_SETTING_CODE);
		// type code
		txnData.getDocumentEntry(docEntryUUID1).setTypeCode(TestConfiguration.TYPE_CODE);
		
		txnData.getDocumentEntry(docEntryUUID1).setSourcePatientInfo(sourcePatientInfo);
		
		addStudyInfo(txnData, docEntryUUID1);
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(docEntryUUID1).setUniqueId(OID.createOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID, 64));
		logger.debug("Done setting documentEntry metadata for: " +txnData.getDocumentEntry(docEntryUUID1).toString());
		//txnData.dumpMetadataToFile("C:/temp/metadata2.xml");

		// add submission set metadata
		logger.debug("Applying Submission Set Metadata to the Submission.");
		SubmissionSetType submissionSetType = metadataFactory.createSubmissionSetType();
		submissionSetType.setSourceId(TestConfiguration.ORGANIZATIONAL_OID);
		submissionSetType.setUniqueId(OID.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		submissionSetType.setSubmissionTime(TestUtils.formGMT_DTM());
		submissionSetType.setPatientId(TestConfiguration.PATIENT_ID);
		submissionSetType.setEntryUUID(UUID.generateURN());
		txnData.getMetadata().setSubmissionSet(submissionSetType);

		logger.debug("Submitting Document.");
		XDSResponseType response = source.submit(txnData);
		String reponseStatus = response.getStatus().getName();
		assertNotNull(reponseStatus);
		assertEquals("The response should be success", "Success", reponseStatus);
		logger.debug("Response status: " + response.getStatus().getName());
		if(response.getErrorList() != null){
			if(response.getErrorList().getError() != null){
				logger.debug("Returned " + response.getErrorList().getError().size() + " errors.");
			}
		}
		logger.debug("DONE MESA 11747 with metadata extraction from CDA");
	}

	private void addStudyInfo(SubmitTransactionData txnData,
			String docEntryUUID1) {

		addStudyInfoExtension(txnData, docEntryUUID1,"urn:rad:studyDescription","studyDescription");
		addStudyInfoExtension(txnData, docEntryUUID1,"urn:rad:studyID","studyID");
		addStudyInfoExtension(txnData, docEntryUUID1,"urn:rad:studyInstanceUID","studyInstanceUID");
		addStudyInfoExtension(txnData, docEntryUUID1,"urn:rad:studyInstitution","studyInstitution");
		addStudyInfoExtension(txnData, docEntryUUID1,"urn:rad:modalityList","modalityList");
		addStudyInfoExtension(txnData, docEntryUUID1,"urn:rad:seriesCount","12312");
		addStudyInfoExtension(txnData, docEntryUUID1,"urn:rad:hositalCode","hositalCode");
		addStudyInfoExtension(txnData, docEntryUUID1,"urn:rad:imagesCount","123");
		addStudyInfoExtension(txnData, docEntryUUID1,"urn:rad:accessionNumber","accessionNumber");
		addStudyInfoExtension(txnData, docEntryUUID1,"urn:rad:logicalAccessionNumber","logicalAccessionNumber");
		addStudyInfoExtension(txnData, docEntryUUID1,"urn:rad:caseNumber","caseNumber");
		addStudyInfoExtension(txnData, docEntryUUID1,"urn:rad:studyStatus","studyStatus");
	}

	private void addStudyInfoExtension(SubmitTransactionData txnData,
			String docEntryUUID1,String name,String value) {
		ExtensionType newExtension = metadataFactory.createExtensionType();
		newExtension.setName(name);
		newExtension.getValue().add(value);
		txnData.getDocumentEntry(docEntryUUID1).getExtension().add(newExtension);
	}
}
