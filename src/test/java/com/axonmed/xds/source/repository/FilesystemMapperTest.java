package com.axonmed.xds.source.repository;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axonmed.xds.source.model.Filesystem;
import com.axonmed.xds.source.test.SourceSpringUnitTest;

public class FilesystemMapperTest extends SourceSpringUnitTest {

	@Autowired
	private FilesystemMapper filesystemMapper;

	@Test
	public void testLoadAll() {
		List<Filesystem> filesystems = filesystemMapper.loadAll();
		assertNotNull(filesystems);
	}
	
	
}