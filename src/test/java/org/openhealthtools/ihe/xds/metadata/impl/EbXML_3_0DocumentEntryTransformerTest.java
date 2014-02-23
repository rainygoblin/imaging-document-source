package org.openhealthtools.ihe.xds.metadata.impl;


import static org.junit.Assert.*;

import org.junit.Test;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.transform.EbXML_3_0DocumentEntryTransformer;
import org.openhealthtools.ihe.xds.metadata.transform.MetadataTransformationException;

public class EbXML_3_0DocumentEntryTransformerTest {

	@Test
	public void testTransform() {
		DocumentEntryType studyDocEntry = new StudyDocumentEntryTypeImpl();
		studyDocEntry.setAvailabilityStatus(AvailabilityStatusType.APPROVED_LITERAL);
		EbXML_3_0DocumentEntryTransformer transformer = new EbXML_3_0DocumentEntryTransformer();
		try {
			transformer.transform(studyDocEntry);
			assertNotNull(transformer.getExtrinsicObject());
		} catch (MetadataTransformationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}