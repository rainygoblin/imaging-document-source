package com.axonmed.xds.source.repository;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axonmed.xds.source.model.DocumentRepository;
import com.axonmed.xds.source.test.SourceSpringUnitTest;

public class DocumentRepositoryMapperTest extends SourceSpringUnitTest {

	@Autowired
	private DocumentRepositoryMapper documentRepositoryMapper;

	@Test
	public void testGetActiveRepository() {
		List<DocumentRepository> documentRepositories = documentRepositoryMapper
				.getActiveRepository();
		assertNotNull(documentRepositories);
	}

}