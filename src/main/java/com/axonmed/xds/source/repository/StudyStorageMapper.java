package com.axonmed.xds.source.repository;


import java.util.Map;

import com.axonmed.xds.source.model.StudyStorage;

public interface StudyStorageMapper {

	void insertStudyStorage(
			Map<String, Object> insertStudyStorageParameters);

	void queryStudyStorageLocation(
			Map<String, Object> studyStorageLocationQueryParameters);

	StudyStorage findById(long studyStorageId);

	StudyStorage findByStudyInstanceUidAndServerPartitionId(
			Map<String, Object> parms);

}