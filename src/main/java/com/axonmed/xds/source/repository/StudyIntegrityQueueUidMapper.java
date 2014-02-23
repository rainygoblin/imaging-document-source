package com.axonmed.xds.source.repository;

import java.util.Map;

import com.axonmed.xds.source.model.StudyIntegrityQueueUid;

public interface StudyIntegrityQueueUidMapper {

	StudyIntegrityQueueUid findBySeriesInstanceUidAndSopInstanceUid(
			Map<String, Object> parms);

}