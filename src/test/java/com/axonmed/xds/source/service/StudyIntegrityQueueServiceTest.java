package com.axonmed.xds.source.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axonmed.xds.source.test.SourceSpringUnitTest;

public class StudyIntegrityQueueServiceTest extends SourceSpringUnitTest {

	@Autowired
	private StudyIntegrityQueueService studyIntegrityQueueService;

	@Test
	public void testStudyIntegrityUidExists() {
		studyIntegrityQueueService.studyIntegrityUidExists(1,
				"seriesInstanceUid", "sopInstanceUid");
	}
}