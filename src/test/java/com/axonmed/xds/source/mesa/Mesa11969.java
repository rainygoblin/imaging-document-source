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
import org.openhealthtools.ihe.xds.response.XDSResponseType;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

/**
 * Prior to running this test you will need to set the appropriate parameters in 
 * TestConfiguration.java
 * <br>
 * Submit a folder via xds.b
 * Data for this test is in ./resources/sample_files/folderTest/
 * <br>
 * Corresponds to Connectathon 2008-2009 Test: 11969
 * <br>
 * http://ihewiki.wustl.edu/wiki/index.php/XDS_Test_Kit_2007-2008_Test_Descriptions#11969
 * 
 * @author <a href="mailto:seknoop@us.ibm.com">Sarah Knoop</a>
 */
public class Mesa11969 extends B_SourceMesaTest {

	// logger
	private static final Logger logger = Logger.getLogger(Mesa11969.class);
	
	/**
	 * Submit a folder via xds.b
	 * Data for this test is in ./resources/sample_files/folderTest/
	 * <br>
	 * Corresponds to Connectathon 2008-2009 Test: 11969
	 * <br>
	 * http://ihewiki.wustl.edu/wiki/index.php/XDS_Test_Kit_2007-2008_Test_Descriptions#11969
	 * @throws Throwable
	 */
	@Test
	public void test() throws Throwable {
		logger.debug("BEGIN MESA 11969 using metadata from files");

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
		XDSResponseType response = source.submit(txnData);
		logger.debug("Response status: " + response.getStatus().getName());
		if(response.getErrorList() != null){
			if(response.getErrorList().getError() != null){
				logger.debug("Returned " + response.getErrorList().getError().size() + " errors.");
			}
		}
		logger.debug("DONE MESA 11969 using metadata from files");
	}
}
