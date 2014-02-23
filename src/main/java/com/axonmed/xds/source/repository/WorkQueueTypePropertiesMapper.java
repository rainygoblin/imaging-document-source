package com.axonmed.xds.source.repository;

import com.axonmed.xds.source.enumeration.WorkQueueTypeEnum;
import com.axonmed.xds.source.model.WorkQueueTypeProperties;

public interface WorkQueueTypePropertiesMapper {

	WorkQueueTypeProperties getWorkQueueProperties(
			WorkQueueTypeEnum workQueueTypeEnum);

}