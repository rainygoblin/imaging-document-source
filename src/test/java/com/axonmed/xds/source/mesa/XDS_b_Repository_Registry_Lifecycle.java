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
import org.openhealthtools.ihe.utils.OID;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.document.XDSDocumentFromFile;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;
import org.openhealthtools.ihe.xds.metadata.ParentDocumentRelationshipType;
import org.openhealthtools.ihe.xds.metadata.ParentDocumentType;
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
public class XDS_b_Repository_Registry_Lifecycle extends B_SourceMesaTest {

	// logger
	private static final Logger logger = Logger
			.getLogger(XDS_b_Repository_Registry_Lifecycle.class);

	private String docEntryUUID1;
	private String docEntryUUID2;
	private String addendumDocEntryUUID1;
	private String addendumDocEntryUUID2;
	private String transformationDocEntryUUID1;
	private String transformationDocEntryUUID2;
	private String replacementDocEntryUUID1;
	private String replacementDocEntryUUID2;
	
	
	

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
				DocumentDescriptor.XDS_SD,
				"src/test/resources/sample_files/test1/input.xml");
		replacementDocEntryUUID1 = txnData.addDocument(clinicalDocument1);

		logger.debug("Supplementing Document Entry metadata for document 1");
		File docEntryFile = new File(
				"src/test/resources/sample_files/test1/docEntry.xml");
		FileInputStream fis = new FileInputStream(docEntryFile);
		InputStreamDocumentEntryExtractor deExtractor = new InputStreamDocumentEntryExtractor(
				fis);
		DocumentEntryType docEntryFixes = deExtractor.extract();
		fis.close();

		// set classCode
		txnData.getDocumentEntry(replacementDocEntryUUID1).setClassCode(
				docEntryFixes.getClassCode());
		// re-set conf code
		txnData.getDocumentEntry(replacementDocEntryUUID1)
				.getConfidentialityCode().clear();
		txnData.getDocumentEntry(replacementDocEntryUUID1)
				.getConfidentialityCode()
				.add(docEntryFixes.getConfidentialityCode().get(0));
		// format code
		txnData.getDocumentEntry(replacementDocEntryUUID1).setFormatCode(
				docEntryFixes.getFormatCode());
		// healthcare facilty code
		txnData.getDocumentEntry(replacementDocEntryUUID1)
				.setHealthCareFacilityTypeCode(
						docEntryFixes.getHealthCareFacilityTypeCode());
		// patient Id
		txnData.getDocumentEntry(replacementDocEntryUUID1).setPatientId(
				docEntryFixes.getPatientId());
		// prac setting code
		txnData.getDocumentEntry(replacementDocEntryUUID1).setPracticeSettingCode(
				docEntryFixes.getPracticeSettingCode());
		// type code
		txnData.getDocumentEntry(replacementDocEntryUUID1).setTypeCode(
				docEntryFixes.getTypeCode());
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(replacementDocEntryUUID1)
				.setUniqueId(
						OID.createOIDGivenRoot(
								TestConfiguration.ORGANIZATIONAL_OID, 64));
		logger.debug("Done setting documentEntry metadata for: "
				+ txnData.getDocumentEntry(replacementDocEntryUUID1).toString());
		MetadataFactory metadataFactory = new MetadataFactoryImpl();
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
				DocumentDescriptor.XDS_SD,
				"src/test/resources/sample_files/test2/ScanSample.xml");
		replacementDocEntryUUID2 = txnData.addDocument(clinicalDocument2);

		logger.debug("Supplementing Document Entry metadata for document 2");
		docEntryFile = new File(
				"src/test/resources/sample_files/test2/docEntry.xml");
		fis = new FileInputStream(docEntryFile);
		deExtractor = new InputStreamDocumentEntryExtractor(fis);
		docEntryFixes = deExtractor.extract();
		fis.close();

		// set classCode
		txnData.getDocumentEntry(replacementDocEntryUUID2).setClassCode(
				docEntryFixes.getClassCode());
		// re-set conf code
		txnData.getDocumentEntry(replacementDocEntryUUID2)
				.getConfidentialityCode().clear();
		txnData.getDocumentEntry(replacementDocEntryUUID2)
				.getConfidentialityCode()
				.add(docEntryFixes.getConfidentialityCode().get(0));
		// format code
		txnData.getDocumentEntry(replacementDocEntryUUID2).setFormatCode(
				docEntryFixes.getFormatCode());
		// healthcare facilty code
		txnData.getDocumentEntry(replacementDocEntryUUID2)
				.setHealthCareFacilityTypeCode(
						docEntryFixes.getHealthCareFacilityTypeCode());
		// patient Id
		txnData.getDocumentEntry(replacementDocEntryUUID2).setPatientId(
				docEntryFixes.getPatientId());
		// prac setting code
		txnData.getDocumentEntry(replacementDocEntryUUID2).setPracticeSettingCode(
				docEntryFixes.getPracticeSettingCode());
		// type code
		txnData.getDocumentEntry(replacementDocEntryUUID2).setTypeCode(
				docEntryFixes.getTypeCode());
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
		File submissionSetFile = new File(
				"src/test/resources/sample_files/test2/submissionSet.xml");
		fis = new FileInputStream(submissionSetFile);
		txnData.loadSubmissionSet(fis);
		fis.close();
		// txnData.dumpMetadataToFile("C:/temp/metadata3.xml");

		// set uniqueID
		// say that you are assigned an organizational oid of
		// TestConfiguration.ORGANIZATIONAL_OID
		txnData.getSubmissionSet()
				.setUniqueId(
						OID.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		// set submission time
		txnData.getSubmissionSet().setSubmissionTime(TestUtils.formGMT_DTM());
		// System.out.println ("Submission TIME: " +
		// txnData.getSubmissionSet().getSubmissionTime());
		// txnData.saveMetadataToFile("C:/temp/metadata.xml");

		// set submission set source id
		txnData.getSubmissionSet().setSourceId(
				TestConfiguration.ORGANIZATIONAL_OID);

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
				DocumentDescriptor.XDS_SD,
				"src/test/resources/sample_files/test1/input.xml");
		transformationDocEntryUUID1 = txnData.addDocument(clinicalDocument1);

		logger.debug("Supplementing Document Entry metadata for document 1");
		File docEntryFile = new File(
				"src/test/resources/sample_files/test1/docEntry.xml");
		FileInputStream fis = new FileInputStream(docEntryFile);
		InputStreamDocumentEntryExtractor deExtractor = new InputStreamDocumentEntryExtractor(
				fis);
		DocumentEntryType docEntryFixes = deExtractor.extract();
		fis.close();

		// set classCode
		txnData.getDocumentEntry(transformationDocEntryUUID1).setClassCode(
				docEntryFixes.getClassCode());
		// re-set conf code
		txnData.getDocumentEntry(transformationDocEntryUUID1)
				.getConfidentialityCode().clear();
		txnData.getDocumentEntry(transformationDocEntryUUID1)
				.getConfidentialityCode()
				.add(docEntryFixes.getConfidentialityCode().get(0));
		// format code
		txnData.getDocumentEntry(transformationDocEntryUUID1).setFormatCode(
				docEntryFixes.getFormatCode());
		// healthcare facilty code
		txnData.getDocumentEntry(transformationDocEntryUUID1)
				.setHealthCareFacilityTypeCode(
						docEntryFixes.getHealthCareFacilityTypeCode());
		// patient Id
		txnData.getDocumentEntry(transformationDocEntryUUID1).setPatientId(
				docEntryFixes.getPatientId());
		// prac setting code
		txnData.getDocumentEntry(transformationDocEntryUUID1).setPracticeSettingCode(
				docEntryFixes.getPracticeSettingCode());
		// type code
		txnData.getDocumentEntry(transformationDocEntryUUID1).setTypeCode(
				docEntryFixes.getTypeCode());
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(transformationDocEntryUUID1)
				.setUniqueId(
						OID.createOIDGivenRoot(
								TestConfiguration.ORGANIZATIONAL_OID, 64));
		logger.debug("Done setting documentEntry metadata for: "
				+ txnData.getDocumentEntry(transformationDocEntryUUID1).toString());
		MetadataFactory metadataFactory = new MetadataFactoryImpl();
		ParentDocumentType parentDocument = metadataFactory
				.createParentDocumentType();
		parentDocument.setParentDocumentId(addendumDocEntryUUID1);
		parentDocument
				.setParentDocumentRelationship(ParentDocumentRelationshipType.XFRM_LITERAL);
		txnData.getDocumentEntry(transformationDocEntryUUID1).setParentDocument(
				parentDocument);

		txnData.addExistingDocument(addendumDocEntryUUID2);
		// document 2
		logger.debug("Adding input document 2, and metadata.");
		XDSDocument clinicalDocument2 = new XDSDocumentFromFile(
				DocumentDescriptor.XDS_SD,
				"src/test/resources/sample_files/test2/ScanSample.xml");
		transformationDocEntryUUID2 = txnData.addDocument(clinicalDocument2);

		logger.debug("Supplementing Document Entry metadata for document 2");
		docEntryFile = new File(
				"src/test/resources/sample_files/test2/docEntry.xml");
		fis = new FileInputStream(docEntryFile);
		deExtractor = new InputStreamDocumentEntryExtractor(fis);
		docEntryFixes = deExtractor.extract();
		fis.close();

		// set classCode
		txnData.getDocumentEntry(transformationDocEntryUUID2).setClassCode(
				docEntryFixes.getClassCode());
		// re-set conf code
		txnData.getDocumentEntry(transformationDocEntryUUID2)
				.getConfidentialityCode().clear();
		txnData.getDocumentEntry(transformationDocEntryUUID2)
				.getConfidentialityCode()
				.add(docEntryFixes.getConfidentialityCode().get(0));
		// format code
		txnData.getDocumentEntry(transformationDocEntryUUID2).setFormatCode(
				docEntryFixes.getFormatCode());
		// healthcare facilty code
		txnData.getDocumentEntry(transformationDocEntryUUID2)
				.setHealthCareFacilityTypeCode(
						docEntryFixes.getHealthCareFacilityTypeCode());
		// patient Id
		txnData.getDocumentEntry(transformationDocEntryUUID2).setPatientId(
				docEntryFixes.getPatientId());
		// prac setting code
		txnData.getDocumentEntry(transformationDocEntryUUID2).setPracticeSettingCode(
				docEntryFixes.getPracticeSettingCode());
		// type code
		txnData.getDocumentEntry(transformationDocEntryUUID2).setTypeCode(
				docEntryFixes.getTypeCode());
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(transformationDocEntryUUID2)
				.setUniqueId(
						OID.createOIDGivenRoot(
								TestConfiguration.ORGANIZATIONAL_OID, 64));
		logger.debug("Done setting documentEntry metadata for: "
				+ txnData.getDocumentEntry(transformationDocEntryUUID2).toString());
		parentDocument = metadataFactory.createParentDocumentType();
		parentDocument.setParentDocumentId(addendumDocEntryUUID2);
		parentDocument
				.setParentDocumentRelationship(ParentDocumentRelationshipType.XFRM_LITERAL);
		txnData.getDocumentEntry(transformationDocEntryUUID2).setParentDocument(
				parentDocument);

		// add submission set metadata
		logger.debug("Applying Submission Set Metadata to the Submission.");
		File submissionSetFile = new File(
				"src/test/resources/sample_files/test2/submissionSet.xml");
		fis = new FileInputStream(submissionSetFile);
		txnData.loadSubmissionSet(fis);
		fis.close();
		// txnData.dumpMetadataToFile("C:/temp/metadata3.xml");

		// set uniqueID
		// say that you are assigned an organizational oid of
		// TestConfiguration.ORGANIZATIONAL_OID
		txnData.getSubmissionSet()
				.setUniqueId(
						OID.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		// set submission time
		txnData.getSubmissionSet().setSubmissionTime(TestUtils.formGMT_DTM());
		// System.out.println ("Submission TIME: " +
		// txnData.getSubmissionSet().getSubmissionTime());
		// txnData.saveMetadataToFile("C:/temp/metadata.xml");

		// set submission set source id
		txnData.getSubmissionSet().setSourceId(
				TestConfiguration.ORGANIZATIONAL_OID);

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
				DocumentDescriptor.XDS_SD,
				"src/test/resources/sample_files/test1/input.xml");
		addendumDocEntryUUID1 = txnData.addDocument(clinicalDocument1);

		logger.debug("Supplementing Document Entry metadata for document 1");
		File docEntryFile = new File(
				"src/test/resources/sample_files/test1/docEntry.xml");
		FileInputStream fis = new FileInputStream(docEntryFile);
		InputStreamDocumentEntryExtractor deExtractor = new InputStreamDocumentEntryExtractor(
				fis);
		DocumentEntryType docEntryFixes = deExtractor.extract();
		fis.close();

		// set classCode
		txnData.getDocumentEntry(addendumDocEntryUUID1).setClassCode(
				docEntryFixes.getClassCode());
		// re-set conf code
		txnData.getDocumentEntry(addendumDocEntryUUID1)
				.getConfidentialityCode().clear();
		txnData.getDocumentEntry(addendumDocEntryUUID1)
				.getConfidentialityCode()
				.add(docEntryFixes.getConfidentialityCode().get(0));
		// format code
		txnData.getDocumentEntry(addendumDocEntryUUID1).setFormatCode(
				docEntryFixes.getFormatCode());
		// healthcare facilty code
		txnData.getDocumentEntry(addendumDocEntryUUID1)
				.setHealthCareFacilityTypeCode(
						docEntryFixes.getHealthCareFacilityTypeCode());
		// patient Id
		txnData.getDocumentEntry(addendumDocEntryUUID1).setPatientId(
				docEntryFixes.getPatientId());
		// prac setting code
		txnData.getDocumentEntry(addendumDocEntryUUID1).setPracticeSettingCode(
				docEntryFixes.getPracticeSettingCode());
		// type code
		txnData.getDocumentEntry(addendumDocEntryUUID1).setTypeCode(
				docEntryFixes.getTypeCode());
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(addendumDocEntryUUID1)
				.setUniqueId(
						OID.createOIDGivenRoot(
								TestConfiguration.ORGANIZATIONAL_OID, 64));
		logger.debug("Done setting documentEntry metadata for: "
				+ txnData.getDocumentEntry(addendumDocEntryUUID1).toString());
		MetadataFactory metadataFactory = new MetadataFactoryImpl();
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
				DocumentDescriptor.XDS_SD,
				"src/test/resources/sample_files/test2/ScanSample.xml");
		addendumDocEntryUUID2 = txnData.addDocument(clinicalDocument2);

		logger.debug("Supplementing Document Entry metadata for document 2");
		docEntryFile = new File(
				"src/test/resources/sample_files/test2/docEntry.xml");
		fis = new FileInputStream(docEntryFile);
		deExtractor = new InputStreamDocumentEntryExtractor(fis);
		docEntryFixes = deExtractor.extract();
		fis.close();

		// set classCode
		txnData.getDocumentEntry(addendumDocEntryUUID2).setClassCode(
				docEntryFixes.getClassCode());
		// re-set conf code
		txnData.getDocumentEntry(addendumDocEntryUUID2)
				.getConfidentialityCode().clear();
		txnData.getDocumentEntry(addendumDocEntryUUID2)
				.getConfidentialityCode()
				.add(docEntryFixes.getConfidentialityCode().get(0));
		// format code
		txnData.getDocumentEntry(addendumDocEntryUUID2).setFormatCode(
				docEntryFixes.getFormatCode());
		// healthcare facilty code
		txnData.getDocumentEntry(addendumDocEntryUUID2)
				.setHealthCareFacilityTypeCode(
						docEntryFixes.getHealthCareFacilityTypeCode());
		// patient Id
		txnData.getDocumentEntry(addendumDocEntryUUID2).setPatientId(
				docEntryFixes.getPatientId());
		// prac setting code
		txnData.getDocumentEntry(addendumDocEntryUUID2).setPracticeSettingCode(
				docEntryFixes.getPracticeSettingCode());
		// type code
		txnData.getDocumentEntry(addendumDocEntryUUID2).setTypeCode(
				docEntryFixes.getTypeCode());
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
		File submissionSetFile = new File(
				"src/test/resources/sample_files/test2/submissionSet.xml");
		fis = new FileInputStream(submissionSetFile);
		txnData.loadSubmissionSet(fis);
		fis.close();
		// txnData.dumpMetadataToFile("C:/temp/metadata3.xml");

		// set uniqueID
		// say that you are assigned an organizational oid of
		// TestConfiguration.ORGANIZATIONAL_OID
		txnData.getSubmissionSet()
				.setUniqueId(
						OID.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		// set submission time
		txnData.getSubmissionSet().setSubmissionTime(TestUtils.formGMT_DTM());
		// System.out.println ("Submission TIME: " +
		// txnData.getSubmissionSet().getSubmissionTime());
		// txnData.saveMetadataToFile("C:/temp/metadata.xml");

		// set submission set source id
		txnData.getSubmissionSet().setSourceId(
				TestConfiguration.ORGANIZATIONAL_OID);

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
				DocumentDescriptor.XDS_SD,
				"src/test/resources/sample_files/test1/input.xml");
		docEntryUUID1 = txnData.addDocument(clinicalDocument1);

		logger.debug("Supplementing Document Entry metadata for document 1");
		File docEntryFile = new File(
				"src/test/resources/sample_files/test1/docEntry.xml");
		FileInputStream fis = new FileInputStream(docEntryFile);
		InputStreamDocumentEntryExtractor deExtractor = new InputStreamDocumentEntryExtractor(
				fis);
		DocumentEntryType docEntryFixes = deExtractor.extract();
		fis.close();

		// set classCode
		txnData.getDocumentEntry(docEntryUUID1).setClassCode(
				docEntryFixes.getClassCode());
		// re-set conf code
		txnData.getDocumentEntry(docEntryUUID1).getConfidentialityCode()
				.clear();
		txnData.getDocumentEntry(docEntryUUID1).getConfidentialityCode()
				.add(docEntryFixes.getConfidentialityCode().get(0));
		// format code
		txnData.getDocumentEntry(docEntryUUID1).setFormatCode(
				docEntryFixes.getFormatCode());
		// healthcare facilty code
		txnData.getDocumentEntry(docEntryUUID1).setHealthCareFacilityTypeCode(
				docEntryFixes.getHealthCareFacilityTypeCode());
		// patient Id
		txnData.getDocumentEntry(docEntryUUID1).setPatientId(
				docEntryFixes.getPatientId());
		// prac setting code
		txnData.getDocumentEntry(docEntryUUID1).setPracticeSettingCode(
				docEntryFixes.getPracticeSettingCode());
		// type code
		txnData.getDocumentEntry(docEntryUUID1).setTypeCode(
				docEntryFixes.getTypeCode());
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(docEntryUUID1)
				.setUniqueId(
						OID.createOIDGivenRoot(
								TestConfiguration.ORGANIZATIONAL_OID, 64));
		logger.debug("Done setting documentEntry metadata for: "
				+ txnData.getDocumentEntry(docEntryUUID1).toString());
		// txnData.dumpMetadataToFile("C:/temp/metadata2.xml");

		// add submission set metadata
		logger.debug("Applying Submission Set Metadata to the Submission.");
		File submissionSetFile = new File(
				"src/test/resources/sample_files/test2/submissionSet.xml");
		fis = new FileInputStream(submissionSetFile);
		txnData.loadSubmissionSet(fis);
		fis.close();
		// txnData.dumpMetadataToFile("C:/temp/metadata3.xml");
		// document 2
		logger.debug("Adding input document 2, and metadata.");
		XDSDocument clinicalDocument2 = new XDSDocumentFromFile(
				DocumentDescriptor.XDS_SD,
				"src/test/resources/sample_files/test2/ScanSample.xml");
		docEntryUUID2 = txnData.addDocument(clinicalDocument2);

		logger.debug("Supplementing Document Entry metadata for document 2");
		docEntryFile = new File(
				"src/test/resources/sample_files/test2/docEntry.xml");
		fis = new FileInputStream(docEntryFile);
		deExtractor = new InputStreamDocumentEntryExtractor(fis);
		docEntryFixes = deExtractor.extract();
		fis.close();

		// set classCode
		txnData.getDocumentEntry(docEntryUUID2).setClassCode(
				docEntryFixes.getClassCode());
		// re-set conf code
		txnData.getDocumentEntry(docEntryUUID2).getConfidentialityCode()
				.clear();
		txnData.getDocumentEntry(docEntryUUID2).getConfidentialityCode()
				.add(docEntryFixes.getConfidentialityCode().get(0));
		// format code
		txnData.getDocumentEntry(docEntryUUID2).setFormatCode(
				docEntryFixes.getFormatCode());
		// healthcare facilty code
		txnData.getDocumentEntry(docEntryUUID2).setHealthCareFacilityTypeCode(
				docEntryFixes.getHealthCareFacilityTypeCode());
		// patient Id
		txnData.getDocumentEntry(docEntryUUID2).setPatientId(
				docEntryFixes.getPatientId());
		// prac setting code
		txnData.getDocumentEntry(docEntryUUID2).setPracticeSettingCode(
				docEntryFixes.getPracticeSettingCode());
		// type code
		txnData.getDocumentEntry(docEntryUUID2).setTypeCode(
				docEntryFixes.getTypeCode());
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(docEntryUUID2)
				.setUniqueId(
						OID.createOIDGivenRoot(
								TestConfiguration.ORGANIZATIONAL_OID, 64));
		logger.debug("Done setting documentEntry metadata for: "
				+ txnData.getDocumentEntry(docEntryUUID2).toString());
		// txnData.dumpMetadataToFile("C:/temp/metadata2.xml");
		// set uniqueID
		// say that you are assigned an organizational oid of
		// TestConfiguration.ORGANIZATIONAL_OID
		txnData.getSubmissionSet()
				.setUniqueId(
						OID.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		// set submission time
		txnData.getSubmissionSet().setSubmissionTime(TestUtils.formGMT_DTM());
		// System.out.println ("Submission TIME: " +
		// txnData.getSubmissionSet().getSubmissionTime());
		// txnData.saveMetadataToFile("C:/temp/metadata.xml");

		// set submission set source id
		txnData.getSubmissionSet().setSourceId(
				TestConfiguration.ORGANIZATIONAL_OID);

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

}
