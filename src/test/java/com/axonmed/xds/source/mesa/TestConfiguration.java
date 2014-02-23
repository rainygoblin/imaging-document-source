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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.openhealthtools.ihe.common.hl7v2.CX;
import org.openhealthtools.ihe.common.hl7v2.Hl7v2Factory;
import org.openhealthtools.ihe.common.hl7v2.XCN;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

/**
 * This is a consolidated configuration file for running the Mesa test code. You
 * may need to edit this class to get the examples working on your own system.
 * Minimally, you will need to set your test server endpoint (as a URL).
 * 
 * @author <a href="mailto:seknoop@us.ibm.com">Sarah Knoop</a>
 * 
 */
public class TestConfiguration {
	// basics
	public static final String LOG4J_PATH = "./resources/conf/submitTest_log4j.xml";

	// ATNA logging enable/disablement
	public static final boolean DO_AUDIT = false; // change to 'true' to enable
													// auditing
	public static final String INITIATING_USER = "some user";
	public static final String AUDIT_SOURCE_ID = "OTHER_OHT";

	// TLS enablement
	public static final boolean USE_TLS = true; // change to 'true' to enable
												// TLS
	public static final String KEY_STORE = "src/test/resources/security/OpenXDS_2013_Keystore.p12";
	public static final String KEY_STORE_PASS = "123456";
	public static final String TRUST_STORE = "src/test/resources/security/OpenXDS_2013_Truststore.jks";
	public static final String TRUST_STORE_PASS = "123456";

	// Server Options
	// ////////////////////////////////////////////////////////////////////////////////////////////
	// XDS.a is deprecated as of TF6 (2009) - not tested in the 2010 NA
	// Connectathon and beyond
	// ////////////////////////////////////////////////////////////////////////////////////////////
	// NIST Repository
	public static final String NIST = "http://ihexds.nist.gov:9080/tf6/services/xdsrepositorya";

	// NIST SECURED Repository
	public static final String NIST_SECURED = "https://ihexds.nist.gov:9085/tf6/services/xdsrepositorya";

	// IBM 2007 Test sever
	public static final String IBM = "http://xds-ibm.lgs.com:9081/IBMXDSRepository/XDSa/ProvideAndRegister";

	// IBM SECURED 2007 Test sever
	public static final String IBM_SECURED = "https://xds-ibm.lgs.com:9444/IBMXDSRepository/XDSa/ProvideAndRegister";

	// OLD (prior to fall 2007) NIST Repository
	public static final String OLD_NIST = "http://hcxw2k1.nist.gov:8080/xdsServices2/registry/soap/portals/yr3a/repository";

	// OLD (prior to fall 2007) NIST SECURED Repository
	public static final String OLD_NIST_SECURED = "https://hcxw2k1.nist.gov:8443/xdsServices2/registry/soap/portals/yr3a/repository";

	// /////////////////
	// XDS.b
	// /////////////////
	// NIST XDS.b Repository
	public static final String NIST_B = "http://ihexds.nist.gov:9080/tf6/services/xdsrepositoryb";

	// NIST SECURED XDS.b Repository
	public static final String NIST_B_SECURED = "https://ihexds.nist.gov:9085/tf6/services/xdsrepositoryb";

	// NIST XDS.b Repository - async
	public static final String NIST_B_REPOSITORY_ASYNC = "http://ihexds.nist.gov:9080/tf6/services/repositorybas";

	// NIST SECURED XDS.b - async
	public static final String NIST_B_REPOSITORY_SECURED_ASYNC = "https://ihexds.nist.gov:9085/tf6/services/repositorybas";

	// IBM XDS.b Repository
	public static final String IBM_B = "http://xds-ibm.lgs.com:9080/IBMXDSRepository/XDSb/SOAP12/Repository";

	// IBM SECURED XDS.b Repository
	public static final String IBM_B_SECURED = "https://xds-ibm.lgs.com:9444/IBMXDSRepository/XDSb/SOAP12/Repository";

	// ///////////////////////////////////////
	// Endpoints for special MESA tests
	// ///////////////////////////////////////
	// 11728
	public static final String NIST_11728 = "http://ihexds.nist.gov:9080/tf6/services/test11728";

	// 11729
	public static final String NIST_11729 = "http://ihexds.nist.gov:9080/tf6/services/test11729";

	// 11747
	public static final String NIST_11747 = "http://ihexds.nist.gov:9080/tf6/services/repositoryA2doc";

	// 11748
	public static final String NIST_11748 = "http://ihexds.nist.gov:9080/tf6/services/test11748";

	// 11730
	public static final String NIST_11730 = "http://ihexds.nist.gov:9080/tf6/services/test11730";

	// 11969
	public static final String NIST_11969 = "http://ihexds.nist.gov:9080/tf6/services/test11969";

	// 11970
	public static final String NIST_11970 = "http://ihexds.nist.gov:9080/tf6/services/test11970";

	// 11971
	public static final String NIST_11971 = "http://ihexds.nist.gov:9080/tf6/services/test11971";

	// 11972
	public static final String NIST_11972 = "http://ihexds.nist.gov:9080/tf6/services/test11972";

	// 11973
	public static final String NIST_11973 = "http://ihexds.nist.gov:9080/tf6/services/test11973";

	// 11974
	public static final String NIST_11974 = "http://ihexds.nist.gov:9080/tf6/services/test11974";

	// 12047
	public static final String NIST_12047 = "http://ihexds.nist.gov:9080/tf6/services/repositoryB2doc";

	// 12049
	public static final String NIST_12049 = "http://ihexds.nist.gov:9080/tf6/services/repositoryBonedoc";

	// /////////////////
	// Audit
	// /////////////////
	// IBM Audit Repository
	public static final String IBM_ARR = "syslog://xds-ibm.lgs.com:514";

	// NIST Audit Repository
	public static final String NIST_ARR = "syslog://129.6.24.109:8087";

	// Test Server Set up (this is the endpoint that will actually be used in
	// testing)
	public static URI XDS_A_REPOSITORY_URI;
	public static URI XDS_B_REPOSITORY_URI;
	public static URI AUDIT_REPOSITORY;
	static {
		// Set the XDS.a repository URI you want to use to one of the above
		// endpoings
		// XDS.a not tested at 2010 connectathon and beyond
		/*
		 * try { // Set the registry URI you want to use to XDS_A_REPOSITORY_URI
		 * = new URI(NIST);
		 * 
		 * } catch (URISyntaxException e) { XDS_A_REPOSITORY_URI = null; }
		 */

		// Set the XDS.b repository URI you want to use to one of the above
		// endpoings
		try {
			// Set the registry URI you want to use to
			XDS_B_REPOSITORY_URI = new URI(NIST_B);
		} catch (URISyntaxException e) {
			XDS_B_REPOSITORY_URI = null;
		}
		// set the audit repository endpoint if you desire to additionally test
		// auditing
		try {
			// Set the registry URI you want to use to
			AUDIT_REPOSITORY = new URI(NIST_ARR);
		} catch (URISyntaxException e) {
			AUDIT_REPOSITORY = null;
		}

		// set TLS
		if (USE_TLS) {
			System.setProperty("javax.net.ssl.keyStore", KEY_STORE);
			System.setProperty("javax.net.ssl.keyStorePassword", KEY_STORE_PASS);
			System.setProperty("javax.net.ssl.trustStore", TRUST_STORE);
			System.setProperty("javax.net.ssl.trustStorePassword",
					TRUST_STORE_PASS);
			System.setProperty("javax.net.debug", "sslhandshake");

			// 2009 connectathon additional cipher suites
			// System.setProperty("https.ciphersuites","SSL_RSA_WITH_NULL_SHA,SSL_RSA_WITH_RC4_128_SHA,TLS_RSA_WITH_AES_128_CBC_SHA,SSL_RSA_WITH_3DES_EDE_CBC_SHA");
		}
	}

	// oid for your organization
	public static final String ORGANIZATIONAL_OID = "1.3.6.1.4.1.21367.2010.1.2.166";

	// uuid for document replacement, MUST exist as 'Approved' in the Registry,
	// Obtain
	// this information by running a query first (XDS Consumer) or submitting a
	// document
	// via Mesa11746 or Mesa12049 and use the uuid generated by that test
	public static final String REPLACE_UUID = "urn:uuid:99659732-d95c-3dd6-93f9-001b773dad57";

	// patient ID
	public static final CX PATIENT_ID;
	static {
		// normal testing
		/*
		 * PATIENT_ID = Hl7v2Factory.eINSTANCE.createCX();
		 * PATIENT_ID.setIdNumber("0859b9b8b1b64cd");
		 * PATIENT_ID.setAssigningAuthorityUniversalId
		 * ("1.3.6.1.4.1.21367.2005.3.7");
		 * PATIENT_ID.setAssigningAuthorityUniversalIdType("ISO");
		 */

		// 2010 Connectathon 5655294897af4b7^^^&1.19.6.24.109.42.1.3&ISO
		PATIENT_ID = Hl7v2Factory.eINSTANCE.createCX();
		PATIENT_ID.setIdNumber("c6002e5679534e11a"); // ("NA5156-OHT");
//		PATIENT_ID
//				.setAssigningAuthorityUniversalId("1.3.6.1.4.1.21367.2005.3.7");
//		PATIENT_ID.setAssigningAuthorityUniversalIdType("ISO");

		// NIST-XCA - d05ddc2efd5241f
		/*
		 * PATIENT_ID = Hl7v2Factory.eINSTANCE.createCX();
		 * PATIENT_ID.setIdNumber("d05ddc2efd5241f");
		 * PATIENT_ID.setAssigningAuthorityUniversalId
		 * ("1.3.6.1.4.1.21367.2005.3.7");
		 * PATIENT_ID.setAssigningAuthorityUniversalIdType("ISO");
		 */
	}
	// classCodes
	public static final CodedMetadataType CLASS_CODE;
	static {
		CLASS_CODE = null;
	}
	
	// type codes
		public static final CodedMetadataType TYPE_CODE;
		static {
			TYPE_CODE = null;
		}
		
	// practice setting codes
	public static final CodedMetadataType PRACTICE_SETTING_CODE;
	static {
		PRACTICE_SETTING_CODE = null;
	}

	// healthcare facility codes
	public static final CodedMetadataType HEALTHCARE_FACILITY_CODE;
	static {
		HEALTHCARE_FACILITY_CODE = MetadataFactory.eINSTANCE
				.createCodedMetadataType();
		HEALTHCARE_FACILITY_CODE.setCode("Children's Hospital");
		HEALTHCARE_FACILITY_CODE.setSchemeName("1.2.3.4");

	}

	// eventCodes
	public static final CodedMetadataType[] EVENT_CODES;
	static {
		CodedMetadataType event1 = MetadataFactory.eINSTANCE
				.createCodedMetadataType();
		event1.setCode("MPQ-eventcode-1");
		event1.setSchemeName("MPQ Testing");

		EVENT_CODES = new CodedMetadataType[] { event1 };
		// EVENT_CODES = null;
	}

	// additional event codes to add subject to AND/OR semantics. [i] is a
	// disjunctive clause to
	// add to the query
	public static final CodedMetadataType[][] ADDITIONAL_EVENT_CODE_CLAUSES;
	static {
		ADDITIONAL_EVENT_CODE_CLAUSES = new CodedMetadataType[1][1];
		ADDITIONAL_EVENT_CODE_CLAUSES[0][0] = MetadataFactory.eINSTANCE
				.createCodedMetadataType();
		ADDITIONAL_EVENT_CODE_CLAUSES[0][0].setCode("12345-6");
	}

	// authorPerson
	public static final XCN AUTHOR_PERSON;
	static {
		AUTHOR_PERSON = null;
	}

	// confidentiality codes (also used for GetFolderAndContents query)
	public static final CodedMetadataType[] CONFIDENTIALITY_CODES;
	static {
		CONFIDENTIALITY_CODES = new CodedMetadataType[1];
		CONFIDENTIALITY_CODES[0] = MetadataFactory.eINSTANCE
				.createCodedMetadataType();
		CONFIDENTIALITY_CODES[0].setCode("N");
	}

	// additional conf codes to add subject to AND/OR semantics. [i] is a
	// disjunctive clause to
	// add to the query (also used for GetFolderAndContents query)
	public static final List<CodedMetadataType> ADDITIONAL_CONFIDENTIALITY_CODE_CLAUSES;
	static {
		ADDITIONAL_CONFIDENTIALITY_CODE_CLAUSES = new ArrayList<CodedMetadataType>();
		CodedMetadataType newCodedMetadataType = MetadataFactory.eINSTANCE
				.createCodedMetadataType();
		newCodedMetadataType.setCode("R");
		ADDITIONAL_CONFIDENTIALITY_CODE_CLAUSES.add(newCodedMetadataType);
	}

	// format codes (also used for GetFolderAndContents query)
	public static final CodedMetadataType FORMAT_CODE;
	static {
		FORMAT_CODE = null;
	}
}
