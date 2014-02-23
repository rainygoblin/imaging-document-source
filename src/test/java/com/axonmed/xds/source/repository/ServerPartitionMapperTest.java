package com.axonmed.xds.source.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axonmed.xds.source.enumeration.DuplicateSopPolicyEnum;
import com.axonmed.xds.source.model.ServerPartition;
import com.axonmed.xds.source.test.SourceSpringUnitTest;

public class ServerPartitionMapperTest extends SourceSpringUnitTest {

	@Autowired
	private ServerPartitionMapper serverPartitionMapper;

	@Test
	public void testLoadAll() {
		List<ServerPartition> serverPartitions = serverPartitionMapper
				.loadAll();
		assertNotNull(serverPartitions);
	}

	@Test
	public void testFindByAETitle() {
		ServerPartition serverPartition = serverPartitionMapper
				.findByAETitle("source");
		assertNotNull(serverPartition);
	}
	
	@Test
	public void testPersist(){
		ServerPartition serverPartition = new ServerPartition();
		serverPartition.setDuplicateSopPolicyEnum(DuplicateSopPolicyEnum.CompareDuplicates);
		serverPartition.setAeTitle("aeTitle");
		serverPartition.setPort(1000);
		serverPartitionMapper.persist(serverPartition);
	}
}