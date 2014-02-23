package com.axonmed.xds.source.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axonmed.xds.source.bo.ServerFilesystemInfo;
import com.axonmed.xds.source.bo.StudyStorageLocation;
import com.axonmed.xds.source.exception.NoWritableFilesystemException;
import com.axonmed.xds.source.exception.StudyIsNearlineException;
import com.axonmed.xds.source.test.SourceSpringUnitTest;

public class FilesystemServiceTest extends SourceSpringUnitTest {

	@Autowired
	private FilesystemService filesystemService;
	
	@Test
	public void testSelectFilesystem(){
		ServerFilesystemInfo serverFilesystemInfo = filesystemService.selectFilesystem();
		assertNotNull(serverFilesystemInfo);
	}
	
	@Test
	public void testGetOrCreateWritableStudyStorageLocation(){
		ServerFilesystemInfo serverFilesystemInfo = filesystemService.selectFilesystem();
		assertNotNull(serverFilesystemInfo);
		try {
			StudyStorageLocation studyStorageLocation =filesystemService.getOrCreateWritableStudyStorageLocation(
					1, "1.2.840.113619.2.135.2025.1751230.4881.1246836380.741", "studyDate",
					"1.2.840.10008.1.2.2", serverFilesystemInfo);
			assertNotNull(studyStorageLocation);
		} catch (NoWritableFilesystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StudyIsNearlineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}