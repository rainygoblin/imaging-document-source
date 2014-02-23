package com.axonmed.xds.source.repository;


import java.util.List;

import com.axonmed.xds.source.model.DocumentRepository;

public interface DocumentRepositoryMapper {

	List<DocumentRepository> getActiveRepository();
}