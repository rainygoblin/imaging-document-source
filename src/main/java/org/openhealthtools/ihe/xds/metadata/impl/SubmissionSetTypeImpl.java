/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.openhealthtools.ihe.common.hl7v2.CX;

import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.IntendedRecipientType;
import org.openhealthtools.ihe.xds.metadata.InternationalStringType;
import org.openhealthtools.ihe.xds.metadata.MetadataPackage;
import org.openhealthtools.ihe.xds.metadata.SubmissionSetType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Submission Set Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.SubmissionSetTypeImpl#getAssociatedDocuments <em>Associated Documents</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.SubmissionSetTypeImpl#getAssociatedFolders <em>Associated Folders</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.SubmissionSetTypeImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.SubmissionSetTypeImpl#getAvailabilityStatus <em>Availability Status</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.SubmissionSetTypeImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.SubmissionSetTypeImpl#getContentTypeCode <em>Content Type Code</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.SubmissionSetTypeImpl#getEntryUUID <em>Entry UUID</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.SubmissionSetTypeImpl#getIntendedRecipient <em>Intended Recipient</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.SubmissionSetTypeImpl#getPatientId <em>Patient Id</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.SubmissionSetTypeImpl#getSourceId <em>Source Id</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.SubmissionSetTypeImpl#getSubmissionTime <em>Submission Time</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.SubmissionSetTypeImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.openhealthtools.ihe.xds.metadata.impl.SubmissionSetTypeImpl#getUniqueId <em>Unique Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubmissionSetTypeImpl extends EObjectImpl implements SubmissionSetType {
	/**
	 * The cached value of the '{@link #getAssociatedDocuments() <em>Associated Documents</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedDocuments()
	 * @generated
	 * @ordered
	 */
	protected EList associatedDocuments;

	/**
	 * The cached value of the '{@link #getAssociatedFolders() <em>Associated Folders</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedFolders()
	 * @generated
	 * @ordered
	 */
	protected EList associatedFolders;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected AuthorType author;

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
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected InternationalStringType comments;

	/**
	 * The cached value of the '{@link #getContentTypeCode() <em>Content Type Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentTypeCode()
	 * @generated
	 * @ordered
	 */
	protected CodedMetadataType contentTypeCode;

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
	 * The cached value of the '{@link #getIntendedRecipient() <em>Intended Recipient</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntendedRecipient()
	 * @generated
	 * @ordered
	 */
	protected EList intendedRecipient;

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
	 * The default value of the '{@link #getSourceId() <em>Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceId()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceId() <em>Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceId()
	 * @generated
	 * @ordered
	 */
	protected String sourceId = SOURCE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubmissionTime() <em>Submission Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubmissionTime()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBMISSION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubmissionTime() <em>Submission Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubmissionTime()
	 * @generated
	 * @ordered
	 */
	protected String submissionTime = SUBMISSION_TIME_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubmissionSetTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MetadataPackage.Literals.SUBMISSION_SET_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAssociatedDocuments() {
		if (associatedDocuments == null) {
			associatedDocuments = new EDataTypeEList(String.class, this, MetadataPackage.SUBMISSION_SET_TYPE__ASSOCIATED_DOCUMENTS);
		}
		return associatedDocuments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAssociatedFolders() {
		if (associatedFolders == null) {
			associatedFolders = new EDataTypeEList(String.class, this, MetadataPackage.SUBMISSION_SET_TYPE__ASSOCIATED_FOLDERS);
		}
		return associatedFolders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthorType getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAuthor(AuthorType newAuthor, NotificationChain msgs) {
		AuthorType oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__AUTHOR, oldAuthor, newAuthor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(AuthorType newAuthor) {
		if (newAuthor != author) {
			NotificationChain msgs = null;
			if (author != null)
				msgs = ((InternalEObject)author).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.SUBMISSION_SET_TYPE__AUTHOR, null, msgs);
			if (newAuthor != null)
				msgs = ((InternalEObject)newAuthor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.SUBMISSION_SET_TYPE__AUTHOR, null, msgs);
			msgs = basicSetAuthor(newAuthor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__AUTHOR, newAuthor, newAuthor));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__AVAILABILITY_STATUS, oldAvailabilityStatus, availabilityStatus, !oldAvailabilityStatusESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetadataPackage.SUBMISSION_SET_TYPE__AVAILABILITY_STATUS, oldAvailabilityStatus, AVAILABILITY_STATUS_EDEFAULT, oldAvailabilityStatusESet));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__COMMENTS, oldComments, newComments);
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
				msgs = ((InternalEObject)comments).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.SUBMISSION_SET_TYPE__COMMENTS, null, msgs);
			if (newComments != null)
				msgs = ((InternalEObject)newComments).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.SUBMISSION_SET_TYPE__COMMENTS, null, msgs);
			msgs = basicSetComments(newComments, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__COMMENTS, newComments, newComments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodedMetadataType getContentTypeCode() {
		return contentTypeCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContentTypeCode(CodedMetadataType newContentTypeCode, NotificationChain msgs) {
		CodedMetadataType oldContentTypeCode = contentTypeCode;
		contentTypeCode = newContentTypeCode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__CONTENT_TYPE_CODE, oldContentTypeCode, newContentTypeCode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContentTypeCode(CodedMetadataType newContentTypeCode) {
		if (newContentTypeCode != contentTypeCode) {
			NotificationChain msgs = null;
			if (contentTypeCode != null)
				msgs = ((InternalEObject)contentTypeCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.SUBMISSION_SET_TYPE__CONTENT_TYPE_CODE, null, msgs);
			if (newContentTypeCode != null)
				msgs = ((InternalEObject)newContentTypeCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.SUBMISSION_SET_TYPE__CONTENT_TYPE_CODE, null, msgs);
			msgs = basicSetContentTypeCode(newContentTypeCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__CONTENT_TYPE_CODE, newContentTypeCode, newContentTypeCode));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__ENTRY_UUID, oldEntryUUID, entryUUID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getIntendedRecipient() {
		if (intendedRecipient == null) {
			intendedRecipient = new EObjectContainmentEList(IntendedRecipientType.class, this, MetadataPackage.SUBMISSION_SET_TYPE__INTENDED_RECIPIENT);
		}
		return intendedRecipient;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__PATIENT_ID, oldPatientId, newPatientId);
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
//				msgs = ((InternalEObject)patientId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.SUBMISSION_SET_TYPE__PATIENT_ID, null, msgs);
//			if (newPatientId != null)
//				msgs = ((InternalEObject)newPatientId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.SUBMISSION_SET_TYPE__PATIENT_ID, null, msgs);
//			msgs = basicSetPatientId(newPatientId, msgs);
//			if (msgs != null) msgs.dispatch();
//		}
//		else if (eNotificationRequired())
//			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__PATIENT_ID, newPatientId, newPatientId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceId() {
		return sourceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceId(String newSourceId) {
		String oldSourceId = sourceId;
		sourceId = newSourceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__SOURCE_ID, oldSourceId, sourceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubmissionTime() {
		return submissionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubmissionTime(String newSubmissionTime) {
		String oldSubmissionTime = submissionTime;
		submissionTime = newSubmissionTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__SUBMISSION_TIME, oldSubmissionTime, submissionTime));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__TITLE, oldTitle, newTitle);
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
				msgs = ((InternalEObject)title).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.SUBMISSION_SET_TYPE__TITLE, null, msgs);
			if (newTitle != null)
				msgs = ((InternalEObject)newTitle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetadataPackage.SUBMISSION_SET_TYPE__TITLE, null, msgs);
			msgs = basicSetTitle(newTitle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__TITLE, newTitle, newTitle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SUBMISSION_SET_TYPE__UNIQUE_ID, oldUniqueId, uniqueId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetadataPackage.SUBMISSION_SET_TYPE__AUTHOR:
				return basicSetAuthor(null, msgs);
			case MetadataPackage.SUBMISSION_SET_TYPE__COMMENTS:
				return basicSetComments(null, msgs);
			case MetadataPackage.SUBMISSION_SET_TYPE__CONTENT_TYPE_CODE:
				return basicSetContentTypeCode(null, msgs);
			case MetadataPackage.SUBMISSION_SET_TYPE__INTENDED_RECIPIENT:
				return ((InternalEList)getIntendedRecipient()).basicRemove(otherEnd, msgs);
			case MetadataPackage.SUBMISSION_SET_TYPE__PATIENT_ID:
				return basicSetPatientId(null, msgs);
			case MetadataPackage.SUBMISSION_SET_TYPE__TITLE:
				return basicSetTitle(null, msgs);
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
			case MetadataPackage.SUBMISSION_SET_TYPE__ASSOCIATED_DOCUMENTS:
				return getAssociatedDocuments();
			case MetadataPackage.SUBMISSION_SET_TYPE__ASSOCIATED_FOLDERS:
				return getAssociatedFolders();
			case MetadataPackage.SUBMISSION_SET_TYPE__AUTHOR:
				return getAuthor();
			case MetadataPackage.SUBMISSION_SET_TYPE__AVAILABILITY_STATUS:
				return getAvailabilityStatus();
			case MetadataPackage.SUBMISSION_SET_TYPE__COMMENTS:
				return getComments();
			case MetadataPackage.SUBMISSION_SET_TYPE__CONTENT_TYPE_CODE:
				return getContentTypeCode();
			case MetadataPackage.SUBMISSION_SET_TYPE__ENTRY_UUID:
				return getEntryUUID();
			case MetadataPackage.SUBMISSION_SET_TYPE__INTENDED_RECIPIENT:
				return getIntendedRecipient();
			case MetadataPackage.SUBMISSION_SET_TYPE__PATIENT_ID:
				return getPatientId();
			case MetadataPackage.SUBMISSION_SET_TYPE__SOURCE_ID:
				return getSourceId();
			case MetadataPackage.SUBMISSION_SET_TYPE__SUBMISSION_TIME:
				return getSubmissionTime();
			case MetadataPackage.SUBMISSION_SET_TYPE__TITLE:
				return getTitle();
			case MetadataPackage.SUBMISSION_SET_TYPE__UNIQUE_ID:
				return getUniqueId();
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
			case MetadataPackage.SUBMISSION_SET_TYPE__ASSOCIATED_DOCUMENTS:
				getAssociatedDocuments().clear();
				getAssociatedDocuments().addAll((Collection)newValue);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__ASSOCIATED_FOLDERS:
				getAssociatedFolders().clear();
				getAssociatedFolders().addAll((Collection)newValue);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__AUTHOR:
				setAuthor((AuthorType)newValue);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__AVAILABILITY_STATUS:
				setAvailabilityStatus((AvailabilityStatusType)newValue);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__COMMENTS:
				setComments((InternationalStringType)newValue);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__CONTENT_TYPE_CODE:
				setContentTypeCode((CodedMetadataType)newValue);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__ENTRY_UUID:
				setEntryUUID((String)newValue);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__INTENDED_RECIPIENT:
				getIntendedRecipient().clear();
				getIntendedRecipient().addAll((Collection)newValue);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__PATIENT_ID:
				setPatientId((CX)newValue);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__SOURCE_ID:
				setSourceId((String)newValue);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__SUBMISSION_TIME:
				setSubmissionTime((String)newValue);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__TITLE:
				setTitle((InternationalStringType)newValue);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__UNIQUE_ID:
				setUniqueId((String)newValue);
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
			case MetadataPackage.SUBMISSION_SET_TYPE__ASSOCIATED_DOCUMENTS:
				getAssociatedDocuments().clear();
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__ASSOCIATED_FOLDERS:
				getAssociatedFolders().clear();
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__AUTHOR:
				setAuthor((AuthorType)null);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__AVAILABILITY_STATUS:
				unsetAvailabilityStatus();
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__COMMENTS:
				setComments((InternationalStringType)null);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__CONTENT_TYPE_CODE:
				setContentTypeCode((CodedMetadataType)null);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__ENTRY_UUID:
				setEntryUUID(ENTRY_UUID_EDEFAULT);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__INTENDED_RECIPIENT:
				getIntendedRecipient().clear();
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__PATIENT_ID:
				setPatientId((CX)null);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__SOURCE_ID:
				setSourceId(SOURCE_ID_EDEFAULT);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__SUBMISSION_TIME:
				setSubmissionTime(SUBMISSION_TIME_EDEFAULT);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__TITLE:
				setTitle((InternationalStringType)null);
				return;
			case MetadataPackage.SUBMISSION_SET_TYPE__UNIQUE_ID:
				setUniqueId(UNIQUE_ID_EDEFAULT);
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
			case MetadataPackage.SUBMISSION_SET_TYPE__ASSOCIATED_DOCUMENTS:
				return associatedDocuments != null && !associatedDocuments.isEmpty();
			case MetadataPackage.SUBMISSION_SET_TYPE__ASSOCIATED_FOLDERS:
				return associatedFolders != null && !associatedFolders.isEmpty();
			case MetadataPackage.SUBMISSION_SET_TYPE__AUTHOR:
				return author != null;
			case MetadataPackage.SUBMISSION_SET_TYPE__AVAILABILITY_STATUS:
				return isSetAvailabilityStatus();
			case MetadataPackage.SUBMISSION_SET_TYPE__COMMENTS:
				return comments != null;
			case MetadataPackage.SUBMISSION_SET_TYPE__CONTENT_TYPE_CODE:
				return contentTypeCode != null;
			case MetadataPackage.SUBMISSION_SET_TYPE__ENTRY_UUID:
				return ENTRY_UUID_EDEFAULT == null ? entryUUID != null : !ENTRY_UUID_EDEFAULT.equals(entryUUID);
			case MetadataPackage.SUBMISSION_SET_TYPE__INTENDED_RECIPIENT:
				return intendedRecipient != null && !intendedRecipient.isEmpty();
			case MetadataPackage.SUBMISSION_SET_TYPE__PATIENT_ID:
				return patientId != null;
			case MetadataPackage.SUBMISSION_SET_TYPE__SOURCE_ID:
				return SOURCE_ID_EDEFAULT == null ? sourceId != null : !SOURCE_ID_EDEFAULT.equals(sourceId);
			case MetadataPackage.SUBMISSION_SET_TYPE__SUBMISSION_TIME:
				return SUBMISSION_TIME_EDEFAULT == null ? submissionTime != null : !SUBMISSION_TIME_EDEFAULT.equals(submissionTime);
			case MetadataPackage.SUBMISSION_SET_TYPE__TITLE:
				return title != null;
			case MetadataPackage.SUBMISSION_SET_TYPE__UNIQUE_ID:
				return UNIQUE_ID_EDEFAULT == null ? uniqueId != null : !UNIQUE_ID_EDEFAULT.equals(uniqueId);
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
		result.append(" (associatedDocuments: ");
		result.append(associatedDocuments);
		result.append(", associatedFolders: ");
		result.append(associatedFolders);
		result.append(", availabilityStatus: ");
		if (availabilityStatusESet) result.append(availabilityStatus); else result.append("<unset>");
		result.append(", entryUUID: ");
		result.append(entryUUID);
		result.append(", sourceId: ");
		result.append(sourceId);
		result.append(", submissionTime: ");
		result.append(submissionTime);
		result.append(", uniqueId: ");
		result.append(uniqueId);
		result.append(')');
		return result.toString();
	}

} //SubmissionSetTypeImpl
