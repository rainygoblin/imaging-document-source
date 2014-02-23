/**
 * <copyright>
 * </copyright>
 *
 * $Id: DocumentEntryTypeImpl.java,v 1.6 2007/07/21 00:19:59 sknoop Exp $
 */
package org.openhealthtools.ihe.xds.metadata.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;


import org.openhealthtools.ihe.common.hl7v2.CX;
import org.openhealthtools.ihe.common.hl7v2.SourcePatientInfoType;
import org.openhealthtools.ihe.common.hl7v2.XCN;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.ExtensionType;
import org.openhealthtools.ihe.xds.metadata.InternationalStringType;
import org.openhealthtools.ihe.xds.metadata.MetadataPackage;
import org.openhealthtools.ihe.xds.metadata.ParentDocumentType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Entry Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getAuthors <em>Authors</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getAvailabilityStatus <em>Availability Status</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getClassCode <em>Class Code</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getConfidentialityCode <em>Confidentiality Code</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getEntryUUID <em>Entry UUID</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getEventCode <em>Event Code</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getFormatCode <em>Format Code</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getHash <em>Hash</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getHealthCareFacilityTypeCode <em>Health Care Facility Type Code</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getLanguageCode <em>Language Code</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getLegalAuthenticator <em>Legal Authenticator</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getMimeType <em>Mime Type</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getParentDocument <em>Parent Document</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getPatientId <em>Patient Id</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getPracticeSettingCode <em>Practice Setting Code</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getRepositoryUniqueId <em>Repository Unique Id</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getServiceStartTime <em>Service Start Time</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getServiceStopTime <em>Service Stop Time</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getSourcePatientId <em>Source Patient Id</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getSourcePatientInfo <em>Source Patient Info</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getTypeCode <em>Type Code</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getUniqueId <em>Unique Id</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.DocumentEntryTypeImpl#isExisting <em>Existing</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentEntryTypeImpl extends EObjectImpl implements DocumentEntryType {
	/**
	 * The cached value of the '{@link #getAuthors() <em>Authors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthors()
	 * @generated
	 * @ordered
	 */
	protected EList authors;

	/**
	 * The default value of the '{@link #getAvailabilityStatus() <em>Availability Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailabilityStatus()
	 * @generated
	 * @ordered
	 */
	protected static final AvailabilityStatusType AVAILABILITY_STATUS_EDEFAULT = AvailabilityStatusType.SUBMITTED_LITERAL;

	/**
	 * The cached value of the '{@link #getAvailabilityStatus() <em>Availability Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailabilityStatus()
	 * @generated
	 * @ordered
	 */
	protected AvailabilityStatusType availabilityStatus = AVAILABILITY_STATUS_EDEFAULT;

	/**
	 * This is true if the Availability Status attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean availabilityStatusESet;

	/**
	 * The cached value of the '{@link #getClassCode() <em>Class Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassCode()
	 * @generated
	 * @ordered
	 */
	protected CodedMetadataType classCode;

	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected InternationalStringType comments;

	/**
	 * The cached value of the '{@link #getConfidentialityCode() <em>Confidentiality Code</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidentialityCode()
	 * @generated
	 * @ordered
	 */
	protected EList confidentialityCode;

	/**
	 * The default value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected String creationTime = CREATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEntryUUID() <em>Entry UUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryUUID()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTRY_UUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEntryUUID() <em>Entry UUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryUUID()
	 * @generated
	 * @ordered
	 */
	protected String entryUUID = ENTRY_UUID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEventCode() <em>Event Code</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventCode()
	 * @generated
	 * @ordered
	 */
	protected EList eventCode;

	/**
	 * The cached value of the '{@link #getExtension() <em>Extension</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected EList extension;

	/**
	 * The cached value of the '{@link #getFormatCode() <em>Format Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormatCode()
	 * @generated
	 * @ordered
	 */
	protected CodedMetadataType formatCode;

	/**
	 * The default value of the '{@link #getHash() <em>Hash</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHash()
	 * @generated
	 * @ordered
	 */
	protected static final String HASH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHash() <em>Hash</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHash()
	 * @generated
	 * @ordered
	 */
	protected String hash = HASH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHealthCareFacilityTypeCode() <em>Health Care Facility Type Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHealthCareFacilityTypeCode()
	 * @generated
	 * @ordered
	 */
	protected CodedMetadataType healthCareFacilityTypeCode;

	/**
	 * The default value of the '{@link #getLanguageCode() <em>Language Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageCode()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguageCode() <em>Language Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageCode()
	 * @generated
	 * @ordered
	 */
	protected String languageCode = LANGUAGE_CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLegalAuthenticator() <em>Legal Authenticator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLegalAuthenticator()
	 * @generated
	 * @ordered
	 */
	protected XCN legalAuthenticator;

	/**
	 * The default value of the '{@link #getMimeType() <em>Mime Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMimeType()
	 * @generated
	 * @ordered
	 */
	protected static final String MIME_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMimeType() <em>Mime Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMimeType()
	 * @generated
	 * @ordered
	 */
	protected String mimeType = MIME_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParentDocument() <em>Parent Document</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentDocument()
	 * @generated
	 * @ordered
	 */
	protected ParentDocumentType parentDocument;

	/**
	 * The cached value of the '{@link #getPatientId() <em>Patient Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatientId()
	 * @generated
	 * @ordered
	 */
	protected CX patientId;

	/**
	 * The cached value of the '{@link #getPracticeSettingCode() <em>Practice Setting Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPracticeSettingCode()
	 * @generated
	 * @ordered
	 */
	protected CodedMetadataType practiceSettingCode;

	/**
	 * The default value of the '{@link #getRepositoryUniqueId() <em>Repository Unique Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryUniqueId()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_UNIQUE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositoryUniqueId() <em>Repository Unique Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryUniqueId()
	 * @generated
	 * @ordered
	 */
	protected String repositoryUniqueId = REPOSITORY_UNIQUE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceStartTime() <em>Service Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceStartTime()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_START_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceStartTime() <em>Service Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceStartTime()
	 * @generated
	 * @ordered
	 */
	protected String serviceStartTime = SERVICE_START_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceStopTime() <em>Service Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceStopTime()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_STOP_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceStopTime() <em>Service Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceStopTime()
	 * @generated
	 * @ordered
	 */
	protected String serviceStopTime = SERVICE_STOP_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourcePatientId() <em>Source Patient Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePatientId()
	 * @generated
	 * @ordered
	 */
	protected CX sourcePatientId;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final String SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected String size = SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourcePatientInfo() <em>Source Patient Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePatientInfo()
	 * @generated
	 * @ordered
	 */
	protected SourcePatientInfoType sourcePatientInfo;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected InternationalStringType title;

	/**
	 * The cached value of the '{@link #getTypeCode() <em>Type Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeCode()
	 * @generated
	 * @ordered
	 */
	protected CodedMetadataType typeCode;

	/**
	 * The default value of the '{@link #getUniqueId() <em>Unique Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniqueId()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIQUE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUniqueId() <em>Unique Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniqueId()
	 * @generated
	 * @ordered
	 */
	protected String uniqueId = UNIQUE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The default value of the '{@link #isExisting() <em>Existing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExisting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXISTING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExisting() <em>Existing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExisting()
	 * @generated
	 * @ordered
	 */
	protected boolean existing = EXISTING_EDEFAULT;

	/**
	 * This is true if the Existing attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean existingESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentEntryTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MetadataPackage.Literals.DOCUMENT_ENTRY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAuthors() {
		if (authors == null) {
			authors = new EObjectContainmentEList(AuthorType.class, this, MetadataPackage.DOCUMENT_ENTRY_TYPE__AUTHORS);
		}
		return authors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AvailabilityStatusType getAvailabilityStatus() {
		return availabilityStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvailabilityStatus(AvailabilityStatusType newAvailabilityStatus) {
		AvailabilityStatusType oldAvailabilityStatus = availabilityStatus;
		availabilityStatus = newAvailabilityStatus == null ? AVAILABILITY_STATUS_EDEFAULT : newAvailabilityStatus;
		boolean oldAvailabilityStatusESet = availabilityStatusESet;
		availabilityStatusESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__AVAILABILITY_STATUS, oldAvailabilityStatus, availabilityStatus, !oldAvailabilityStatusESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAvailabilityStatus() {
		AvailabilityStatusType oldAvailabilityStatus = availabilityStatus;
		boolean oldAvailabilityStatusESet = availabilityStatusESet;
		availabilityStatus = AVAILABILITY_STATUS_EDEFAULT;
		availabilityStatusESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetadataPackage.DOCUMENT_ENTRY_TYPE__AVAILABILITY_STATUS, oldAvailabilityStatus, AVAILABILITY_STATUS_EDEFAULT, oldAvailabilityStatusESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAvailabilityStatus() {
		return availabilityStatusESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodedMetadataType getClassCode() {
		return classCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClassCode(CodedMetadataType newClassCode, NotificationChain msgs) {
		CodedMetadataType oldClassCode = classCode;
		classCode = newClassCode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__CLASS_CODE, oldClassCode, newClassCode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassCode(CodedMetadataType newClassCode) {
		if (newClassCode != classCode) {
			NotificationChain msgs = null;
			if (classCode != null)
				msgs = ((InternalEObject)classCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__CLASS_CODE, null, msgs);
			if (newClassCode != null)
				msgs = ((InternalEObject)newClassCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__CLASS_CODE, null, msgs);
			msgs = basicSetClassCode(newClassCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__CLASS_CODE, newClassCode, newClassCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternationalStringType getComments() {
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComments(InternationalStringType newComments, NotificationChain msgs) {
		InternationalStringType oldComments = comments;
		comments = newComments;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__COMMENTS, oldComments, newComments);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComments(InternationalStringType newComments) {
		if (newComments != comments) {
			NotificationChain msgs = null;
			if (comments != null)
				msgs = ((InternalEObject)comments).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__COMMENTS, null, msgs);
			if (newComments != null)
				msgs = ((InternalEObject)newComments).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__COMMENTS, null, msgs);
			msgs = basicSetComments(newComments, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__COMMENTS, newComments, newComments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConfidentialityCode() {
		if (confidentialityCode == null) {
			confidentialityCode = new EObjectContainmentEList(CodedMetadataType.class, this, MetadataPackage.DOCUMENT_ENTRY_TYPE__CONFIDENTIALITY_CODE);
		}
		return confidentialityCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreationTime() {
		return creationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationTime(String newCreationTime) {
		String oldCreationTime = creationTime;
		creationTime = newCreationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__CREATION_TIME, oldCreationTime, creationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntryUUID() {
		return entryUUID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryUUID(String newEntryUUID) {
		String oldEntryUUID = entryUUID;
		entryUUID = newEntryUUID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__ENTRY_UUID, oldEntryUUID, entryUUID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEventCode() {
		if (eventCode == null) {
			eventCode = new EObjectContainmentEList(CodedMetadataType.class, this, MetadataPackage.DOCUMENT_ENTRY_TYPE__EVENT_CODE);
		}
		return eventCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getExtension() {
		if (extension == null) {
			extension = new EObjectContainmentEList(ExtensionType.class, this, MetadataPackage.DOCUMENT_ENTRY_TYPE__EXTENSION);
		}
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodedMetadataType getFormatCode() {
		return formatCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFormatCode(CodedMetadataType newFormatCode, NotificationChain msgs) {
		CodedMetadataType oldFormatCode = formatCode;
		formatCode = newFormatCode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__FORMAT_CODE, oldFormatCode, newFormatCode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormatCode(CodedMetadataType newFormatCode) {
		if (newFormatCode != formatCode) {
			NotificationChain msgs = null;
			if (formatCode != null)
				msgs = ((InternalEObject)formatCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__FORMAT_CODE, null, msgs);
			if (newFormatCode != null)
				msgs = ((InternalEObject)newFormatCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__FORMAT_CODE, null, msgs);
			msgs = basicSetFormatCode(newFormatCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__FORMAT_CODE, newFormatCode, newFormatCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHash(String newHash) {
		String oldHash = hash;
		hash = newHash;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH, oldHash, hash));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodedMetadataType getHealthCareFacilityTypeCode() {
		return healthCareFacilityTypeCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHealthCareFacilityTypeCode(CodedMetadataType newHealthCareFacilityTypeCode, NotificationChain msgs) {
		CodedMetadataType oldHealthCareFacilityTypeCode = healthCareFacilityTypeCode;
		healthCareFacilityTypeCode = newHealthCareFacilityTypeCode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__HEALTH_CARE_FACILITY_TYPE_CODE, oldHealthCareFacilityTypeCode, newHealthCareFacilityTypeCode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHealthCareFacilityTypeCode(CodedMetadataType newHealthCareFacilityTypeCode) {
		if (newHealthCareFacilityTypeCode != healthCareFacilityTypeCode) {
			NotificationChain msgs = null;
			if (healthCareFacilityTypeCode != null)
				msgs = ((InternalEObject)healthCareFacilityTypeCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__HEALTH_CARE_FACILITY_TYPE_CODE, null, msgs);
			if (newHealthCareFacilityTypeCode != null)
				msgs = ((InternalEObject)newHealthCareFacilityTypeCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__HEALTH_CARE_FACILITY_TYPE_CODE, null, msgs);
			msgs = basicSetHealthCareFacilityTypeCode(newHealthCareFacilityTypeCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__HEALTH_CARE_FACILITY_TYPE_CODE, newHealthCareFacilityTypeCode, newHealthCareFacilityTypeCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguageCode(String newLanguageCode) {
		String oldLanguageCode = languageCode;
		languageCode = newLanguageCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__LANGUAGE_CODE, oldLanguageCode, languageCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCN getLegalAuthenticator() {
		return legalAuthenticator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLegalAuthenticator(XCN newLegalAuthenticator, NotificationChain msgs) {
		XCN oldLegalAuthenticator = legalAuthenticator;
		legalAuthenticator = newLegalAuthenticator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__LEGAL_AUTHENTICATOR, oldLegalAuthenticator, newLegalAuthenticator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLegalAuthenticator(XCN newLegalAuthenticator) {
		if (newLegalAuthenticator != legalAuthenticator) {
			NotificationChain msgs = null;
			if (legalAuthenticator != null)
				msgs = ((InternalEObject)legalAuthenticator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__LEGAL_AUTHENTICATOR, null, msgs);
			if (newLegalAuthenticator != null)
				msgs = ((InternalEObject)newLegalAuthenticator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__LEGAL_AUTHENTICATOR, null, msgs);
			msgs = basicSetLegalAuthenticator(newLegalAuthenticator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__LEGAL_AUTHENTICATOR, newLegalAuthenticator, newLegalAuthenticator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMimeType(String newMimeType) {
		String oldMimeType = mimeType;
		mimeType = newMimeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__MIME_TYPE, oldMimeType, mimeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParentDocumentType getParentDocument() {
		return parentDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentDocument(ParentDocumentType newParentDocument, NotificationChain msgs) {
		ParentDocumentType oldParentDocument = parentDocument;
		parentDocument = newParentDocument;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__PARENT_DOCUMENT, oldParentDocument, newParentDocument);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentDocument(ParentDocumentType newParentDocument) {
		if (newParentDocument != parentDocument) {
			NotificationChain msgs = null;
			if (parentDocument != null)
				msgs = ((InternalEObject)parentDocument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__PARENT_DOCUMENT, null, msgs);
			if (newParentDocument != null)
				msgs = ((InternalEObject)newParentDocument).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__PARENT_DOCUMENT, null, msgs);
			msgs = basicSetParentDocument(newParentDocument, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__PARENT_DOCUMENT, newParentDocument, newParentDocument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CX getPatientId() {
		return patientId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPatientId(CX newPatientId, NotificationChain msgs) {
		CX oldPatientId = patientId;
		patientId = newPatientId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__PATIENT_ID, oldPatientId, newPatientId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatientId(CX newPatientId) {

		patientId = newPatientId;
//		if (newPatientId != patientId) {
//			NotificationChain msgs = null;
//			if (patientId != null)
//				msgs = ((InternalEObject)patientId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__PATIENT_ID, null, msgs);
//			if (newPatientId != null)
//				msgs = ((InternalEObject)newPatientId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__PATIENT_ID, null, msgs);
//			msgs = basicSetPatientId(newPatientId, msgs);
//			if (msgs != null) msgs.dispatch();
//		}
//		else if (eNotificationRequired())
//			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__PATIENT_ID, newPatientId, newPatientId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodedMetadataType getPracticeSettingCode() {
		return practiceSettingCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPracticeSettingCode(CodedMetadataType newPracticeSettingCode, NotificationChain msgs) {
		CodedMetadataType oldPracticeSettingCode = practiceSettingCode;
		practiceSettingCode = newPracticeSettingCode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__PRACTICE_SETTING_CODE, oldPracticeSettingCode, newPracticeSettingCode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPracticeSettingCode(CodedMetadataType newPracticeSettingCode) {
		if (newPracticeSettingCode != practiceSettingCode) {
			NotificationChain msgs = null;
			if (practiceSettingCode != null)
				msgs = ((InternalEObject)practiceSettingCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__PRACTICE_SETTING_CODE, null, msgs);
			if (newPracticeSettingCode != null)
				msgs = ((InternalEObject)newPracticeSettingCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__PRACTICE_SETTING_CODE, null, msgs);
			msgs = basicSetPracticeSettingCode(newPracticeSettingCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__PRACTICE_SETTING_CODE, newPracticeSettingCode, newPracticeSettingCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryUniqueId() {
		return repositoryUniqueId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryUniqueId(String newRepositoryUniqueId) {
		String oldRepositoryUniqueId = repositoryUniqueId;
		repositoryUniqueId = newRepositoryUniqueId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__REPOSITORY_UNIQUE_ID, oldRepositoryUniqueId, repositoryUniqueId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceStartTime() {
		return serviceStartTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceStartTime(String newServiceStartTime) {
		String oldServiceStartTime = serviceStartTime;
		serviceStartTime = newServiceStartTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__SERVICE_START_TIME, oldServiceStartTime, serviceStartTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceStopTime() {
		return serviceStopTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceStopTime(String newServiceStopTime) {
		String oldServiceStopTime = serviceStopTime;
		serviceStopTime = newServiceStopTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__SERVICE_STOP_TIME, oldServiceStopTime, serviceStopTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CX getSourcePatientId() {
		return sourcePatientId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourcePatientId(CX newSourcePatientId, NotificationChain msgs) {
		CX oldSourcePatientId = sourcePatientId;
		sourcePatientId = newSourcePatientId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_ID, oldSourcePatientId, newSourcePatientId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourcePatientId(CX newSourcePatientId) {
		if (newSourcePatientId != sourcePatientId) {
			NotificationChain msgs = null;
			if (sourcePatientId != null)
				msgs = ((InternalEObject)sourcePatientId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_ID, null, msgs);
			if (newSourcePatientId != null)
				msgs = ((InternalEObject)newSourcePatientId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_ID, null, msgs);
			msgs = basicSetSourcePatientId(newSourcePatientId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_ID, newSourcePatientId, newSourcePatientId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(String newSize) {
		String oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourcePatientInfoType getSourcePatientInfo() {
		return sourcePatientInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourcePatientInfo(SourcePatientInfoType newSourcePatientInfo, NotificationChain msgs) {
		SourcePatientInfoType oldSourcePatientInfo = sourcePatientInfo;
		sourcePatientInfo = newSourcePatientInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_INFO, oldSourcePatientInfo, newSourcePatientInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourcePatientInfo(SourcePatientInfoType newSourcePatientInfo) {
		if (newSourcePatientInfo != sourcePatientInfo) {
			NotificationChain msgs = null;
			if (sourcePatientInfo != null)
				msgs = ((InternalEObject)sourcePatientInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_INFO, null, msgs);
			if (newSourcePatientInfo != null)
				msgs = ((InternalEObject)newSourcePatientInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_INFO, null, msgs);
			msgs = basicSetSourcePatientInfo(newSourcePatientInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_INFO, newSourcePatientInfo, newSourcePatientInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternationalStringType getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTitle(InternationalStringType newTitle, NotificationChain msgs) {
		InternationalStringType oldTitle = title;
		title = newTitle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__TITLE, oldTitle, newTitle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(InternationalStringType newTitle) {
		if (newTitle != title) {
			NotificationChain msgs = null;
			if (title != null)
				msgs = ((InternalEObject)title).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__TITLE, null, msgs);
			if (newTitle != null)
				msgs = ((InternalEObject)newTitle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__TITLE, null, msgs);
			msgs = basicSetTitle(newTitle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__TITLE, newTitle, newTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodedMetadataType getTypeCode() {
		return typeCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeCode(CodedMetadataType newTypeCode, NotificationChain msgs) {
		CodedMetadataType oldTypeCode = typeCode;
		typeCode = newTypeCode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__TYPE_CODE, oldTypeCode, newTypeCode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeCode(CodedMetadataType newTypeCode) {
		if (newTypeCode != typeCode) {
			NotificationChain msgs = null;
			if (typeCode != null)
				msgs = ((InternalEObject)typeCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__TYPE_CODE, null, msgs);
			if (newTypeCode != null)
				msgs = ((InternalEObject)newTypeCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.DOCUMENT_ENTRY_TYPE__TYPE_CODE, null, msgs);
			msgs = basicSetTypeCode(newTypeCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__TYPE_CODE, newTypeCode, newTypeCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUniqueId(String newUniqueId) {
		String oldUniqueId = uniqueId;
		uniqueId = newUniqueId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__UNIQUE_ID, oldUniqueId, uniqueId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExisting() {
		return existing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExisting(boolean newExisting) {
		boolean oldExisting = existing;
		existing = newExisting;
		boolean oldExistingESet = existingESet;
		existingESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.DOCUMENT_ENTRY_TYPE__EXISTING, oldExisting, existing, !oldExistingESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetExisting() {
		boolean oldExisting = existing;
		boolean oldExistingESet = existingESet;
		existing = EXISTING_EDEFAULT;
		existingESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetadataPackage.DOCUMENT_ENTRY_TYPE__EXISTING, oldExisting, EXISTING_EDEFAULT, oldExistingESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExisting() {
		return existingESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__AUTHORS:
				return ((InternalEList)getAuthors()).basicRemove(otherEnd, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__CLASS_CODE:
				return basicSetClassCode(null, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__COMMENTS:
				return basicSetComments(null, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__CONFIDENTIALITY_CODE:
				return ((InternalEList)getConfidentialityCode()).basicRemove(otherEnd, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__EVENT_CODE:
				return ((InternalEList)getEventCode()).basicRemove(otherEnd, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__EXTENSION:
				return ((InternalEList)getExtension()).basicRemove(otherEnd, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__FORMAT_CODE:
				return basicSetFormatCode(null, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__HEALTH_CARE_FACILITY_TYPE_CODE:
				return basicSetHealthCareFacilityTypeCode(null, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__LEGAL_AUTHENTICATOR:
				return basicSetLegalAuthenticator(null, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PARENT_DOCUMENT:
				return basicSetParentDocument(null, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PATIENT_ID:
				return basicSetPatientId(null, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PRACTICE_SETTING_CODE:
				return basicSetPracticeSettingCode(null, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_ID:
				return basicSetSourcePatientId(null, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_INFO:
				return basicSetSourcePatientInfo(null, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__TITLE:
				return basicSetTitle(null, msgs);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__TYPE_CODE:
				return basicSetTypeCode(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__AUTHORS:
				return getAuthors();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__AVAILABILITY_STATUS:
				return getAvailabilityStatus();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__CLASS_CODE:
				return getClassCode();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__COMMENTS:
				return getComments();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__CONFIDENTIALITY_CODE:
				return getConfidentialityCode();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__CREATION_TIME:
				return getCreationTime();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__ENTRY_UUID:
				return getEntryUUID();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__EVENT_CODE:
				return getEventCode();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__EXTENSION:
				return getExtension();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__FORMAT_CODE:
				return getFormatCode();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH:
				return getHash();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__HEALTH_CARE_FACILITY_TYPE_CODE:
				return getHealthCareFacilityTypeCode();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__LANGUAGE_CODE:
				return getLanguageCode();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__LEGAL_AUTHENTICATOR:
				return getLegalAuthenticator();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__MIME_TYPE:
				return getMimeType();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PARENT_DOCUMENT:
				return getParentDocument();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PATIENT_ID:
				return getPatientId();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PRACTICE_SETTING_CODE:
				return getPracticeSettingCode();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__REPOSITORY_UNIQUE_ID:
				return getRepositoryUniqueId();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SERVICE_START_TIME:
				return getServiceStartTime();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SERVICE_STOP_TIME:
				return getServiceStopTime();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_ID:
				return getSourcePatientId();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SIZE:
				return getSize();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_INFO:
				return getSourcePatientInfo();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__TITLE:
				return getTitle();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__TYPE_CODE:
				return getTypeCode();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__UNIQUE_ID:
				return getUniqueId();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__URI:
				return getUri();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__EXISTING:
				return isExisting() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__AUTHORS:
				getAuthors().clear();
				getAuthors().addAll((Collection)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__AVAILABILITY_STATUS:
				setAvailabilityStatus((AvailabilityStatusType)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__CLASS_CODE:
				setClassCode((CodedMetadataType)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__COMMENTS:
				setComments((InternationalStringType)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__CONFIDENTIALITY_CODE:
				getConfidentialityCode().clear();
				getConfidentialityCode().addAll((Collection)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__CREATION_TIME:
				setCreationTime((String)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__ENTRY_UUID:
				setEntryUUID((String)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__EVENT_CODE:
				getEventCode().clear();
				getEventCode().addAll((Collection)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__FORMAT_CODE:
				setFormatCode((CodedMetadataType)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH:
				setHash((String)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__HEALTH_CARE_FACILITY_TYPE_CODE:
				setHealthCareFacilityTypeCode((CodedMetadataType)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__LANGUAGE_CODE:
				setLanguageCode((String)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__LEGAL_AUTHENTICATOR:
				setLegalAuthenticator((XCN)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__MIME_TYPE:
				setMimeType((String)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PARENT_DOCUMENT:
				setParentDocument((ParentDocumentType)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PATIENT_ID:
				setPatientId((CX)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PRACTICE_SETTING_CODE:
				setPracticeSettingCode((CodedMetadataType)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__REPOSITORY_UNIQUE_ID:
				setRepositoryUniqueId((String)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SERVICE_START_TIME:
				setServiceStartTime((String)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SERVICE_STOP_TIME:
				setServiceStopTime((String)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_ID:
				setSourcePatientId((CX)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SIZE:
				setSize((String)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_INFO:
				setSourcePatientInfo((SourcePatientInfoType)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__TITLE:
				setTitle((InternationalStringType)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__TYPE_CODE:
				setTypeCode((CodedMetadataType)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__UNIQUE_ID:
				setUniqueId((String)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__URI:
				setUri((String)newValue);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__EXISTING:
				setExisting(((Boolean)newValue).booleanValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__AUTHORS:
				getAuthors().clear();
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__AVAILABILITY_STATUS:
				unsetAvailabilityStatus();
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__CLASS_CODE:
				setClassCode((CodedMetadataType)null);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__COMMENTS:
				setComments((InternationalStringType)null);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__CONFIDENTIALITY_CODE:
				getConfidentialityCode().clear();
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__CREATION_TIME:
				setCreationTime(CREATION_TIME_EDEFAULT);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__ENTRY_UUID:
				setEntryUUID(ENTRY_UUID_EDEFAULT);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__EVENT_CODE:
				getEventCode().clear();
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__EXTENSION:
				getExtension().clear();
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__FORMAT_CODE:
				setFormatCode((CodedMetadataType)null);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH:
				setHash(HASH_EDEFAULT);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__HEALTH_CARE_FACILITY_TYPE_CODE:
				setHealthCareFacilityTypeCode((CodedMetadataType)null);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__LANGUAGE_CODE:
				setLanguageCode(LANGUAGE_CODE_EDEFAULT);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__LEGAL_AUTHENTICATOR:
				setLegalAuthenticator((XCN)null);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__MIME_TYPE:
				setMimeType(MIME_TYPE_EDEFAULT);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PARENT_DOCUMENT:
				setParentDocument((ParentDocumentType)null);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PATIENT_ID:
				setPatientId((CX)null);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PRACTICE_SETTING_CODE:
				setPracticeSettingCode((CodedMetadataType)null);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__REPOSITORY_UNIQUE_ID:
				setRepositoryUniqueId(REPOSITORY_UNIQUE_ID_EDEFAULT);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SERVICE_START_TIME:
				setServiceStartTime(SERVICE_START_TIME_EDEFAULT);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SERVICE_STOP_TIME:
				setServiceStopTime(SERVICE_STOP_TIME_EDEFAULT);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_ID:
				setSourcePatientId((CX)null);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_INFO:
				setSourcePatientInfo((SourcePatientInfoType)null);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__TITLE:
				setTitle((InternationalStringType)null);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__TYPE_CODE:
				setTypeCode((CodedMetadataType)null);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__UNIQUE_ID:
				setUniqueId(UNIQUE_ID_EDEFAULT);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__URI:
				setUri(URI_EDEFAULT);
				return;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__EXISTING:
				unsetExisting();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__AUTHORS:
				return authors != null && !authors.isEmpty();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__AVAILABILITY_STATUS:
				return isSetAvailabilityStatus();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__CLASS_CODE:
				return classCode != null;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__COMMENTS:
				return comments != null;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__CONFIDENTIALITY_CODE:
				return confidentialityCode != null && !confidentialityCode.isEmpty();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__CREATION_TIME:
				return CREATION_TIME_EDEFAULT == null ? creationTime != null : !CREATION_TIME_EDEFAULT.equals(creationTime);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__ENTRY_UUID:
				return ENTRY_UUID_EDEFAULT == null ? entryUUID != null : !ENTRY_UUID_EDEFAULT.equals(entryUUID);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__EVENT_CODE:
				return eventCode != null && !eventCode.isEmpty();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__FORMAT_CODE:
				return formatCode != null;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__HASH:
				return HASH_EDEFAULT == null ? hash != null : !HASH_EDEFAULT.equals(hash);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__HEALTH_CARE_FACILITY_TYPE_CODE:
				return healthCareFacilityTypeCode != null;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__LANGUAGE_CODE:
				return LANGUAGE_CODE_EDEFAULT == null ? languageCode != null : !LANGUAGE_CODE_EDEFAULT.equals(languageCode);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__LEGAL_AUTHENTICATOR:
				return legalAuthenticator != null;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__MIME_TYPE:
				return MIME_TYPE_EDEFAULT == null ? mimeType != null : !MIME_TYPE_EDEFAULT.equals(mimeType);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PARENT_DOCUMENT:
				return parentDocument != null;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PATIENT_ID:
				return patientId != null;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__PRACTICE_SETTING_CODE:
				return practiceSettingCode != null;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__REPOSITORY_UNIQUE_ID:
				return REPOSITORY_UNIQUE_ID_EDEFAULT == null ? repositoryUniqueId != null : !REPOSITORY_UNIQUE_ID_EDEFAULT.equals(repositoryUniqueId);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SERVICE_START_TIME:
				return SERVICE_START_TIME_EDEFAULT == null ? serviceStartTime != null : !SERVICE_START_TIME_EDEFAULT.equals(serviceStartTime);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SERVICE_STOP_TIME:
				return SERVICE_STOP_TIME_EDEFAULT == null ? serviceStopTime != null : !SERVICE_STOP_TIME_EDEFAULT.equals(serviceStopTime);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_ID:
				return sourcePatientId != null;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__SOURCE_PATIENT_INFO:
				return sourcePatientInfo != null;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__TITLE:
				return title != null;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__TYPE_CODE:
				return typeCode != null;
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__UNIQUE_ID:
				return UNIQUE_ID_EDEFAULT == null ? uniqueId != null : !UNIQUE_ID_EDEFAULT.equals(uniqueId);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case MetadataPackage.DOCUMENT_ENTRY_TYPE__EXISTING:
				return isSetExisting();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (availabilityStatus: ");
		if (availabilityStatusESet) result.append(availabilityStatus); else result.append("<unset>");
		result.append(", creationTime: ");
		result.append(creationTime);
		result.append(", entryUUID: ");
		result.append(entryUUID);
		result.append(", hash: ");
		result.append(hash);
		result.append(", languageCode: ");
		result.append(languageCode);
		result.append(", mimeType: ");
		result.append(mimeType);
		result.append(", repositoryUniqueId: ");
		result.append(repositoryUniqueId);
		result.append(", serviceStartTime: ");
		result.append(serviceStartTime);
		result.append(", serviceStopTime: ");
		result.append(serviceStopTime);
		result.append(", size: ");
		result.append(size);
		result.append(", uniqueId: ");
		result.append(uniqueId);
		result.append(", uri: ");
		result.append(uri);
		result.append(", existing: ");
		if (existingESet) result.append(existing); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //DocumentEntryTypeImpl