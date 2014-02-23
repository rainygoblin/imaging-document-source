package com.axonmed.xds.source.repository;

import java.util.List;
import java.util.Map;

import com.axonmed.xds.source.model.WorkQueueUid;

public interface WorkQueueUidMapper {

	WorkQueueUid findBySeriesInstanceUidAndSopInstanceUid(
			Map<String, Object> parms);

	List<WorkQueueUid> findWorkQueueUidByWorkQueueId(long workQueueId);

}