package com.axonmed.xds.source.callback;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.dcm4che.net.service.DicomServiceException;
import org.dcm4che.util.SafeClose;

public abstract interface StreamWriteCallback {

	public static final StreamWriteCallback DEFAULT_STREAM_WRITE_CALLBACK = new StreamWriteCallback(){
		public void doWrite(InputStream is, OutputStream os){
			try {
				IOUtils.copy(is,os);
			} catch (IOException e) {
				throw new RuntimeException("Write error: ", e);
			}finally{
	            SafeClose.close(os);
	            SafeClose.close(is);
			}
		}
	};
	
	public abstract void doWrite(InputStream is, OutputStream os) throws DicomServiceException;
}