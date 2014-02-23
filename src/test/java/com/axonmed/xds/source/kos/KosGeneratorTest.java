package com.axonmed.xds.source.kos;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.dcm4che.data.Attributes;
import org.junit.Test;

public class KosGeneratorTest {

	@Test
	public void test() {
		final KosGenerator kosGenerator = new KosGenerator();
		try {
			List<String> dcmFiles = new ArrayList<String>();
			dcmFiles.add("src/test/resources/dcms/IM-0001-1001.dcm");
			DicomFiles.scan(dcmFiles,
					new DicomFiles.Callback() {

						@Override
						public boolean dicomFile(File f, Attributes fmi,
								long dsPos, Attributes ds) {
							return kosGenerator.addInstance(ds);
						}
					});
			ByteArrayInputStream bais = kosGenerator.writeKOS();
			assertNotNull(bais);
			FileOutputStream out = new FileOutputStream("kos.dcm");
			IOUtils.copy(bais,out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}