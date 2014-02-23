package com.axonmed.xds.source.repository;


import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axonmed.xds.source.bo.StudyStorageLocation;
import com.axonmed.xds.source.test.SourceSpringUnitTest;

public class StudyStorageMapperTest extends SourceSpringUnitTest {

	@Autowired
	private StudyStorageMapper studyStorageMapper;

	@Test
	public void testQueryStudyStorageLocation() {
		long serverPartitionId = 1;
		String studyInstanceUid = "test";
		Map<String, Object> studyStorageLocationQueryParameters = new HashMap<String, Object>();
		studyStorageLocationQueryParameters.put("studyStorageId",
				serverPartitionId);
		studyStorageLocationQueryParameters.put("serverPartitionId",
				serverPartitionId);
		studyStorageLocationQueryParameters.put("studyInstanceUid",
				studyInstanceUid);

		List<StudyStorageLocation> locationList = studyStorageMapper
				.queryStudyStorageLocation(studyStorageLocationQueryParameters);
		assertNotNull(locationList);
	}
}