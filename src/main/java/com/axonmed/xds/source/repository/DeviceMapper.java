package com.axonmed.xds.source.repository;

import java.util.List;
import java.util.Map;

import com.axonmed.xds.source.model.Device;
import com.axonmed.xds.source.model.ServerPartition;

public interface DeviceMapper {

	List<ServerPartition> loadAll();
	
	ServerPartition findByAETitle(String aeTitle);

	Device findUniqueByProps(Map<String, Object> parms);

	void updateAccessedTime(long deviceId);

	void persist(Device foundDevice);
}