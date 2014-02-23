package com.axonmed.xds.source.callback;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.dcm4che.data.Attributes;
import org.dcm4che.data.Tag;
import org.dcm4che.data.UID;
import org.dcm4che.io.DicomOutputStream;
import org.dcm4che.net.PDVInputStream;
import org.dcm4che.net.Status;
import org.dcm4che.net.service.DicomServiceException;
import org.dcm4che.util.SafeClose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DicomStreamWriteCallback implements StreamWriteCallback {
	private static final Logger logger = LoggerFactory
			.getLogger(DicomStreamWriteCallback.class);
	private static final int[] PATIENT_AND_STUDY_ATTRS = {
        Tag.SpecificCharacterSet,
        Tag.StudyDate,
        Tag.StudyTime,
        Tag.AccessionNumber,
        Tag.IssuerOfAccessionNumberSequence,
        Tag.ReferringPhysicianName,
        Tag.PatientName,
        Tag.PatientID,
        Tag.IssuerOfPatientID,
        Tag.PatientBirthDate,
        Tag.PatientSex,
        Tag.StudyInstanceUID,
        Tag.StudyID 
    };

	private Attributes fileMetaInfoObject;
	private Attributes dicomHeader;
	private DicomOutputStream dicomOutputStream;

	public Attributes getDicomHeader() {
		return dicomHeader;
	}

	public void setFileMetaInfoObject(Attributes fileMetaInfoObject) {
		this.fileMetaInfoObject = fileMetaInfoObject;
	}

	@Override
	public void doWrite(InputStream is, OutputStream os) throws DicomServiceException {
		if(os == null){
			logger.error("The output stream should not be null.");
			throw new DicomServiceException(Status.ProcessingFailure,
					"The output stream should not be null.");
		}
		if(is == null){
			logger.error("The input stream should not be null.");
			throw new DicomServiceException(Status.ProcessingFailure,
					"The input stream should not be null.");
		}
		String inputTransferSyntaxUid = UID.ImplicitVRLittleEndian;
		if (this.fileMetaInfoObject != null) {
			inputTransferSyntaxUid = this.fileMetaInfoObject.getString(
					Tag.TransferSyntaxUID, UID.ImplicitVRLittleEndian);
		}
		try {
			dicomOutputStream = new DicomOutputStream(os,inputTransferSyntaxUid);
			PDVInputStream dataStream = (PDVInputStream)is;
			Attributes inputDicomDataSet = dataStream.readDataset(inputTransferSyntaxUid);
//			dicomOutputStream.writeFileMetaInformation(fileMetaInfoObject);
			dicomOutputStream.writeDataset(fileMetaInfoObject, inputDicomDataSet);
//			dataStream.copyTo(dicomOutputStream);
			

			dicomHeader = new Attributes(inputDicomDataSet, PATIENT_AND_STUDY_ATTRS);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
            SafeClose.close(os);
            SafeClose.close(is);
		}
	}

}
