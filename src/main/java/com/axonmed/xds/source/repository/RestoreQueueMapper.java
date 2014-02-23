package com.axonmed.xds.source.repository;

import java.util.Map;

import com.axonmed.xds.source.model.RestoreQueue;

public interface RestoreQueueMapper {

	RestoreQueue insertRestoreQueue(
			Map<String, Object> insertRestoreQueueParameters);

}