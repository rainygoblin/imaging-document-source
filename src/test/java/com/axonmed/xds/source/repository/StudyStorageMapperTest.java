package com.axonmed.xds.source.repository;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axonmed.xds.source.bo.QueueStudyStateEnum;
import com.axonmed.xds.source.bo.StudyStatusEnum;
import com.axonmed.xds.source.bo.StudyStorageLocation;
import com.axonmed.xds.source.test.SourceSpringUnitTest;

public class StudyStorageMapperTest extends SourceSpringUnitTest {

	@Autowired
	private StudyStorageMapper studyStorageMapper;

	@SuppressWarnings("unchecked")
	@Test
	public void testQueryStudyStorageLocation() {
		long serverPartitionId = 1;
		String studyInstanceUid = "1.23.987.21397";
		Map<String, Object> studyStorageLocationQueryParameters = new HashMap<String, Object>();

//		studyStorageLocationQueryParameters.put("studyStorageId",
//				(long)17);
		studyStorageLocationQueryParameters.put("studyInstanceUid",
				studyInstanceUid);
		studyStorageLocationQueryParameters.put("serverPartitionId",
				serverPartitionId);

		studyStorageMapper
				.queryStudyStorageLocation(studyStorageLocationQueryParameters);
		List<StudyStorageLocation> locationList = (List<StudyStorageLocation>) studyStorageLocationQueryParameters
				.get("curResult");
		assertNotNull(locationList);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testInsertStudyStorage() {
		Map<String, Object> insertStudyStorageParameters = new HashMap<String, Object>();

		insertStudyStorageParameters
				.put("serverPartitionId", (long)1);
		insertStudyStorageParameters.put("studyInstanceUid", "studyInstanceUid");
		insertStudyStorageParameters.put("folder", "folder");
		insertStudyStorageParameters.put("fileSystemId", (long)1);
		insertStudyStorageParameters.put("transferSyntaxUid", "1.2.840.10008.1.2.2");
		insertStudyStorageParameters.put("studyStatusEnum", StudyStatusEnum.Online.getLookup());
		insertStudyStorageParameters.put("queueStudyStateEnum", QueueStudyStateEnum.ArchiveScheduled.getLookup());

		studyStorageMapper.insertStudyStorage(insertStudyStorageParameters);
		List<StudyStorageLocation> locationList = (List<StudyStorageLocation>) insertStudyStorageParameters
				.get("curResult");
		assertNotNull(locationList);
	}
}