package com.axonmed.xds.source.repository;

import java.util.Map;

import com.axonmed.xds.source.model.WorkQueue;

public interface WorkQueueMapper {

	WorkQueue findById(long workQueueId);

	void insertWorkQueue(Map<String, Object> parms);

}
