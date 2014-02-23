package com.axonmed.xds.source.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axonmed.xds.source.model.Device;
import com.axonmed.xds.source.model.ServerPartition;
import com.axonmed.xds.source.test.SourceSpringUnitTest;

public class DeviceMapperTest extends SourceSpringUnitTest {

	@Autowired
	private DeviceMapper deviceMapper;

	@Test
	public void testPersist() {
		ServerPartition newServerPartition = new ServerPartition();
		newServerPartition.setId(1);
		
		Device newDevice = new Device();
		newDevice.setAeTitle("test");
		newDevice.setIpAddress("192.");
		newDevice.setPort(100);
		newDevice.setServerPartition(newServerPartition);
		deviceMapper.persist(newDevice);
		assertNotNull(newDevice);
	}
	
	@Test
	public void testUpdateAccessedTime(){

		ServerPartition newServerPartition = new ServerPartition();
		newServerPartition.setId(1);
		
		Device newDevice = new Device();
		newDevice.setAeTitle("test");
		newDevice.setIpAddress("192.");
		newDevice.setPort(100);
		newDevice.setServerPartition(newServerPartition);
		deviceMapper.persist(newDevice);
		assertNotNull(newDevice);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deviceMapper.updateAccessedTime(newDevice.getId());
	}

}