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

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openhealthtools.ihe.utils.OID;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.document.XDSDocumentFromFile;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.extract.InputStreamDocumentEntryExtractor;
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
public class Mesa11747 extends B_SourceMesaTest {

	// logger
	private static final Logger logger = Logger.getLogger(Mesa11747.class);

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

		SubmitTransactionData txnData = new SubmitTransactionData();
		// invoke transformation for metadata extraction on test files
		
		// document 1
		logger.debug("Adding input document 1, and metadata.");
		XDSDocument clinicalDocument1 = new XDSDocumentFromFile(DocumentDescriptor.XDS_SD,"src/test/resources/sample_files/test1/input.xml");
		String docEntryUUID1 = txnData.addDocument(clinicalDocument1);
		
		
		logger.debug("Supplementing Document Entry metadata for document 1");
		File docEntryFile = new File ("src/test/resources/sample_files/test1/docEntry.xml");
		FileInputStream fis = new FileInputStream(docEntryFile);
		InputStreamDocumentEntryExtractor deExtractor = new InputStreamDocumentEntryExtractor(fis);
		DocumentEntryType docEntryFixes = deExtractor.extract();
		fis.close();
		
		// set classCode
		txnData.getDocumentEntry(docEntryUUID1).setClassCode(docEntryFixes.getClassCode());
		// re-set conf code
		txnData.getDocumentEntry(docEntryUUID1).getConfidentialityCode().clear();
		txnData.getDocumentEntry(docEntryUUID1).getConfidentialityCode().add(docEntryFixes.getConfidentialityCode().get(0));
		// format code
		txnData.getDocumentEntry(docEntryUUID1).setFormatCode(docEntryFixes.getFormatCode());
		// healthcare facilty code
		txnData.getDocumentEntry(docEntryUUID1).setHealthCareFacilityTypeCode(docEntryFixes.getHealthCareFacilityTypeCode());
		// patient Id
		txnData.getDocumentEntry(docEntryUUID1).setPatientId(docEntryFixes.getPatientId());
		// prac setting code
		txnData.getDocumentEntry(docEntryUUID1).setPracticeSettingCode(docEntryFixes.getPracticeSettingCode());
		// type code
		txnData.getDocumentEntry(docEntryUUID1).setTypeCode(docEntryFixes.getTypeCode());
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(docEntryUUID1).setUniqueId(OID.createOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID, 64));
		logger.debug("Done setting documentEntry metadata for: " +txnData.getDocumentEntry(docEntryUUID1).toString());
		//txnData.dumpMetadataToFile("C:/temp/metadata2.xml");
		
		
		// document 2
		logger.debug("Adding input document 2, and metadata.");
		XDSDocument clinicalDocument2 = new XDSDocumentFromFile(DocumentDescriptor.XDS_SD,"src/test/resources/sample_files/test2/ScanSample.xml");
		String docEntryUUID2 = txnData.addDocument(clinicalDocument2);
		
		
		logger.debug("Supplementing Document Entry metadata for document 2");
		docEntryFile = new File ("src/test/resources/sample_files/test2/docEntry.xml");
		fis = new FileInputStream(docEntryFile);
		deExtractor = new InputStreamDocumentEntryExtractor(fis);
		docEntryFixes = deExtractor.extract();
		fis.close();
		
		// set classCode
		txnData.getDocumentEntry(docEntryUUID2).setClassCode(docEntryFixes.getClassCode());
		// re-set conf code
		txnData.getDocumentEntry(docEntryUUID2).getConfidentialityCode().clear();
		txnData.getDocumentEntry(docEntryUUID2).getConfidentialityCode().add(docEntryFixes.getConfidentialityCode().get(0));
		// format code
		txnData.getDocumentEntry(docEntryUUID2).setFormatCode(docEntryFixes.getFormatCode());
		// healthcare facilty code
		txnData.getDocumentEntry(docEntryUUID2).setHealthCareFacilityTypeCode(docEntryFixes.getHealthCareFacilityTypeCode());
		// patient Id
		txnData.getDocumentEntry(docEntryUUID2).setPatientId(docEntryFixes.getPatientId());
		// prac setting code
		txnData.getDocumentEntry(docEntryUUID2).setPracticeSettingCode(docEntryFixes.getPracticeSettingCode());
		// type code
		txnData.getDocumentEntry(docEntryUUID2).setTypeCode(docEntryFixes.getTypeCode());
		// set uniqueID
		// say that you are assigned an organizational oid of "1.2.3.4"
		txnData.getDocumentEntry(docEntryUUID2).setUniqueId(OID.createOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID, 64));
		logger.debug("Done setting documentEntry metadata for: " +txnData.getDocumentEntry(docEntryUUID2).toString());
		//txnData.dumpMetadataToFile("C:/temp/metadata2.xml");

		// add submission set metadata
		logger.debug("Applying Submission Set Metadata to the Submission.");
		File submissionSetFile = new File("src/test/resources/sample_files/test2/submissionSet.xml");
		fis = new FileInputStream(submissionSetFile);
		txnData.loadSubmissionSet(fis);
		fis.close();
		//txnData.dumpMetadataToFile("C:/temp/metadata3.xml");
		
		// set uniqueID
		// say that you are assigned an organizational oid of TestConfiguration.ORGANIZATIONAL_OID
		txnData.getSubmissionSet().setUniqueId(OID.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		// set submission time
		txnData.getSubmissionSet().setSubmissionTime(TestUtils.formGMT_DTM());
		//System.out.println ("Submission TIME: " + txnData.getSubmissionSet().getSubmissionTime());
		//txnData.saveMetadataToFile("C:/temp/metadata.xml");
		
		// set submission set source id
		txnData.getSubmissionSet().setSourceId(TestConfiguration.ORGANIZATIONAL_OID);
		
		
		logger.debug("Submitting Document.");
		XDSResponseType response = source.submit(txnData);
		logger.debug("Response status: " + response.getStatus().getName());
		if(response.getErrorList() != null){
			if(response.getErrorList().getError() != null){
				logger.debug("Returned " + response.getErrorList().getError().size() + " errors.");
			}
		}
		logger.debug("DONE MESA 11747 with metadata extraction from CDA");
	}
}
