package com.axonmed.xds.source.kos;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.dcm4che.data.Attributes;
import org.dcm4che.data.Sequence;
import org.dcm4che.data.Tag;
import org.dcm4che.data.UID;
import org.dcm4che.data.VR;
import org.dcm4che.io.DicomEncodingOptions;
import org.dcm4che.io.DicomOutputStream;
import org.dcm4che.util.SafeClose;
import org.dcm4che.util.StreamUtils;
import org.dcm4che.util.UIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KosGenerator {
	private static final Logger logger = LoggerFactory.getLogger(KosGenerator.class);

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

    private final Attributes attrs = new Attributes();
    private String uidSuffix;
    private boolean nofmi;
    private DicomEncodingOptions encOpts;
    private String tsuid;
    private String seriesNumber;
    private String instanceNumber;
    private String keyObjectDescription;
    private Attributes documentTitle;
    private Attributes documentTitleModifier;
    private Properties codes;

    private Attributes kos;
    private Sequence evidenceSeq;
    private Sequence contentSeq;
    

    public boolean addInstance(Attributes inst) {
    	logger.info("Add the instance");
        updateAttributes(inst, attrs, uidSuffix);
        String studyIUID = inst.getString(Tag.StudyInstanceUID);
        String seriesIUID = inst.getString(Tag.SeriesInstanceUID);
        String iuid = inst.getString(Tag.SOPInstanceUID);
        String cuid = inst.getString(Tag.SOPClassUID);
        if (studyIUID == null || seriesIUID == null || iuid == null || cuid == null)
            return false;
        if (kos == null)
            kos = createKOS(inst);
        refSOPSeq(studyIUID, seriesIUID).add(refSOP(cuid, iuid));
        contentSeq.add(contentItem(valueTypeOf(inst), refSOP(cuid, iuid)));
        return true;
    }

    public ByteArrayInputStream writeKOS() throws IOException {
    	logger.info("Write the kos to the inputstream");
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DicomOutputStream dos = new DicomOutputStream(
                new BufferedOutputStream(baos),
                nofmi ? UID.ImplicitVRLittleEndian
                      : UID.ExplicitVRLittleEndian);
        dos.setEncodingOptions(encOpts);
        try {
            dos.writeDataset(
                    nofmi ? null : kos.createFileMetaInformation(tsuid),
                    kos);
        } finally {
            dos.close();
        }
        return new ByteArrayInputStream(baos.toByteArray());
    }

    private boolean updateAttributes(Attributes data, Attributes attrs,
            String uidSuffix) {
        if (attrs.isEmpty() && uidSuffix == null)
            return false;
        if (uidSuffix != null ) {
            data.setString(Tag.StudyInstanceUID, VR.UI,
                    data.getString(Tag.StudyInstanceUID) + uidSuffix);
            data.setString(Tag.SeriesInstanceUID, VR.UI,
                    data.getString(Tag.SeriesInstanceUID) + uidSuffix);
            data.setString(Tag.SOPInstanceUID, VR.UI, 
                    data.getString(Tag.SOPInstanceUID) + uidSuffix);
        }
        data.update(attrs, null);
        return true;
    }

    private void configure() throws Exception {
        this.setCodes(loadProperties("resource:code.properties",
                null));
        this.setDocumentTitle(toCodeItem("Axonmed KOS Document"));
        this.setKeyObjectDescription("Just for Share Images");
        this.setSeriesNumber("999");
        this.setInstanceNumber("1");
        this.setNoFileMetaInformation(true);
        this.setTransferSyntax(UID.ExplicitVRLittleEndian);
        this.setEncodingOptions( DicomEncodingOptions.DEFAULT);
//        CLIUtils.addAttributes(main.attrs, cl.getOptionValues("s"));
        this.setUIDSuffix("1.2.3.6");
    }
    private Properties loadProperties(String url, Properties p)
            throws IOException {
        if (p == null)
            p = new Properties();
        InputStream in = StreamUtils.openFileOrURL(url);
        try {
            p.load(in);
        } finally {
            SafeClose.close(in);
        }
        return p;
    }
    private Sequence refSOPSeq(String studyIUID, String seriesIUID) {
        Attributes refStudy = getOrAddItem(evidenceSeq, Tag.StudyInstanceUID, studyIUID);
        Sequence refSeriesSeq = refStudy.ensureSequence(Tag.ReferencedSeriesSequence, 10);
        Attributes refSeries = getOrAddItem(refSeriesSeq,Tag.SeriesInstanceUID, seriesIUID);
        return refSeries.ensureSequence(Tag.ReferencedSOPSequence, 100);
    }

    private Attributes getOrAddItem(Sequence seq, int tag, String value) {
        for (Attributes item : seq)
            if (value.equals(item.getString(tag)))
                return item;
        
        Attributes item = new Attributes(2);
        item.setString(tag, VR.UI, value);
        seq.add(item);
        return item;
    }

    private String valueTypeOf(Attributes inst) {
        return inst.contains(Tag.PhotometricInterpretation) ? "IMAGE"
                      : inst.contains(Tag.WaveformSequence) ? "WAVEFORM"
                                                            : "COMPOSITE";
    }

    private Attributes refSOP(String cuid, String iuid) {
        Attributes item = new Attributes(2);
        item.setString(Tag.ReferencedSOPClassUID, VR.UI, cuid);
        item.setString(Tag.ReferencedSOPInstanceUID, VR.UI, iuid);
        return item;
    }

    private Attributes createKOS(Attributes inst) {
        Attributes attrs = new Attributes(inst, PATIENT_AND_STUDY_ATTRS);
        attrs.setString(Tag.SOPClassUID, VR.UI, UID.KeyObjectSelectionDocumentStorage);
        attrs.setString(Tag.SOPInstanceUID, VR.UI, UIDUtils.createUID());
        attrs.setDate(Tag.ContentDateAndTime, new Date());
        attrs.setString(Tag.Modality, VR.CS, "KO");
        attrs.setNull(Tag.ReferencedPerformedProcedureStepSequence, VR.SQ);
        attrs.setString(Tag.SeriesInstanceUID, VR.UI, UIDUtils.createUID());
        attrs.setString(Tag.SeriesNumber, VR.IS, seriesNumber);
        attrs.setString(Tag.InstanceNumber, VR.IS, instanceNumber);
        attrs.setString(Tag.ValueType, VR.CS, "CONTAINER");
        attrs.setString(Tag.ContinuityOfContent, VR.CS, "SEPARATE");
        attrs.newSequence(Tag.ConceptNameCodeSequence, 1).add(documentTitle);
        evidenceSeq = attrs.newSequence(Tag.CurrentRequestedProcedureEvidenceSequence, 1);
        attrs.newSequence(Tag.ContentTemplateSequence, 1).add(templateIdentifier());
        contentSeq = attrs.newSequence(Tag.ContentSequence, 1);
        if (documentTitleModifier != null)
            contentSeq.add(documentTitleModifier());
        if (keyObjectDescription != null)
            contentSeq.add(keyObjectDescription());
        return attrs;
    }

    private Attributes templateIdentifier() {
        Attributes attrs = new Attributes(2);
        attrs.setString(Tag.MappingResource, VR.CS, "DCMR");
        attrs.setString(Tag.TemplateIdentifier, VR.CS, "2010");
        return attrs ;
    }

    private Attributes documentTitleModifier() {
        Attributes item = new Attributes(4);
        item.setString(Tag.RelationshipType, VR.CS, "HAS CONCEPT MOD");
        item.setString(Tag.ValueType, VR.CS, "CODE");
        item.newSequence(Tag.ConceptNameCodeSequence, 1).add(toCodeItem("DCM-113011"));
        item.newSequence(Tag.ConceptCodeSequence, 1).add(documentTitleModifier);
        return item;
    }

    private Attributes keyObjectDescription() {
        Attributes item = new Attributes(4);
        item.setString(Tag.RelationshipType, VR.CS, "CONTAINS");
        item.setString(Tag.ValueType, VR.CS, "TEXT");
        item.newSequence(Tag.ConceptNameCodeSequence, 1).add(toCodeItem("DCM-113012"));
        item.setString(Tag.TextValue, VR.UT, keyObjectDescription);
        return item;
    }
    
    private Attributes toCodeItem(String codeValue) {
        if (codes == null)
            throw new IllegalStateException("codes not initialized");
        String codeMeaning = codes.getProperty(codeValue);
        if (codeMeaning == null)
            throw new IllegalArgumentException("undefined code value: "
                        + codeValue);
        int endDesignator = codeValue.indexOf('-');
        Attributes attrs = new Attributes(3);
        attrs.setString(Tag.CodeValue, VR.SH,
                endDesignator >= 0
                    ? codeValue.substring(endDesignator + 1)
                    : codeValue);
        attrs.setString(Tag.CodingSchemeDesignator, VR.SH,
                endDesignator >= 0
                    ? codeValue.substring(0, endDesignator)
                    : "DCM");
        attrs.setString(Tag.CodeMeaning, VR.LO, codeMeaning);
        return attrs;
    }
    private Attributes contentItem(String valueType, Attributes refSOP) {
        Attributes item = new Attributes(3);
        item.setString(Tag.RelationshipType, VR.CS, "CONTAINS");
        item.setString(Tag.ValueType, VR.CS, valueType);
        item.newSequence(Tag.ReferencedSOPSequence, 1).add(refSOP);
        return item;
    }

    public final void setUIDSuffix(String uidSuffix) {
        this.uidSuffix = uidSuffix;
    }

    public void setNoFileMetaInformation(boolean nofmi) {
        this.nofmi = nofmi;
    }

    public final void setEncodingOptions(DicomEncodingOptions encOpts) {
        this.encOpts = encOpts;
    }

    public final void setTransferSyntax(String tsuid) {
        this.tsuid = tsuid;
    }

    public final void setSeriesNumber(String seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public final void setInstanceNumber(String instanceNumber) {
        this.instanceNumber = instanceNumber;
    }

    public final void setKeyObjectDescription(String keyObjectDescription) {
        this.keyObjectDescription = keyObjectDescription;
    }

    public final void setCodes(Properties codes) {
        this.codes = codes;
    }

    public final void setDocumentTitle(Attributes codeItem) {
        this.documentTitle = codeItem;
    }

    public final void setDocumentTitleModifier(Attributes codeItem) {
        this.documentTitleModifier = codeItem;
    }

}