package com.axonmed.xds.source.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axonmed.xds.source.test.SourceSpringUnitTest;

public class RestoreQueueMapperTest  extends SourceSpringUnitTest {

	@Autowired
	private RestoreQueueMapper restoreQueueMapper;
	
	@Test
	public void testInsertRestoreQueue(){
		restoreQueueMapper.insertRestoreQueue(null);
	}
}