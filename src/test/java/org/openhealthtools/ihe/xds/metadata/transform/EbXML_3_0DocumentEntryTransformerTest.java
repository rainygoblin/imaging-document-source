package org.openhealthtools.ihe.xds.metadata.transform;

import org.junit.Test;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.impl.StudyDocumentEntryTypeImpl;

public class EbXML_3_0DocumentEntryTransformerTest {

	@Test
	public void testTransform() {
		DocumentEntryType studyDocEntry = new StudyDocumentEntryTypeImpl();
		EbXML_3_0DocumentEntryTransformer transformer = new EbXML_3_0DocumentEntryTransformer();
//		transformer.transform(docEntry);
	}

}