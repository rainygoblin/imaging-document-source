package com.axonmed.xds.source.repository;

import java.util.List;

import com.axonmed.xds.source.model.ServerPartition;

public interface ServerPartitionMapper {

	List<ServerPartition> loadAll();

	ServerPartition findById(long serverPartitionId);
}