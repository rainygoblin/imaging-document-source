package com.axonmed.xds.source.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axonmed.xds.source.model.StudyIntegrityQueue;
import com.axonmed.xds.source.model.StudyIntegrityQueueUid;
import com.axonmed.xds.source.repository.StudyIntegrityQueueUidMapper;

@Service
public class StudyIntegrityQueueService {

	@Autowired
	private StudyIntegrityQueueUidMapper studyIntegrityQueueUidMapper;

	@Autowired
	private StudyIntegrityQueueMapper studyIntegrityQueueMapper;

	public boolean studyIntegrityUidExists(long studyStorageId,
			String seriesInstanceUid, String sopInstanceUid) {
		boolean result = false;
		Map<String, Object> parms = new HashMap<String, Object>();
		parms.put("seriesInstanceUid", seriesInstanceUid);
		parms.put("sopInstanceUid", sopInstanceUid);
		StudyIntegrityQueueUid studyIntegrityQueueUid = studyIntegrityQueueUidMapper
				.findSeriesInstanceUidAndSopInstanceUid(parms);
		if (studyIntegrityQueueUid != null) {
			StudyIntegrityQueue studyIntegrityQueue = studyIntegrityQueueMapper
					.findById(studyIntegrityQueueUid
							.getStudyIntegrityQueueId());
			if (studyIntegrityQueue != null) {
				if (studyIntegrityQueue.getStudyStorageId() == 
						studyStorageId)) {
					result = true;
				}
			}
		}
		return result;
	}
}