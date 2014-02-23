package com.axonmed.xds.source.repository;

import java.util.List;

import com.axonmed.xds.source.model.Filesystem;

public interface FilesystemMapper {

	List<Filesystem> loadAll();

}
