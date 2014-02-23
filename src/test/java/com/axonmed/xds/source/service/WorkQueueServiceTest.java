package com.axonmed.xds.source.service;


import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axonmed.xds.source.enumeration.WorkQueueTypeEnum;
import com.axonmed.xds.source.model.WorkQueue;
import com.axonmed.xds.source.test.SourceSpringUnitTest;

public class WorkQueueServiceTest extends SourceSpringUnitTest {

	@Autowired
	private WorkQueueService workQueueService;

	@Test
	public void testWorkQueueUidExists() {
		boolean result = workQueueService.workQueueUidExists(1,
				"seriesInstanceUid", "sopInstanceUid");
		assertTrue(result);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testInsertWorkQueue() {
		Map<String, Object> parms = new HashMap<String, Object>();
		parms.put("deviceId", 13);
		parms.put("scheduledTime", new Date());
		parms.put("seriesInstanceUid", "1.3.6.1.4.1.25403.37114227934438.2780.20100908034333.1");
		parms.put("serverPartitionId", 1);
		parms.put("sopInstanceUid", "1.3.6.1.4.1.25403.27114227934438.2780.20100908034333.1");
		parms.put("studyStorageId", 48);
		parms.put("workQueueTypeEnum", WorkQueueTypeEnum.StudyProcess);
		workQueueService.insertWorkQueue(parms);
		List<WorkQueue> locationList = (List<WorkQueue>) parms.get("curResult");
		assertNotNull(locationList);
		assertEquals(1, locationList.size());
		
		Map<String, Object> parms2 = new HashMap<String, Object>();
		parms2.put("deviceId", 13);
		parms2.put("scheduledTime", new Date());
		parms2.put("seriesInstanceUid", "1.3.6.1.4.1.25403.37114227934438.2780.20100908034333.2");
		parms2.put("serverPartitionId", 1);
		parms2.put("sopInstanceUid", "1.3.6.1.4.1.25403.27114227934438.2780.20100908034333.2");
		parms2.put("studyStorageId", 48);
		parms2.put("workQueueTypeEnum", WorkQueueTypeEnum.StudyProcess);
		workQueueService.insertWorkQueue(parms2);
		List<WorkQueue> location2List = (List<WorkQueue>) parms2.get("curResult");
		assertNotNull(location2List);
		assertEquals(1, location2List.size());
	}
}