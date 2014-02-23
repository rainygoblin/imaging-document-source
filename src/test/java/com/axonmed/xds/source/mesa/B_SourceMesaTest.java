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

import org.apache.axis2.client.Options;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openhealthtools.ihe.xds.source.B_Source;

/**
 * Base test class for Mesa XDS.b Source testing
 * 
 * @author <a href="mailto:seknoop@us.ibm.com">Sarah Knoop</a>
 * 
 */
public abstract class B_SourceMesaTest {
	// logger
	private static final Logger logger = Logger
			.getLogger(B_SourceMesaTest.class);

	protected B_Source source = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		logger.info("init the source");
		System.setProperty("javax.net.ssl.keyStore",
				TestConfiguration.KEY_STORE);
		System.setProperty("javax.net.ssl.keyStorePassword",
				TestConfiguration.KEY_STORE_PASS);
		System.setProperty("javax.net.ssl.trustStore",
				TestConfiguration.TRUST_STORE);
		System.setProperty("javax.net.ssl.trustStorePassword",
				TestConfiguration.TRUST_STORE_PASS);
		System.setProperty("javax.net.debug", "sslhandshake");
		Options options = new Options();
		options.setTimeOutInMilliSeconds(10000000);
		options.setProperty("enableMTOM", "true");
		source = new B_Source(
				new URI(
						"http://192.168.0.202:8080/services/xdsrepositoryb"));
//						"https://localhost:8443/simed-repository/services/xdsrepositoryb"));
//		source = new B_Source(
//				new URI(
//						"https://192.168.0.165:8443/simed-repository/services/xdsrepositoryb"));
		//fangzheng
//		source = new B_Source(
//				new URI(
//						"https://114.242.194.184:8021/axis2/services/xdsrepositoryb"));
//		 source = new B_Source(new
//		 URI("https://118.163.131.118:8021/axis2/services/xdsrepositoryb"));
	}

	@After
	public void tearDown() throws Exception {
	}

}
