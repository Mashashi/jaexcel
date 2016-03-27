/**
 */
package  pt.iul.iscte.dcti.pa.jaxel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface JaxelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "jaxel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://jaxel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jaxel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JaxelPackage eINSTANCE =  pt.iul.iscte.dcti.pa.jaxel.impl.JaxelPackageImpl.init();

	/**
	 * The meta object id for the '{@link  pt.iul.iscte.dcti.pa.jaxel.impl.SheetImpl <em>Sheet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.SheetImpl
	 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.JaxelPackageImpl#getSheet()
	 * @generated
	 */
	int SHEET = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHEET__NAME = 0;

	/**
	 * The feature id for the '<em><b>Number Of Rows</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHEET__NUMBER_OF_ROWS = 1;

	/**
	 * The feature id for the '<em><b>Number Of Columns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHEET__NUMBER_OF_COLUMNS = 2;

	/**
	 * The feature id for the '<em><b>Rows</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHEET__ROWS = 3;

	/**
	 * The number of structural features of the '<em>Sheet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHEET_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link  pt.iul.iscte.dcti.pa.jaxel.impl.DocumentImpl <em>Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.DocumentImpl
	 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.JaxelPackageImpl#getDocument()
	 * @generated
	 */
	int DOCUMENT = 1;

	/**
	 * The feature id for the '<em><b>Sheet file</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__SHEET_FILE = 0;

	/**
	 * The feature id for the '<em><b>Bin Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__BIN_FOLDER = 1;

	/**
	 * The number of structural features of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link  pt.iul.iscte.dcti.pa.jaxel.impl.RowImpl <em>Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.RowImpl
	 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.JaxelPackageImpl#getRow()
	 * @generated
	 */
	int ROW = 2;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__COLUMNS = 0;

	/**
	 * The number of structural features of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link  pt.iul.iscte.dcti.pa.jaxel.impl.CellColumnImpl <em>Cell Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.CellColumnImpl
	 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.JaxelPackageImpl#getCellColumn()
	 * @generated
	 */
	int CELL_COLUMN = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_COLUMN__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_COLUMN__RESULT = 1;

	/**
	 * The number of structural features of the '<em>Cell Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_COLUMN_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link  pt.iul.iscte.dcti.pa.jaxel.impl.EIntegerObjectToCellColumnMapImpl <em>EInteger Object To Cell Column Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.EIntegerObjectToCellColumnMapImpl
	 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.JaxelPackageImpl#getEIntegerObjectToCellColumnMap()
	 * @generated
	 */
	int EINTEGER_OBJECT_TO_CELL_COLUMN_MAP = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EINTEGER_OBJECT_TO_CELL_COLUMN_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EINTEGER_OBJECT_TO_CELL_COLUMN_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EInteger Object To Cell Column Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EINTEGER_OBJECT_TO_CELL_COLUMN_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link  pt.iul.iscte.dcti.pa.jaxel.impl.EIntegerObjectToRowMapImpl <em>EInteger Object To Row Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.EIntegerObjectToRowMapImpl
	 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.JaxelPackageImpl#getEIntegerObjectToRowMap()
	 * @generated
	 */
	int EINTEGER_OBJECT_TO_ROW_MAP = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EINTEGER_OBJECT_TO_ROW_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EINTEGER_OBJECT_TO_ROW_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EInteger Object To Row Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EINTEGER_OBJECT_TO_ROW_MAP_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link  pt.iul.iscte.dcti.pa.jaxel.Sheet <em>Sheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sheet</em>'.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.Sheet
	 * @generated
	 */
	EClass getSheet();

	/**
	 * Returns the meta object for the attribute '{@link  pt.iul.iscte.dcti.pa.jaxel.Sheet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.Sheet#getName()
	 * @see #getSheet()
	 * @generated
	 */
	EAttribute getSheet_Name();

	/**
	 * Returns the meta object for the attribute '{@link  pt.iul.iscte.dcti.pa.jaxel.Sheet#getNumberOfRows <em>Number Of Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Rows</em>'.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.Sheet#getNumberOfRows()
	 * @see #getSheet()
	 * @generated
	 */
	EAttribute getSheet_NumberOfRows();

	/**
	 * Returns the meta object for the attribute '{@link  pt.iul.iscte.dcti.pa.jaxel.Sheet#getNumberOfColumns <em>Number Of Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Columns</em>'.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.Sheet#getNumberOfColumns()
	 * @see #getSheet()
	 * @generated
	 */
	EAttribute getSheet_NumberOfColumns();

	/**
	 * Returns the meta object for the map '{@link  pt.iul.iscte.dcti.pa.jaxel.Sheet#getRows <em>Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Rows</em>'.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.Sheet#getRows()
	 * @see #getSheet()
	 * @generated
	 */
	EReference getSheet_Rows();

	/**
	 * Returns the meta object for class '{@link  pt.iul.iscte.dcti.pa.jaxel.Document <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document</em>'.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.Document
	 * @generated
	 */
	EClass getDocument();

	/**
	 * Returns the meta object for the containment reference list '{@link  pt.iul.iscte.dcti.pa.jaxel.Document#getSheet_file <em>Sheet file</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sheet file</em>'.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.Document#getSheet_file()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Sheet_file();

	/**
	 * Returns the meta object for the attribute '{@link  pt.iul.iscte.dcti.pa.jaxel.Document#getBinFolder <em>Bin Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bin Folder</em>'.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.Document#getBinFolder()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_BinFolder();

	/**
	 * Returns the meta object for class '{@link  pt.iul.iscte.dcti.pa.jaxel.Row <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row</em>'.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.Row
	 * @generated
	 */
	EClass getRow();

	/**
	 * Returns the meta object for the map '{@link  pt.iul.iscte.dcti.pa.jaxel.Row#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Columns</em>'.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.Row#getColumns()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Columns();

	/**
	 * Returns the meta object for class '{@link  pt.iul.iscte.dcti.pa.jaxel.CellColumn <em>Cell Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cell Column</em>'.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.CellColumn
	 * @generated
	 */
	EClass getCellColumn();

	/**
	 * Returns the meta object for the attribute '{@link  pt.iul.iscte.dcti.pa.jaxel.CellColumn#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.CellColumn#getValue()
	 * @see #getCellColumn()
	 * @generated
	 */
	EAttribute getCellColumn_Value();

	/**
	 * Returns the meta object for the attribute '{@link  pt.iul.iscte.dcti.pa.jaxel.CellColumn#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.CellColumn#getResult()
	 * @see #getCellColumn()
	 * @generated
	 */
	EAttribute getCellColumn_Result();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EInteger Object To Cell Column Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EInteger Object To Cell Column Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EIntegerObject"
	 *        valueType=" pt.iul.iscte.dcti.pa.jaxel.CellColumn" valueContainment="true" valueRequired="true"
	 * @generated
	 */
	EClass getEIntegerObjectToCellColumnMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEIntegerObjectToCellColumnMap()
	 * @generated
	 */
	EAttribute getEIntegerObjectToCellColumnMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEIntegerObjectToCellColumnMap()
	 * @generated
	 */
	EReference getEIntegerObjectToCellColumnMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EInteger Object To Row Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EInteger Object To Row Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EIntegerObject"
	 *        valueType=" pt.iul.iscte.dcti.pa.jaxel.Row" valueContainment="true" valueRequired="true"
	 * @generated
	 */
	EClass getEIntegerObjectToRowMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEIntegerObjectToRowMap()
	 * @generated
	 */
	EAttribute getEIntegerObjectToRowMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEIntegerObjectToRowMap()
	 * @generated
	 */
	EReference getEIntegerObjectToRowMap_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JaxelFactory getJaxelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link  pt.iul.iscte.dcti.pa.jaxel.impl.SheetImpl <em>Sheet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.SheetImpl
		 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.JaxelPackageImpl#getSheet()
		 * @generated
		 */
		EClass SHEET = eINSTANCE.getSheet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHEET__NAME = eINSTANCE.getSheet_Name();

		/**
		 * The meta object literal for the '<em><b>Number Of Rows</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHEET__NUMBER_OF_ROWS = eINSTANCE.getSheet_NumberOfRows();

		/**
		 * The meta object literal for the '<em><b>Number Of Columns</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHEET__NUMBER_OF_COLUMNS = eINSTANCE.getSheet_NumberOfColumns();

		/**
		 * The meta object literal for the '<em><b>Rows</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHEET__ROWS = eINSTANCE.getSheet_Rows();

		/**
		 * The meta object literal for the '{@link  pt.iul.iscte.dcti.pa.jaxel.impl.DocumentImpl <em>Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.DocumentImpl
		 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.JaxelPackageImpl#getDocument()
		 * @generated
		 */
		EClass DOCUMENT = eINSTANCE.getDocument();

		/**
		 * The meta object literal for the '<em><b>Sheet file</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__SHEET_FILE = eINSTANCE.getDocument_Sheet_file();

		/**
		 * The meta object literal for the '<em><b>Bin Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT__BIN_FOLDER = eINSTANCE.getDocument_BinFolder();

		/**
		 * The meta object literal for the '{@link  pt.iul.iscte.dcti.pa.jaxel.impl.RowImpl <em>Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.RowImpl
		 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.JaxelPackageImpl#getRow()
		 * @generated
		 */
		EClass ROW = eINSTANCE.getRow();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROW__COLUMNS = eINSTANCE.getRow_Columns();

		/**
		 * The meta object literal for the '{@link  pt.iul.iscte.dcti.pa.jaxel.impl.CellColumnImpl <em>Cell Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.CellColumnImpl
		 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.JaxelPackageImpl#getCellColumn()
		 * @generated
		 */
		EClass CELL_COLUMN = eINSTANCE.getCellColumn();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CELL_COLUMN__VALUE = eINSTANCE.getCellColumn_Value();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CELL_COLUMN__RESULT = eINSTANCE.getCellColumn_Result();

		/**
		 * The meta object literal for the '{@link  pt.iul.iscte.dcti.pa.jaxel.impl.EIntegerObjectToCellColumnMapImpl <em>EInteger Object To Cell Column Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.EIntegerObjectToCellColumnMapImpl
		 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.JaxelPackageImpl#getEIntegerObjectToCellColumnMap()
		 * @generated
		 */
		EClass EINTEGER_OBJECT_TO_CELL_COLUMN_MAP = eINSTANCE.getEIntegerObjectToCellColumnMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EINTEGER_OBJECT_TO_CELL_COLUMN_MAP__KEY = eINSTANCE.getEIntegerObjectToCellColumnMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EINTEGER_OBJECT_TO_CELL_COLUMN_MAP__VALUE = eINSTANCE.getEIntegerObjectToCellColumnMap_Value();

		/**
		 * The meta object literal for the '{@link  pt.iul.iscte.dcti.pa.jaxel.impl.EIntegerObjectToRowMapImpl <em>EInteger Object To Row Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.EIntegerObjectToRowMapImpl
		 * @see  pt.iul.iscte.dcti.pa.jaxel.impl.JaxelPackageImpl#getEIntegerObjectToRowMap()
		 * @generated
		 */
		EClass EINTEGER_OBJECT_TO_ROW_MAP = eINSTANCE.getEIntegerObjectToRowMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EINTEGER_OBJECT_TO_ROW_MAP__KEY = eINSTANCE.getEIntegerObjectToRowMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EINTEGER_OBJECT_TO_ROW_MAP__VALUE = eINSTANCE.getEIntegerObjectToRowMap_Value();

	}

} //JaxelPackage
