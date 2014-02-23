package com.axonmed.xds.source.service;


import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axonmed.xds.source.model.Device;
import com.axonmed.xds.source.model.ServerPartition;
import com.axonmed.xds.source.test.SourceSpringUnitTest;

public class DeviceServiceTest extends SourceSpringUnitTest {

	@Autowired
	private DeviceService deviceService;

	@Test
	public void testLookupDevice() {

		ServerPartition newServerPartition = new ServerPartition();
		newServerPartition.setId(1);

		Device foundDevice = deviceService.lookupDevice(newServerPartition, "callingAeTitle",
				"callingIpAddress", 1000);
		assertNotNull(foundDevice);
	}
}