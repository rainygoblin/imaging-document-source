package com.axonmed.xds.source.mesa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openhealthtools.ihe.utils.OID;
import org.openhealthtools.ihe.xds.metadata.extract.MetadataExtractionException;
import org.openhealthtools.ihe.xds.response.XDSResponseType;
import org.openhealthtools.ihe.xds.source.B_Source;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

public class Mesa11728 extends B_SourceMesaTest{

	private static final Logger logger = Logger.getLogger(Mesa11728.class);

	
	@Test
	public void test() throws Exception {
		logger.debug("BEGIN MESA 11728 using metadata from files");

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
		txnData.getSubmissionSet().setUniqueId(OID.create64CharOIDGivenRoot("1.3.6.1.4.1.21367.2010.1.2.166"));
		// set submission time
//		txnData.getSubmissionSet().setSubmissionTime(TestUtils.formGMT_DTM());
		//txnData.saveMetadataToFile("C:/temp/metadata.xml");
		
		// set submission set source id
		txnData.getSubmissionSet().setSourceId("1.3.6.1.4.1.21367.2010.1.2.166");
		
		// add folder metadata
		logger.debug("Applying Folder Metadata to the Submission.");
		File folderFile = new File("src/test/resources/sample_files/folderTest/folder.xml");
		fis = new FileInputStream(folderFile);
		String folderEntryUUID = txnData.loadFolder(fis);
		fis.close();
		//txnData.dumpMetadataToFile("C:/temp/metadata3.xml");
		
		// set uniqueID
		// say that you are assigned an organizational oid of TestConfiguration.ORGANIZATIONAL_OID
		txnData.getFolder(folderEntryUUID).setUniqueId(OID.create64CharOIDGivenRoot("1.3.6.1.4.1.21367.2010.1.2.166"));
		
		
		logger.debug("Submitting Folder.");
		XDSResponseType response = source.submit(txnData);
		logger.debug("Response status: " + response.getStatus().getName());
		if(response.getErrorList() != null){
			if(response.getErrorList().getError() != null){
				logger.debug("Returned " + response.getErrorList().getError().size() + " errors.");
			}
		}
		logger.debug("DONE MESA 11728 using metadata from files");
	}

}
