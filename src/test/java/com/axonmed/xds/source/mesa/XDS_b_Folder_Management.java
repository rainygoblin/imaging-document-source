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

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openhealthtools.ihe.utils.OID;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.document.XDSDocumentFromFile;
import org.openhealthtools.ihe.xds.response.XDSResponseType;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

/**
 * Prior to running this test you will need to set the appropriate parameters in 
 * TestConfiguration.java
 * <br>
 * Submit an existing document in an existing folder using "pre-cooked" metadata via xds.b 
 * Data for this test is in src/test/resources/sample_files/folderTest/
 * <br>
 * Corresponds to Connectathon 2008-2009 Test: 11973
 * <br>
 * http://ihewiki.wustl.edu/wiki/index.php/XDS_Test_Kit_2007-2008_Test_Descriptions#11973
 * 
 * @author <a href="mailto:seknoop@us.ibm.com">Sarah Knoop</a>
 */
public class XDS_b_Folder_Management extends B_SourceMesaTest {

	// logger
	private static final Logger logger = Logger.getLogger(XDS_b_Folder_Management.class);
	
	/**
	 * Submit a document in an existing folder using "pre-cooked" metadata via xds.b
	 * Data for this test is in src/test/resources/sample_files/folderTest/
	 * <br>
	 * Corresponds to Connectathon 2008-2009 Test: 11973
	 * <br>
	 * http://ihewiki.wustl.edu/wiki/index.php/XDS_Test_Kit_2007-2008_Test_Descriptions#11973
	 * @throws Throwable
	 */
	@Test
	public void test() throws Throwable {
		logger.debug("BEGIN MESA 11973 using metadata from files");
		
		// submit folder
		String folderEntryUUID = submitFolder();

		//submit document
		String docEntryUUID = submitDocument();
		
		// submit existing document in existing folder
		SubmitTransactionData txnData = new SubmitTransactionData();
		
		// add existing doc
		logger.debug("Adding existing document");
		txnData.addExistingDocument(docEntryUUID);
		
		// add existing folder
		logger.debug("Adding existing folder");
		txnData.addExistingFolder(folderEntryUUID); 
		
		// add doc to folder
		logger.debug("Adding document to folder");
		txnData.addDocumentToFolder(docEntryUUID, folderEntryUUID);

		// add submission set metadata
		logger.debug("Applying Submission Set Metadata to the Submission.");
		File submissionSetFile = new File("src/test/resources/sample_files/folderTest/submissionSet.xml");
		FileInputStream fis = new FileInputStream(submissionSetFile);
		txnData.loadSubmissionSet(fis);
		fis.close();
		//txnData.dumpMetadataToFile("C:/temp/metadata3.xml");
		
		// set uniqueID
		// say that you are assigned an organizational oid of TestConfiguration.ORGANIZATIONAL_OID
		txnData.getSubmissionSet().setUniqueId(OID.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		// set submission time
		txnData.getSubmissionSet().setSubmissionTime(TestUtils.formGMT_DTM());
		//txnData.saveMetadataToFile("C:/temp/metadata.xml");
		
		// set submission set source id
		txnData.getSubmissionSet().setSourceId(TestConfiguration.ORGANIZATIONAL_OID);
		
		
		logger.debug("Submitting existing document in existing folder.");
		
		//FIXME sek - ideally would be set in config
//		source.setRepositoryURL(TestConfiguration.NIST_11973);
		
		XDSResponseType response = source.submit(txnData);
		logger.debug("Response status: " + response.getStatus().getName());
		if(response.getErrorList() != null){
			if(response.getErrorList().getError() != null){
				logger.debug("Returned " + response.getErrorList().getError().size() + " errors.");
			}
		}
		logger.debug("DONE MESA 11973 using metadata from files");
	}
	
	private String submitFolder() throws Exception{
		logger.debug("Submitting Folder");

		SubmitTransactionData txnData = new SubmitTransactionData();

		// add submission set metadata
		logger.debug("Applying Submission Set Metadata to the Submission.");
		File submissionSetFile = new File("src/test/resources/sample_files/folderTest/submissionSet.xml");
		FileInputStream fis = new FileInputStream(submissionSetFile);
		txnData.loadSubmissionSet(fis);
		fis.close();
		//txnData.dumpMetadataToFile("C:/temp/metadata3.xml");
		
		// set uniqueID
		// say that you are assigned an organizational oid of TestConfiguration.ORGANIZATIONAL_OID
		txnData.getSubmissionSet().setUniqueId(OID.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		// set submission time
		txnData.getSubmissionSet().setSubmissionTime(TestUtils.formGMT_DTM());
		//txnData.saveMetadataToFile("C:/temp/metadata.xml");
		
		// set submission set source id
		txnData.getSubmissionSet().setSourceId(TestConfiguration.ORGANIZATIONAL_OID);
		
		// add folder metadata
		logger.debug("Applying Folder Metadata to the Submission.");
		File folderFile = new File("src/test/resources/sample_files/folderTest/folder.xml");
		fis = new FileInputStream(folderFile);
		String folderEntryUUID = txnData.loadFolder(fis);
		fis.close();
		//txnData.dumpMetadataToFile("C:/temp/metadata3.xml");
		
		// set uniqueID
		// say that you are assigned an organizational oid of TestConfiguration.ORGANIZATIONAL_OID
		txnData.getFolder(folderEntryUUID).setUniqueId(OID.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		
		
		logger.debug("Submitting Folder.");
		//FIXME sek - ideally would be set in config
//		source.setRepositoryURL(TestConfiguration.NIST_11969);
		
		XDSResponseType response = source.submit(txnData);
		logger.debug("Response status: " + response.getStatus().getName());
		if(response.getErrorList() != null){
			if(response.getErrorList().getError() != null){
				logger.debug("Returned " + response.getErrorList().getError().size() + " errors.");
				fail("submission of initial folder unsuccsesful, cannot complete test.");
			}
		}
		logger.debug("DONE Submitting Folder");
		return folderEntryUUID;
	}
	
	
	private String submitDocument() throws Exception{
		SubmitTransactionData txnData = new SubmitTransactionData();
		// invoke transformation for metadata extraction on test file
		logger.debug("Adding input document, and metadata.");
		XDSDocument clinicalDocument = new XDSDocumentFromFile(DocumentDescriptor.CDA_R2,"src/test/resources/sample_files/folderTest/input-IBM-OHT.xml");
		File docEntryFile = new File ("src/test/resources/sample_files/folderTest/docEntry.xml");
		FileInputStream fis = new FileInputStream(docEntryFile);
		String docEntryUUID = txnData.loadDocumentWithMetadata(clinicalDocument, fis);
		
		fis.close();
		//txnData.dumpMetadataToFile("C:/temp/metadata1.xml");
		
		// set uniqueID
		// say that you are assigned an organizational oid of TestConfiguration.ORGANIZATIONAL_OID
		txnData.getDocumentEntry(docEntryUUID).setUniqueId(OID.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		logger.debug("Done setting documentEntry metadata for: " +txnData.getDocumentEntry(docEntryUUID).toString());
		//txnData.dumpMetadataToFile("C:/temp/metadata2.xml");

		// add submission set metadata
		logger.debug("Applying Submission Set Metadata to the Submission.");
		File submissionSetFile = new File("src/test/resources/sample_files/folderTest/submissionSet.xml");
		fis = new FileInputStream(submissionSetFile);
		txnData.loadSubmissionSet(fis);
		fis.close();
		//txnData.dumpMetadataToFile("C:/temp/metadata3.xml");
		
		// set uniqueID
		// say that you are assigned an organizational oid of TestConfiguration.ORGANIZATIONAL_OID
		txnData.getSubmissionSet().setUniqueId(OID.create64CharOIDGivenRoot(TestConfiguration.ORGANIZATIONAL_OID));
		// set submission time
		txnData.getSubmissionSet().setSubmissionTime(TestUtils.formGMT_DTM());
		//txnData.saveMetadataToFile("C:/temp/metadata.xml");
		
		// set submission set source id
		txnData.getSubmissionSet().setSourceId(TestConfiguration.ORGANIZATIONAL_OID);
		
		logger.debug("Submitting Document.");
		
		//FIXME sek - ideally would be set in config
//		source.setRepositoryURL(TestConfiguration.NIST_B);
		
		XDSResponseType response = source.submit(txnData);
		logger.debug("Response status: " + response.getStatus().getName());
		if(response.getErrorList() != null){
			if(response.getErrorList().getError() != null){
				logger.debug("Returned " + response.getErrorList().getError().size() + " errors.");
				fail("submission of initial document unsuccsesful, cannot complete test.");
			}
		}
		return docEntryUUID;
	}
	
}
