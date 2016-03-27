/**
 */
package  pt.iul.iscte.dcti.pa.jaxel.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import pt.iul.iscte.dcti.pa.jaxel.CellColumn;
import pt.iul.iscte.dcti.pa.jaxel.Document;
import pt.iul.iscte.dcti.pa.jaxel.JaxelFactory;
import pt.iul.iscte.dcti.pa.jaxel.JaxelPackage;
import pt.iul.iscte.dcti.pa.jaxel.Row;
import pt.iul.iscte.dcti.pa.jaxel.Sheet;

import pt.iul.iscte.dcti.pa.jaxel.util.JaxelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JaxelPackageImpl extends EPackageImpl implements JaxelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sheetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cellColumnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eIntegerObjectToCellColumnMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eIntegerObjectToRowMapEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JaxelPackageImpl() {
		super(eNS_URI, JaxelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link JaxelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JaxelPackage init() {
		if (isInited) return (JaxelPackage)EPackage.Registry.INSTANCE.getEPackage(JaxelPackage.eNS_URI);

		// Obtain or create and register package
		JaxelPackageImpl theJaxelPackage = (JaxelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JaxelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JaxelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theJaxelPackage.createPackageContents();

		// Initialize created meta-data
		theJaxelPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theJaxelPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return JaxelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theJaxelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JaxelPackage.eNS_URI, theJaxelPackage);
		return theJaxelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSheet() {
		return sheetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSheet_Name() {
		return (EAttribute)sheetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSheet_NumberOfRows() {
		return (EAttribute)sheetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSheet_NumberOfColumns() {
		return (EAttribute)sheetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSheet_Rows() {
		return (EReference)sheetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocument() {
		return documentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocument_Sheet_file() {
		return (EReference)documentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocument_BinFolder() {
		return (EAttribute)documentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRow() {
		return rowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRow_Columns() {
		return (EReference)rowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCellColumn() {
		return cellColumnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCellColumn_Value() {
		return (EAttribute)cellColumnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCellColumn_Result() {
		return (EAttribute)cellColumnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEIntegerObjectToCellColumnMap() {
		return eIntegerObjectToCellColumnMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEIntegerObjectToCellColumnMap_Key() {
		return (EAttribute)eIntegerObjectToCellColumnMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEIntegerObjectToCellColumnMap_Value() {
		return (EReference)eIntegerObjectToCellColumnMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEIntegerObjectToRowMap() {
		return eIntegerObjectToRowMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEIntegerObjectToRowMap_Key() {
		return (EAttribute)eIntegerObjectToRowMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEIntegerObjectToRowMap_Value() {
		return (EReference)eIntegerObjectToRowMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JaxelFactory getJaxelFactory() {
		return (JaxelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		sheetEClass = createEClass(SHEET);
		createEAttribute(sheetEClass, SHEET__NAME);
		createEAttribute(sheetEClass, SHEET__NUMBER_OF_ROWS);
		createEAttribute(sheetEClass, SHEET__NUMBER_OF_COLUMNS);
		createEReference(sheetEClass, SHEET__ROWS);

		documentEClass = createEClass(DOCUMENT);
		createEReference(documentEClass, DOCUMENT__SHEET_FILE);
		createEAttribute(documentEClass, DOCUMENT__BIN_FOLDER);

		rowEClass = createEClass(ROW);
		createEReference(rowEClass, ROW__COLUMNS);

		cellColumnEClass = createEClass(CELL_COLUMN);
		createEAttribute(cellColumnEClass, CELL_COLUMN__VALUE);
		createEAttribute(cellColumnEClass, CELL_COLUMN__RESULT);

		eIntegerObjectToCellColumnMapEClass = createEClass(EINTEGER_OBJECT_TO_CELL_COLUMN_MAP);
		createEAttribute(eIntegerObjectToCellColumnMapEClass, EINTEGER_OBJECT_TO_CELL_COLUMN_MAP__KEY);
		createEReference(eIntegerObjectToCellColumnMapEClass, EINTEGER_OBJECT_TO_CELL_COLUMN_MAP__VALUE);

		eIntegerObjectToRowMapEClass = createEClass(EINTEGER_OBJECT_TO_ROW_MAP);
		createEAttribute(eIntegerObjectToRowMapEClass, EINTEGER_OBJECT_TO_ROW_MAP__KEY);
		createEReference(eIntegerObjectToRowMapEClass, EINTEGER_OBJECT_TO_ROW_MAP__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(sheetEClass, Sheet.class, "Sheet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSheet_Name(), ecorePackage.getEString(), "name", null, 0, 1, Sheet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSheet_NumberOfRows(), ecorePackage.getEInt(), "numberOfRows", null, 0, 1, Sheet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSheet_NumberOfColumns(), ecorePackage.getEInt(), "numberOfColumns", null, 0, 1, Sheet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSheet_Rows(), this.getEIntegerObjectToRowMap(), null, "rows", null, 0, -1, Sheet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentEClass, Document.class, "Document", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDocument_Sheet_file(), this.getSheet(), null, "sheet_file", null, 1, -1, Document.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocument_BinFolder(), ecorePackage.getEString(), "binFolder", null, 0, 1, Document.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rowEClass, Row.class, "Row", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRow_Columns(), this.getEIntegerObjectToCellColumnMap(), null, "columns", null, 0, -1, Row.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(rowEClass, ecorePackage.getEString(), "toString", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(cellColumnEClass, CellColumn.class, "CellColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCellColumn_Value(), ecorePackage.getEString(), "value", null, 0, 1, CellColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCellColumn_Result(), ecorePackage.getEString(), "result", null, 0, 1, CellColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eIntegerObjectToCellColumnMapEClass, Map.Entry.class, "EIntegerObjectToCellColumnMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEIntegerObjectToCellColumnMap_Key(), ecorePackage.getEIntegerObject(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEIntegerObjectToCellColumnMap_Value(), this.getCellColumn(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eIntegerObjectToRowMapEClass, Map.Entry.class, "EIntegerObjectToRowMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEIntegerObjectToRowMap_Key(), ecorePackage.getEIntegerObject(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEIntegerObjectToRowMap_Value(), this.getRow(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });		
		addAnnotation
		  (sheetEClass, 
		   source, 
		   new String[] {
			 "constraints", "NumberOfRowsEqualOrGreaterThanZero NumberOfColumnsEqualOrGreaterThanZero NumberOfRowsEqualOrSmallerToTheIndicated NumberOfColumnsEqualOrSmallerToTheIndicated NumberOfRowsEqualOrGreaterThanZero NumberOfColumnsEqualOrGreaterThanZero NumberOfRowsEqualOrSmallerToTheIndicated NumberOfColumnsEqualOrSmallerToTheIndicated"
		   });		
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";				
		addAnnotation
		  (sheetEClass, 
		   source, 
		   new String[] {
			 "NumberOfRowsEqualOrGreaterThanZero", "self.numberOfRows >= 0",
			 "NumberOfColumnsEqualOrGreaterThanZero", "self.numberOfColumns >= 0",
			 "NumberOfRowsEqualOrSmallerToTheIndicated", "self.row_sheet->size() <= self.numberOfRows",
			 "NumberOfColumnsEqualOrSmallerToTheIndicated", "self.row_sheet.columns->forAll(map : EIntegerObjectToCellColumnMap | map.key <= numberOfColumns)"
		   });	
	}

} //JaxelPackageImpl
