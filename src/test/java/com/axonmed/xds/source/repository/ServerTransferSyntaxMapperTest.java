package com.axonmed.xds.source.repository;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axonmed.xds.source.model.ServerTransferSyntax;
import com.axonmed.xds.source.test.SourceSpringUnitTest;

public class ServerTransferSyntaxMapperTest extends SourceSpringUnitTest {

	@Autowired
	private ServerTransferSyntaxMapper serverTransferSyntaxMapper;

	@Test
	public void testLoadAll() {
		List<ServerTransferSyntax> serverTransferSyntaxs = serverTransferSyntaxMapper.loadAll();
		assertNotNull(serverTransferSyntaxs);
	}
	
	
}