/**
 */
package  pt.iul.iscte.dcti.pa.jaxel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import pt.iul.iscte.dcti.pa.jaxel.JaxelPackage;
import pt.iul.iscte.dcti.pa.jaxel.Row;
import pt.iul.iscte.dcti.pa.jaxel.Sheet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sheet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.impl.SheetImpl#getName <em>Name</em>}</li>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.impl.SheetImpl#getNumberOfRows <em>Number Of Rows</em>}</li>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.impl.SheetImpl#getNumberOfColumns <em>Number Of Columns</em>}</li>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.impl.SheetImpl#getRows <em>Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SheetImpl extends EObjectImpl implements Sheet {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfRows() <em>Number Of Rows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfRows()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_ROWS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberOfRows() <em>Number Of Rows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfRows()
	 * @generated
	 * @ordered
	 */
	protected int numberOfRows = NUMBER_OF_ROWS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfColumns() <em>Number Of Columns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfColumns()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_COLUMNS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberOfColumns() <em>Number Of Columns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfColumns()
	 * @generated
	 * @ordered
	 */
	protected int numberOfColumns = NUMBER_OF_COLUMNS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRows() <em>Rows</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRows()
	 * @generated
	 * @ordered
	 */
	protected EMap<Integer, Row> rows;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SheetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JaxelPackage.Literals.SHEET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaxelPackage.SHEET__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfRows() {
		return numberOfRows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfRows(int newNumberOfRows) {
		int oldNumberOfRows = numberOfRows;
		numberOfRows = newNumberOfRows;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaxelPackage.SHEET__NUMBER_OF_ROWS, oldNumberOfRows, numberOfRows));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfColumns(int newNumberOfColumns) {
		int oldNumberOfColumns = numberOfColumns;
		numberOfColumns = newNumberOfColumns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JaxelPackage.SHEET__NUMBER_OF_COLUMNS, oldNumberOfColumns, numberOfColumns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<Integer,  Row> getRows() {
		if (rows == null) {
			rows = new EcoreEMap<Integer,Row>(JaxelPackage.Literals.EINTEGER_OBJECT_TO_ROW_MAP, EIntegerObjectToRowMapImpl.class, this, JaxelPackage.SHEET__ROWS);
		}
		return rows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JaxelPackage.SHEET__ROWS:
				return ((InternalEList<?>)getRows()).basicRemove(otherEnd, msgs);
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
			case JaxelPackage.SHEET__NAME:
				return getName();
			case JaxelPackage.SHEET__NUMBER_OF_ROWS:
				return getNumberOfRows();
			case JaxelPackage.SHEET__NUMBER_OF_COLUMNS:
				return getNumberOfColumns();
			case JaxelPackage.SHEET__ROWS:
				if (coreType) return getRows();
				else return getRows().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JaxelPackage.SHEET__NAME:
				setName((String)newValue);
				return;
			case JaxelPackage.SHEET__NUMBER_OF_ROWS:
				setNumberOfRows((Integer)newValue);
				return;
			case JaxelPackage.SHEET__NUMBER_OF_COLUMNS:
				setNumberOfColumns((Integer)newValue);
				return;
			case JaxelPackage.SHEET__ROWS:
				((EStructuralFeature.Setting)getRows()).set(newValue);
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
			case JaxelPackage.SHEET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JaxelPackage.SHEET__NUMBER_OF_ROWS:
				setNumberOfRows(NUMBER_OF_ROWS_EDEFAULT);
				return;
			case JaxelPackage.SHEET__NUMBER_OF_COLUMNS:
				setNumberOfColumns(NUMBER_OF_COLUMNS_EDEFAULT);
				return;
			case JaxelPackage.SHEET__ROWS:
				getRows().clear();
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
			case JaxelPackage.SHEET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JaxelPackage.SHEET__NUMBER_OF_ROWS:
				return numberOfRows != NUMBER_OF_ROWS_EDEFAULT;
			case JaxelPackage.SHEET__NUMBER_OF_COLUMNS:
				return numberOfColumns != NUMBER_OF_COLUMNS_EDEFAULT;
			case JaxelPackage.SHEET__ROWS:
				return rows != null && !rows.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", numberOfRows: ");
		result.append(numberOfRows);
		result.append(", numberOfColumns: ");
		result.append(numberOfColumns);
		result.append(')');
		return result.toString();
	}

} //SheetImpl
