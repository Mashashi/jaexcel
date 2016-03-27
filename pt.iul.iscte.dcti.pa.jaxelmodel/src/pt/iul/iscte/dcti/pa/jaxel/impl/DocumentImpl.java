/**
 */
package  pt.iul.iscte.dcti.pa.jaxel.impl;

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

import pt.iul.iscte.dcti.pa.jaxel.Document;
import pt.iul.iscte.dcti.pa.jaxel.JaxelPackage;
import pt.iul.iscte.dcti.pa.jaxel.Sheet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.impl.DocumentImpl#getSheet_file <em>Sheet file</em>}</li>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.impl.DocumentImpl#getBinFolder <em>Bin Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentImpl extends EObjectImpl implements Document {
	/**
	 * The cached value of the '{@link #getSheet_file() <em>Sheet file</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSheet_file()
	 * @generated
	 * @ordered
	 */
	protected EList<Sheet> sheet_file;

	/**
	 * The default value of the '{@link #getBinFolder() <em>Bin Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String BIN_FOLDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBinFolder() <em>Bin Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinFolder()
	 * @generated
	 * @ordered
	 */
	protected String binFolder = BIN_FOLDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaxelPackage.Literals.DOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList< Sheet> getSheet_file() {
		if (sheet_file == null) {
			sheet_file = new EObjectContainmentEList<Sheet>(Sheet.class, this, JaxelPackage.DOCUMENT__SHEET_FILE);
		}
		return sheet_file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBinFolder() {
		return binFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinFolder(String newBinFolder) {
		String oldBinFolder = binFolder;
		binFolder = newBinFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaxelPackage.DOCUMENT__BIN_FOLDER, oldBinFolder, binFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JaxelPackage.DOCUMENT__SHEET_FILE:
				return ((InternalEList<?>)getSheet_file()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JaxelPackage.DOCUMENT__SHEET_FILE:
				return getSheet_file();
			case JaxelPackage.DOCUMENT__BIN_FOLDER:
				return getBinFolder();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JaxelPackage.DOCUMENT__SHEET_FILE:
				getSheet_file().clear();
				getSheet_file().addAll((Collection<? extends Sheet>)newValue);
				return;
			case JaxelPackage.DOCUMENT__BIN_FOLDER:
				setBinFolder((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case JaxelPackage.DOCUMENT__SHEET_FILE:
				getSheet_file().clear();
				return;
			case JaxelPackage.DOCUMENT__BIN_FOLDER:
				setBinFolder(BIN_FOLDER_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JaxelPackage.DOCUMENT__SHEET_FILE:
				return sheet_file != null && !sheet_file.isEmpty();
			case JaxelPackage.DOCUMENT__BIN_FOLDER:
				return BIN_FOLDER_EDEFAULT == null ? binFolder != null : !BIN_FOLDER_EDEFAULT.equals(binFolder);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (binFolder: ");
		result.append(binFolder);
		result.append(')');
		return result.toString();
	}

} //DocumentImpl
