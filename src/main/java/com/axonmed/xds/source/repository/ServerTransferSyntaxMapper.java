package com.axonmed.xds.source.repository;

import java.util.List;

import com.axonmed.xds.source.model.ServerTransferSyntax;

public interface ServerTransferSyntaxMapper {
	List<ServerTransferSyntax> loadAll();
}