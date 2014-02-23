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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.ExtensionType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;
import org.openhealthtools.ihe.xds.metadata.ParentDocumentRelationshipType;
import org.openhealthtools.ihe.xds.metadata.ParentDocumentType;
import org.openhealthtools.ihe.xds.metadata.SubmissionSetType;
import org.openhealthtools.ihe.xds.metadata.extract.InputStreamDocumentEntryExtractor;
import org.openhealthtools.ihe.xds.metadata.extract.MetadataExtractionException;
import org.openhealthtools.ihe.xds.metadata.impl.MetadataFactoryImpl;
import org.openhealthtools.ihe.xds.metadata.impl.ParentDocumentTypeImpl;
import org.openhealthtools.ihe.xds.response.XDSResponseType;
import org.openhealthtools.ihe.xds.source.SubmitTransactionCompositionException;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

/**
 * Prior to running this test you will need to set the appropriate parameters in
 * TestConfiguration.java <br>
 * Submission of two documnets with automatic metadata extraction from CDA R2
 * Data for this test is in ./resources/sample_files/test1/ and
 * ./resources/sample_files/test2/. Submission set metadata is taken from
 * ./resources/sample_files/test2/ <br>
 * Corresponds to Connectathon 2008-2009 Test: 11747 <br>
 * http://ihewiki.wustl.edu/wiki/index.php/XDS_Test_Kit_2007-
 * 2008_Test_Descriptions#11747
 * 
 * @author <a href="mailto:seknoop@us.ibm.com">Sarah Knoop</a>
 */
public class Axonmed_Repository_Registry_Lifecycle extends B_SourceMesaTest {

	// logger
	private static final Logger logger = Logger
			.getLogger(Axonmed_Repository_Registry_Lifecycle.class);

	private MetadataFactory metadataFactory = MetadataFactory.eINSTANCE;

	private DocumentDescriptor DocumentDescriptor_KOS = new DocumentDescriptor(
			"DICOM-KOS", "application/dicom-kos");
	private String docEntryUUID1;
	private String docEntryUUID2;
	private String addendumDocEntryUUID1;
	private String addendumDocEntryUUID2;
	private String transformationDocEntryUUID1;
	private String transformationDocEntryUUID2;
	private String replacementDocEntryUUID1;
	private String replacementDocEntryUUID2;
	
	private SourcePatientInfoType sourcePatientInfo = null;
	
	public Axonmed_Repository_Registry_Lifecycle(){

	    sourcePatientInfo = Hl7v2Factory.eINSTANCE.createSourcePatientInfoType();
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
	}

	/**
	 * Submission of two documnets with automatic metadata extraction from CDA
	 * R2 Data for this test is in ./resources/sample_files/test1/ and
	 * ./resources/sample_files/test2/. Submission set metadata is taken from
	 * ./resources/sample_files/test2/ <br>
	 * Corresponds to Connectathon 2008-2009 Test: 11747 <br>
	 * http://ihewiki.wustl.edu/wiki/index.php/XDS_Test_Kit_2007-
	 * 2008_Test_Descriptions#11747
	 * 
	 * @throws Throwable
	 */
	@Test
	public void test() throws Throwable {
		this.submitDocument();

		this.submitAPNDDocument();

		this.submitXFRMDocument();

		this.submitRPLCDocument();

	}

	private void submitRPLCDocument() throws Exception {

		SubmitTransactionData txnData = new SubmitTransactionData();
		// invoke transformation for metadata extraction on test files

		txnData.addExistingDocument(addendumDocEntryUUID1);
		// added document 1
		logger.debug("Adding input document 1, and metadata.");
		XDSDocument clinicalDocument1 = new XDSDocumentFromFile(
				DocumentDescriptor_KOS,
				"src/test/resources/sample_files/test1/input.xml");
		replacementDocEntryUUID1 = txnData.addDocument(clinicalDocument1);

		logger.debug("Supplementing Document Entry metadata for document 1");
		txnData.getDocumentEntry(replacementDocEntryUUID1).setClassCode(
				TestConfiguration.CLASS_CODE);
		// re-set conf code
		txnData.getDocumentEntry(replacementDocEntryUUID1)
				.getConfidentialityCode().clear();
		txnData.getDocumentEntry(replacementDocEntryUUID1)
				.getConfidentialityCode()
				.addAll(TestConfiguration.ADDITIONAL_CONFIDENTIALITY_CODE_CLAUSES);
		// format code
		txnData.getDocumentEntry(replacementDocEntryUUID1).setFormatCode(
				TestConfiguration.FORMAT_CODE);
		// healthcare facilty code
		txnData.getDocumentEntry(replacementDocEntryUUID1)
				.setHealthCareFacilityTypeCode(
						TestConfiguration.HEALTHCARE_FACILITY_CODE);
		// patient Id
		txnData.getDocumentEntry(replacementDocEntryUUID1).setPatientId(
				TestConfiguration.PATIENT_ID);
		// prac setting code
		txnData.getDocumentEntry(replacementDocEntryUUID1)
				.setPracticeSettingCode(TestConfiguration.PRACTICE_SETTING_CODE);
		// type code
		txnData.getDocumentEntry(replacementDocEntryUUID1).setTypeCode(
				TestConfiguration.TYPE_CODE);

		txnData.getDocumentEntry(this.replacementDocEntryUUID1).setSourcePatientInfo(sourcePatientInfo);

		addStudyInfo(txnData, replacementDocEntryUUID1);
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(replacementDocEntryUUID1)
				.setUniqueId(
						OID.createOIDGivenRoot(
								TestConfiguration.ORGANIZATIONAL_OID, 64));

		logger.debug("Done setting documentEntry metadata for: "
				+ txnData.getDocumentEntry(replacementDocEntryUUID1).toString());

		ParentDocumentType parentDocument = metadataFactory
				.createParentDocumentType();
		parentDocument.setParentDocumentId(addendumDocEntryUUID1);
		parentDocument
				.setParentDocumentRelationship(ParentDocumentRelationshipType.RPLC_LITERAL);
		txnData.getDocumentEntry(replacementDocEntryUUID1).setParentDocument(
				parentDocument);

		txnData.addExistingDocument(addendumDocEntryUUID2);
		// document 2
		logger.debug("Adding input document 2, and metadata.");
		XDSDocument clinicalDocument2 = new XDSDocumentFromFile(
				DocumentDescriptor_KOS,
				"src/test/resources/sample_files/test2/ScanSample.xml");
		replacementDocEntryUUID2 = txnData.addDocument(clinicalDocument2);

		logger.debug("Supplementing Document Entry metadata for document 2");
		txnData.getDocumentEntry(replacementDocEntryUUID2).setClassCode(
				TestConfiguration.CLASS_CODE);
		// re-set conf code
		txnData.getDocumentEntry(replacementDocEntryUUID2)
				.getConfidentialityCode().clear();
		txnData.getDocumentEntry(replacementDocEntryUUID2)
				.getConfidentialityCode()
				.addAll(TestConfiguration.ADDITIONAL_CONFIDENTIALITY_CODE_CLAUSES);
		// format code
		txnData.getDocumentEntry(replacementDocEntryUUID2).setFormatCode(
				TestConfiguration.FORMAT_CODE);
		// healthcare facilty code
		txnData.getDocumentEntry(replacementDocEntryUUID2)
				.setHealthCareFacilityTypeCode(
						TestConfiguration.HEALTHCARE_FACILITY_CODE);
		// patient Id
		txnData.getDocumentEntry(replacementDocEntryUUID2).setPatientId(
				TestConfiguration.PATIENT_ID);
		// prac setting code
		txnData.getDocumentEntry(replacementDocEntryUUID2)
				.setPracticeSettingCode(TestConfiguration.PRACTICE_SETTING_CODE);
		// type code
		txnData.getDocumentEntry(replacementDocEntryUUID2).setTypeCode(
				TestConfiguration.TYPE_CODE);

		txnData.getDocumentEntry(this.replacementDocEntryUUID2).setSourcePatientInfo(sourcePatientInfo);
		
		addStudyInfo(txnData, replacementDocEntryUUID2);
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(replacementDocEntryUUID2)
				.setUniqueId(
						OID.createOIDGivenRoot(
								TestConfiguration.ORGANIZATIONAL_OID, 64));

		logger.debug("Done setting documentEntry metadata for: "
				+ txnData.getDocumentEntry(replacementDocEntryUUID2).toString());
		parentDocument = metadataFactory.createParentDocumentType();
		parentDocument.setParentDocumentId(addendumDocEntryUUID2);
		parentDocument
				.setParentDocumentRelationship(ParentDocumentRelationshipType.RPLC_LITERAL);
		txnData.getDocumentEntry(replacementDocEntryUUID2).setParentDocument(
				parentDocument);

		// add submission set metadata
		logger.debug("Applying Submission Set Metadata to the Submission.");
		SubmissionSetType submissionSetType = metadataFactory
				.createSubmissionSetType();
		submissionSetType.setSourceId(TestConfiguration.ORGANIZATIONAL_OID);
		submissionSetType
				.setUniqueId(OID
						.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		submissionSetType.setSubmissionTime(TestUtils.formGMT_DTM());
		submissionSetType.setPatientId(TestConfiguration.PATIENT_ID);
		submissionSetType.setEntryUUID(UUID.generateURN());
		txnData.getMetadata().setSubmissionSet(submissionSetType);

		logger.debug("Submitting Document.");
		XDSResponseType response = source.submit(txnData);
		String reponseStatus = response.getStatus().getName();
		logger.debug("Response status: " + reponseStatus);
		assertNotNull(reponseStatus);
		assertEquals("The response should be success", "Success", reponseStatus);
		if (response.getErrorList() != null) {
			if (response.getErrorList().getError() != null) {
				logger.debug("Returned "
						+ response.getErrorList().getError().size()
						+ " errors.");
			}
		}
		logger.debug("DONE MESA 11747 with metadata extraction from CDA");
	}

	private void submitXFRMDocument() throws Exception {

		SubmitTransactionData txnData = new SubmitTransactionData();
		// invoke transformation for metadata extraction on test files

		txnData.addExistingDocument(addendumDocEntryUUID1);
		// added document 1
		logger.debug("Adding input document 1, and metadata.");
		XDSDocument clinicalDocument1 = new XDSDocumentFromFile(
				DocumentDescriptor_KOS,
				"src/test/resources/sample_files/test1/input.xml");
		transformationDocEntryUUID1 = txnData.addDocument(clinicalDocument1);

		logger.debug("Supplementing Document Entry metadata for document 1");
		// set classCode
		txnData.getDocumentEntry(transformationDocEntryUUID1).setClassCode(
				TestConfiguration.CLASS_CODE);
		// re-set conf code
		txnData.getDocumentEntry(transformationDocEntryUUID1)
				.getConfidentialityCode().clear();
		txnData.getDocumentEntry(transformationDocEntryUUID1)
				.getConfidentialityCode()
				.addAll(TestConfiguration.ADDITIONAL_CONFIDENTIALITY_CODE_CLAUSES);
		// format code
		txnData.getDocumentEntry(transformationDocEntryUUID1).setFormatCode(
				TestConfiguration.FORMAT_CODE);
		// healthcare facilty code
		txnData.getDocumentEntry(transformationDocEntryUUID1)
				.setHealthCareFacilityTypeCode(
						TestConfiguration.HEALTHCARE_FACILITY_CODE);
		// patient Id
		txnData.getDocumentEntry(transformationDocEntryUUID1).setPatientId(
				TestConfiguration.PATIENT_ID);
		// prac setting code
		txnData.getDocumentEntry(transformationDocEntryUUID1)
				.setPracticeSettingCode(TestConfiguration.PRACTICE_SETTING_CODE);
		// type code
		txnData.getDocumentEntry(transformationDocEntryUUID1).setTypeCode(
				TestConfiguration.TYPE_CODE);

		txnData.getDocumentEntry(this.transformationDocEntryUUID1).setSourcePatientInfo(sourcePatientInfo);
		
		addStudyInfo(txnData, transformationDocEntryUUID1);
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(transformationDocEntryUUID1)
				.setUniqueId(
						OID.createOIDGivenRoot(
								TestConfiguration.ORGANIZATIONAL_OID, 64));
		logger.debug("Done setting documentEntry metadata for: "
				+ txnData.getDocumentEntry(transformationDocEntryUUID1)
						.toString());
		ParentDocumentType parentDocument = metadataFactory
				.createParentDocumentType();
		parentDocument.setParentDocumentId(addendumDocEntryUUID1);
		parentDocument
				.setParentDocumentRelationship(ParentDocumentRelationshipType.XFRM_LITERAL);
		txnData.getDocumentEntry(transformationDocEntryUUID1)
				.setParentDocument(parentDocument);

		txnData.addExistingDocument(addendumDocEntryUUID2);
		// document 2
		logger.debug("Adding input document 2, and metadata.");
		XDSDocument clinicalDocument2 = new XDSDocumentFromFile(
				DocumentDescriptor_KOS,
				"src/test/resources/sample_files/test2/ScanSample.xml");
		transformationDocEntryUUID2 = txnData.addDocument(clinicalDocument2);

		logger.debug("Supplementing Document Entry metadata for document 2");
		// set classCode
		txnData.getDocumentEntry(transformationDocEntryUUID2).setClassCode(
				TestConfiguration.CLASS_CODE);
		// re-set conf code
		txnData.getDocumentEntry(transformationDocEntryUUID2)
				.getConfidentialityCode().clear();
		txnData.getDocumentEntry(transformationDocEntryUUID2)
				.getConfidentialityCode()
				.addAll(TestConfiguration.ADDITIONAL_CONFIDENTIALITY_CODE_CLAUSES);
		// format code
		txnData.getDocumentEntry(transformationDocEntryUUID2).setFormatCode(
				TestConfiguration.FORMAT_CODE);
		// healthcare facilty code
		txnData.getDocumentEntry(transformationDocEntryUUID2)
				.setHealthCareFacilityTypeCode(
						TestConfiguration.HEALTHCARE_FACILITY_CODE);
		// patient Id
		txnData.getDocumentEntry(transformationDocEntryUUID2).setPatientId(
				TestConfiguration.PATIENT_ID);
		// prac setting code
		txnData.getDocumentEntry(transformationDocEntryUUID2)
				.setPracticeSettingCode(TestConfiguration.PRACTICE_SETTING_CODE);
		// type code
		txnData.getDocumentEntry(transformationDocEntryUUID2).setTypeCode(
				TestConfiguration.TYPE_CODE);

		txnData.getDocumentEntry(this.transformationDocEntryUUID2).setSourcePatientInfo(sourcePatientInfo);
		
		addStudyInfo(txnData, transformationDocEntryUUID2);
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(transformationDocEntryUUID2)
				.setUniqueId(
						OID.createOIDGivenRoot(
								TestConfiguration.ORGANIZATIONAL_OID, 64));
		logger.debug("Done setting documentEntry metadata for: "
				+ txnData.getDocumentEntry(transformationDocEntryUUID2)
						.toString());
		parentDocument = metadataFactory.createParentDocumentType();
		parentDocument.setParentDocumentId(addendumDocEntryUUID2);
		parentDocument
				.setParentDocumentRelationship(ParentDocumentRelationshipType.XFRM_LITERAL);
		txnData.getDocumentEntry(transformationDocEntryUUID2)
				.setParentDocument(parentDocument);

		// add submission set metadata
		logger.debug("Applying Submission Set Metadata to the Submission.");
		SubmissionSetType submissionSetType = metadataFactory
				.createSubmissionSetType();
		submissionSetType.setSourceId(TestConfiguration.ORGANIZATIONAL_OID);
		submissionSetType
				.setUniqueId(OID
						.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		submissionSetType.setSubmissionTime(TestUtils.formGMT_DTM());
		submissionSetType.setPatientId(TestConfiguration.PATIENT_ID);
		submissionSetType.setEntryUUID(UUID.generateURN());
		txnData.getMetadata().setSubmissionSet(submissionSetType);

		logger.debug("Submitting Document.");
		XDSResponseType response = source.submit(txnData);
		String reponseStatus = response.getStatus().getName();
		logger.debug("Response status: " + reponseStatus);
		assertNotNull(reponseStatus);
		assertEquals("The response should be success", "Success", reponseStatus);
		if (response.getErrorList() != null) {
			if (response.getErrorList().getError() != null) {
				logger.debug("Returned "
						+ response.getErrorList().getError().size()
						+ " errors.");
			}
		}
		logger.debug("DONE MESA 11747 with metadata extraction from CDA");
	}

	private void submitAPNDDocument() throws Exception {

		SubmitTransactionData txnData = new SubmitTransactionData();
		// invoke transformation for metadata extraction on test files

		txnData.addExistingDocument(docEntryUUID1);
		// added document 1
		logger.debug("Adding input document 1, and metadata.");
		XDSDocument clinicalDocument1 = new XDSDocumentFromFile(
				DocumentDescriptor_KOS,
				"src/test/resources/sample_files/test1/input.xml");
		addendumDocEntryUUID1 = txnData.addDocument(clinicalDocument1);

		logger.debug("Supplementing Document Entry metadata for document 1");
		// set classCode
		txnData.getDocumentEntry(addendumDocEntryUUID1).setClassCode(
				TestConfiguration.CLASS_CODE);
		// re-set conf code
		txnData.getDocumentEntry(addendumDocEntryUUID1)
				.getConfidentialityCode().clear();
		txnData.getDocumentEntry(addendumDocEntryUUID1)
				.getConfidentialityCode()
				.addAll(TestConfiguration.ADDITIONAL_CONFIDENTIALITY_CODE_CLAUSES);
		// format code
		txnData.getDocumentEntry(addendumDocEntryUUID1).setFormatCode(
				TestConfiguration.FORMAT_CODE);
		// healthcare facilty code
		txnData.getDocumentEntry(addendumDocEntryUUID1)
				.setHealthCareFacilityTypeCode(
						TestConfiguration.HEALTHCARE_FACILITY_CODE);
		// patient Id
		txnData.getDocumentEntry(addendumDocEntryUUID1).setPatientId(
				TestConfiguration.PATIENT_ID);
		// prac setting code
		txnData.getDocumentEntry(addendumDocEntryUUID1).setPracticeSettingCode(
				TestConfiguration.PRACTICE_SETTING_CODE);
		// type code
		txnData.getDocumentEntry(addendumDocEntryUUID1).setTypeCode(
				TestConfiguration.TYPE_CODE);

		txnData.getDocumentEntry(this.addendumDocEntryUUID1).setSourcePatientInfo(sourcePatientInfo);
		
		addStudyInfo(txnData, addendumDocEntryUUID1);
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(addendumDocEntryUUID1)
				.setUniqueId(
						OID.createOIDGivenRoot(
								TestConfiguration.ORGANIZATIONAL_OID, 64));
		logger.debug("Done setting documentEntry metadata for: "
				+ txnData.getDocumentEntry(addendumDocEntryUUID1).toString());
		ParentDocumentType parentDocument = metadataFactory
				.createParentDocumentType();
		parentDocument.setParentDocumentId(docEntryUUID1);
		parentDocument
				.setParentDocumentRelationship(ParentDocumentRelationshipType.APND_LITERAL);
		txnData.getDocumentEntry(addendumDocEntryUUID1).setParentDocument(
				parentDocument);

		txnData.addExistingDocument(docEntryUUID2);
		// document 2
		logger.debug("Adding input document 2, and metadata.");
		XDSDocument clinicalDocument2 = new XDSDocumentFromFile(
				DocumentDescriptor_KOS,
				"src/test/resources/sample_files/test2/ScanSample.xml");
		addendumDocEntryUUID2 = txnData.addDocument(clinicalDocument2);

		logger.debug("Supplementing Document Entry metadata for document 2");
		// set classCode
		txnData.getDocumentEntry(addendumDocEntryUUID2).setClassCode(
				TestConfiguration.CLASS_CODE);
		// re-set conf code
		txnData.getDocumentEntry(addendumDocEntryUUID2)
				.getConfidentialityCode().clear();
		txnData.getDocumentEntry(addendumDocEntryUUID2)
				.getConfidentialityCode()
				.addAll(TestConfiguration.ADDITIONAL_CONFIDENTIALITY_CODE_CLAUSES);
		// format code
		txnData.getDocumentEntry(addendumDocEntryUUID2).setFormatCode(
				TestConfiguration.FORMAT_CODE);
		// healthcare facilty code
		txnData.getDocumentEntry(addendumDocEntryUUID2)
				.setHealthCareFacilityTypeCode(
						TestConfiguration.HEALTHCARE_FACILITY_CODE);
		// patient Id
		txnData.getDocumentEntry(addendumDocEntryUUID2).setPatientId(
				TestConfiguration.PATIENT_ID);
		// prac setting code
		txnData.getDocumentEntry(addendumDocEntryUUID2).setPracticeSettingCode(
				TestConfiguration.PRACTICE_SETTING_CODE);
		// type code
		txnData.getDocumentEntry(addendumDocEntryUUID2).setTypeCode(
				TestConfiguration.TYPE_CODE);

		txnData.getDocumentEntry(this.addendumDocEntryUUID2).setSourcePatientInfo(sourcePatientInfo);
		
		addStudyInfo(txnData, addendumDocEntryUUID2);
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(addendumDocEntryUUID2)
				.setUniqueId(
						OID.createOIDGivenRoot(
								TestConfiguration.ORGANIZATIONAL_OID, 64));
		logger.debug("Done setting documentEntry metadata for: "
				+ txnData.getDocumentEntry(addendumDocEntryUUID2).toString());
		parentDocument = metadataFactory.createParentDocumentType();
		parentDocument.setParentDocumentId(docEntryUUID2);
		parentDocument
				.setParentDocumentRelationship(ParentDocumentRelationshipType.APND_LITERAL);
		txnData.getDocumentEntry(addendumDocEntryUUID2).setParentDocument(
				parentDocument);

		// add submission set metadata
		logger.debug("Applying Submission Set Metadata to the Submission.");
		SubmissionSetType submissionSetType = metadataFactory
				.createSubmissionSetType();
		submissionSetType.setSourceId(TestConfiguration.ORGANIZATIONAL_OID);
		submissionSetType
				.setUniqueId(OID
						.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		submissionSetType.setSubmissionTime(TestUtils.formGMT_DTM());
		submissionSetType.setPatientId(TestConfiguration.PATIENT_ID);
		submissionSetType.setEntryUUID(UUID.generateURN());
		txnData.getMetadata().setSubmissionSet(submissionSetType);

		logger.debug("Submitting Document.");
		XDSResponseType response = source.submit(txnData);
		String reponseStatus = response.getStatus().getName();
		logger.debug("Response status: " + reponseStatus);
		assertNotNull(reponseStatus);
		assertEquals("The response should be success", "Success", reponseStatus);
		if (response.getErrorList() != null) {
			if (response.getErrorList().getError() != null) {
				logger.debug("Returned "
						+ response.getErrorList().getError().size()
						+ " errors.");
			}
		}
		logger.debug("DONE MESA 11747 with metadata extraction from CDA");
	}

	public void submitDocument() throws Exception {
		logger.debug("BEGIN MESA 11747 with metadata extraction from CDA");

		SubmitTransactionData txnData = new SubmitTransactionData();
		// invoke transformation for metadata extraction on test files

		// document 1
		logger.debug("Adding input document 1, and metadata.");
		XDSDocument clinicalDocument1 = new XDSDocumentFromFile(
				DocumentDescriptor_KOS,
				"src/test/resources/sample_files/test1/input.xml");
		docEntryUUID1 = txnData.addDocument(clinicalDocument1);

		logger.debug("Supplementing Document Entry metadata for document 1");
		// set classCode
		txnData.getDocumentEntry(docEntryUUID1).setClassCode(
				TestConfiguration.CLASS_CODE);
		// re-set conf code
		txnData.getDocumentEntry(docEntryUUID1).getConfidentialityCode()
				.clear();
		txnData.getDocumentEntry(docEntryUUID1)
				.getConfidentialityCode()
				.addAll(TestConfiguration.ADDITIONAL_CONFIDENTIALITY_CODE_CLAUSES);
		// format code
		txnData.getDocumentEntry(docEntryUUID1).setFormatCode(
				TestConfiguration.FORMAT_CODE);
		// healthcare facilty code
		txnData.getDocumentEntry(docEntryUUID1).setHealthCareFacilityTypeCode(
				TestConfiguration.HEALTHCARE_FACILITY_CODE);
		// patient Id
		txnData.getDocumentEntry(docEntryUUID1).setPatientId(
				TestConfiguration.PATIENT_ID);
		// prac setting code
		txnData.getDocumentEntry(docEntryUUID1).setPracticeSettingCode(
				TestConfiguration.PRACTICE_SETTING_CODE);
		// type code
		txnData.getDocumentEntry(docEntryUUID1).setTypeCode(
				TestConfiguration.TYPE_CODE);

		addStudyInfo(txnData, docEntryUUID1);
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(docEntryUUID1)
				.setUniqueId(
						OID.createOIDGivenRoot(
								TestConfiguration.ORGANIZATIONAL_OID, 64));

		logger.debug("Done setting documentEntry metadata for: "
				+ txnData.getDocumentEntry(docEntryUUID1).toString());
		// txnData.dumpMetadataToFile("C:/temp/metadata2.xml");

		// txnData.dumpMetadataToFile("C:/temp/metadata3.xml");
		// document 2
		logger.debug("Adding input document 2, and metadata.");
		XDSDocument clinicalDocument2 = new XDSDocumentFromFile(
				DocumentDescriptor_KOS,
				"src/test/resources/sample_files/test2/ScanSample.xml");
		docEntryUUID2 = txnData.addDocument(clinicalDocument2);

		logger.debug("Supplementing Document Entry metadata for document 2");
		// set classCode
		txnData.getDocumentEntry(docEntryUUID2).setClassCode(
				TestConfiguration.CLASS_CODE);
		// re-set conf code
		txnData.getDocumentEntry(docEntryUUID2).getConfidentialityCode()
				.clear();
		txnData.getDocumentEntry(docEntryUUID2)
				.getConfidentialityCode()
				.addAll(TestConfiguration.ADDITIONAL_CONFIDENTIALITY_CODE_CLAUSES);
		// format code
		txnData.getDocumentEntry(docEntryUUID2).setFormatCode(
				TestConfiguration.FORMAT_CODE);
		// healthcare facilty code
		txnData.getDocumentEntry(docEntryUUID2).setHealthCareFacilityTypeCode(
				TestConfiguration.HEALTHCARE_FACILITY_CODE);
		// patient Id
		txnData.getDocumentEntry(docEntryUUID2).setPatientId(
				TestConfiguration.PATIENT_ID);
		// prac setting code
		txnData.getDocumentEntry(docEntryUUID2).setPracticeSettingCode(
				TestConfiguration.PRACTICE_SETTING_CODE);
		// type code
		txnData.getDocumentEntry(docEntryUUID2).setTypeCode(
				TestConfiguration.TYPE_CODE);

		addStudyInfo(txnData, docEntryUUID2);
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(docEntryUUID2)
				.setUniqueId(
						OID.createOIDGivenRoot(
								TestConfiguration.ORGANIZATIONAL_OID, 64));

		logger.debug("Done setting documentEntry metadata for: "
				+ txnData.getDocumentEntry(docEntryUUID2).toString());

		// add submission set metadata
		logger.debug("Applying Submission Set Metadata to the Submission.");
		SubmissionSetType submissionSetType = metadataFactory
				.createSubmissionSetType();
		submissionSetType.setSourceId(TestConfiguration.ORGANIZATIONAL_OID);
		submissionSetType
				.setUniqueId(OID
						.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		submissionSetType.setSubmissionTime(TestUtils.formGMT_DTM());
		submissionSetType.setPatientId(TestConfiguration.PATIENT_ID);
		submissionSetType.setEntryUUID(UUID.generateURN());
		txnData.getMetadata().setSubmissionSet(submissionSetType);

		logger.debug("Submitting Document.");
		XDSResponseType response = source.submit(txnData);
		String reponseStatus = response.getStatus().getName();
		logger.debug("Response status: " + reponseStatus);
		assertNotNull(reponseStatus);
		assertEquals("The response should be success", "Success", reponseStatus);
		if (response.getErrorList() != null) {
			if (response.getErrorList().getError() != null) {
				logger.debug("Returned "
						+ response.getErrorList().getError().size()
						+ " errors.");
			}
		}
		logger.debug("DONE MESA 11747 with metadata extraction from CDA");
	}

	private void addStudyInfo(SubmitTransactionData txnData,
			String docEntryUUID1) {

		addStudyInfoExtension(txnData, docEntryUUID1,
				"urn:rad:studyDescription", "studyDescription");
		addStudyInfoExtension(txnData, docEntryUUID1, "urn:rad:studyID",
				"studyID");
		addStudyInfoExtension(txnData, docEntryUUID1,
				"urn:rad:studyInstanceUID", "studyInstanceUID");
		addStudyInfoExtension(txnData, docEntryUUID1,
				"urn:rad:studyInstitution", "studyInstitution");
		addStudyInfoExtension(txnData, docEntryUUID1, "urn:rad:modalityList",
				"modalityList");
		addStudyInfoExtension(txnData, docEntryUUID1, "urn:rad:seriesCount",
				"12312");
		addStudyInfoExtension(txnData, docEntryUUID1, "urn:rad:imagesCount",
				"12321");
		addStudyInfoExtension(txnData, docEntryUUID1,
				"urn:rad:accessionNumber", "accessionNumber");
		addStudyInfoExtension(txnData, docEntryUUID1,
				"urn:rad:logicalAccessionNumber", "logicalAccessionNumber");
		addStudyInfoExtension(txnData, docEntryUUID1, "urn:rad:caseNumber",
				"caseNumber");
		addStudyInfoExtension(txnData, docEntryUUID1, "urn:rad:studyStatus",
				"studyStatus");
	}

	private void addStudyInfoExtension(SubmitTransactionData txnData,
			String docEntryUUID1, String name, String value) {
		ExtensionType newExtension = metadataFactory.createExtensionType();
		newExtension.setName(name);
		newExtension.getValue().add(value);
		txnData.getDocumentEntry(docEntryUUID1).getExtension()
				.add(newExtension);
	}
}
