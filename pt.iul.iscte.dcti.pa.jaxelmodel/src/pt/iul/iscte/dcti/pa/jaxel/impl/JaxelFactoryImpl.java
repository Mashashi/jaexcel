/**
 */
package  pt.iul.iscte.dcti.pa.jaxel.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pt.iul.iscte.dcti.pa.jaxel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JaxelFactoryImpl extends EFactoryImpl implements JaxelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JaxelFactory init() {
		try {
			JaxelFactory theJaxelFactory = (JaxelFactory)EPackage.Registry.INSTANCE.getEFactory("http://jaxel/1.0"); 
			if (theJaxelFactory != null) {
				return theJaxelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JaxelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JaxelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case JaxelPackage.SHEET: return createSheet();
			case JaxelPackage.DOCUMENT: return createDocument();
			case JaxelPackage.ROW: return createRow();
			case JaxelPackage.CELL_COLUMN: return createCellColumn();
			case JaxelPackage.EINTEGER_OBJECT_TO_CELL_COLUMN_MAP: return (EObject)createEIntegerObjectToCellColumnMap();
			case JaxelPackage.EINTEGER_OBJECT_TO_ROW_MAP: return (EObject)createEIntegerObjectToRowMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sheet createSheet() {
		SheetImpl sheet = new SheetImpl();
		return sheet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Document createDocument() {
		DocumentImpl document = new DocumentImpl();
		return document;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Row createRow() {
		RowImpl row = new RowImpl();
		return row;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CellColumn createCellColumn() {
		CellColumnImpl cellColumn = new CellColumnImpl();
		return cellColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Integer, CellColumn> createEIntegerObjectToCellColumnMap() {
		EIntegerObjectToCellColumnMapImpl eIntegerObjectToCellColumnMap = new EIntegerObjectToCellColumnMapImpl();
		return eIntegerObjectToCellColumnMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Integer, Row> createEIntegerObjectToRowMap() {
		EIntegerObjectToRowMapImpl eIntegerObjectToRowMap = new EIntegerObjectToRowMapImpl();
		return eIntegerObjectToRowMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JaxelPackage getJaxelPackage() {
		return (JaxelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JaxelPackage getPackage() {
		return JaxelPackage.eINSTANCE;
	}

} //JaxelFactoryImpl
