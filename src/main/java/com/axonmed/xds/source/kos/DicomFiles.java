package com.axonmed.xds.source.kos;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dcm4che.data.Attributes;
import org.dcm4che.data.Tag;
import org.dcm4che.data.UID;
import org.dcm4che.io.ContentHandlerAdapter;
import org.dcm4che.io.DicomInputStream;
import org.dcm4che.io.DicomInputStream.IncludeBulkData;
import org.dcm4che.util.SafeClose;

public abstract class DicomFiles {
	private static SAXParser saxParser;

	public interface Callback {
		boolean dicomFile(File f, Attributes fmi, long dsPos, Attributes ds)
				throws Exception;
	}

	public static void scan(List<String> fnames, Callback scb) {
		for (String fname : fnames)
			scan(new File(fname), scb);
	}

	private static void scan(File f, Callback scb) {
		if (f.isDirectory()) {
			for (String s : f.list())
				scan(new File(f, s), scb);
			return;
		}
		if (f.getName().endsWith(".xml")) {
			try {
				SAXParser p = saxParser;
				if (p == null)
					saxParser = p = SAXParserFactory.newInstance()
							.newSAXParser();
				Attributes ds = new Attributes();
				ContentHandlerAdapter ch = new ContentHandlerAdapter(ds);
				p.parse(f, ch);
				Attributes fmi = ch.getFileMetaInformation();
				if (fmi == null)
					fmi = ds.createFileMetaInformation(UID.ExplicitVRLittleEndian);
				boolean b = scb.dicomFile(f, fmi, -1, ds);
				System.out.print(b ? '.' : 'I');
			} catch (Exception e) {
				System.out.println();
				System.out.println("Failed to parse file " + f + ": "
						+ e.getMessage());
				e.printStackTrace(System.out);
			}
		} else {
			DicomInputStream in = null;
			try {
				in = new DicomInputStream(f);
				in.setIncludeBulkData(IncludeBulkData.NO);
				Attributes fmi = in.readFileMetaInformation();
				long dsPos = in.getPosition();
				Attributes ds = in.readDataset(-1, Tag.PixelData);
				if (fmi == null || !fmi.containsValue(Tag.TransactionUID)
						|| !fmi.containsValue(Tag.MediaStorageSOPClassUID)
						|| !fmi.containsValue(Tag.MediaStorageSOPInstanceUID))
					fmi = ds.createFileMetaInformation(in.getTransferSyntax());
				boolean b = scb.dicomFile(f, fmi, dsPos, ds);
				System.out.print(b ? '.' : 'I');
			} catch (Exception e) {
				System.out.println();
				System.out.println("Failed to scan file " + f + ": "
						+ e.getMessage());
				e.printStackTrace(System.out);
			} finally {
				SafeClose.close(in);
			}
		}
	}
}