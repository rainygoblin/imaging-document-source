package com.axonmed.xds.source.service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axonmed.xds.source.model.Device;
import com.axonmed.xds.source.model.ServerPartition;
import com.axonmed.xds.source.repository.DeviceMapper;

@Service
public class DeviceService {
	private static final Logger logger = LoggerFactory
			.getLogger(DeviceService.class);
	
	@Autowired
	private DeviceMapper deviceMapper;

	public Device lookupDevice(ServerPartition serverPartition, String callingAeTitle,
			String callingIpAddress) {
		if (serverPartition == null) {
			logger.error("The server partition parameter should not be null.");
			throw new IllegalArgumentException(
					"The server partition parameter should not be null.");
		}
		if (callingAeTitle == null){
			logger.error("The callingAeTitle parameter should not be null.");
			throw new IllegalArgumentException(
					"The callingAeTitle parameter should not be null.");
		}
		Device foundDevice = null;
		Map<String, Object> parms = new HashMap<String, Object>();
		parms.put("aeTitle", callingAeTitle);
		parms.put("serverPartitionId", serverPartition.getId());
		foundDevice = deviceMapper.findUniqueByProps(parms);
		if (foundDevice == null) {
			if (serverPartition.isAcceptAnyDevice()) {
				if (serverPartition.isAutoInsertDevice()) {
					foundDevice = new Device();
					foundDevice.setAeTitle(callingAeTitle);
					foundDevice.setComment(String.format("AE: %s",
							callingAeTitle));
					foundDevice.setIpAddress(callingIpAddress);
					foundDevice.setPort(serverPartition.getDefaultRemotePort());
					foundDevice.setServerPartition(serverPartition);
					foundDevice.setLastAccessedTime(new Date());
					deviceMapper.persist(foundDevice);
				}
			}
		}else{
			deviceMapper.updateAccessedTime(foundDevice.getId());
		}
		return foundDevice;
	}
}