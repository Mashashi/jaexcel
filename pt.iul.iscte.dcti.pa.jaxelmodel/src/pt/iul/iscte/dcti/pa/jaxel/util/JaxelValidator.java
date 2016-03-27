/**
 */
package  pt.iul.iscte.dcti.pa.jaxel.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import pt.iul.iscte.dcti.pa.jaxel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage
 * @generated
 */
public class JaxelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final JaxelValidator INSTANCE = new JaxelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = " pt.iul.iscte.dcti.pa.jaxel";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JaxelValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return JaxelPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case JaxelPackage.SHEET:
				return validateSheet((Sheet)value, diagnostics, context);
			case JaxelPackage.DOCUMENT:
				return validateDocument((Document)value, diagnostics, context);
			case JaxelPackage.ROW:
				return validateRow((Row)value, diagnostics, context);
			case JaxelPackage.CELL_COLUMN:
				return validateCellColumn((CellColumn)value, diagnostics, context);
			case JaxelPackage.EINTEGER_OBJECT_TO_CELL_COLUMN_MAP:
				return validateEIntegerObjectToCellColumnMap((Map.Entry<?, ?>)value, diagnostics, context);
			case JaxelPackage.EINTEGER_OBJECT_TO_ROW_MAP:
				return validateEIntegerObjectToRowMap((Map.Entry<?, ?>)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSheet(Sheet sheet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sheet, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sheet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sheet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sheet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sheet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sheet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sheet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sheet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sheet, diagnostics, context);
		if (result || diagnostics != null) result &= validateSheet_NumberOfRowsEqualOrGreaterThanZero(sheet, diagnostics, context);
		if (result || diagnostics != null) result &= validateSheet_NumberOfColumnsEqualOrGreaterThanZero(sheet, diagnostics, context);
		if (result || diagnostics != null) result &= validateSheet_NumberOfRowsEqualOrSmallerToTheIndicated(sheet, diagnostics, context);
		if (result || diagnostics != null) result &= validateSheet_NumberOfColumnsEqualOrSmallerToTheIndicated(sheet, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the NumberOfRowsEqualOrGreaterThanZero constraint of '<em>Sheet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String SHEET__NUMBER_OF_ROWS_EQUAL_OR_GREATER_THAN_ZERO__EEXPRESSION = "self.numberOfRows >= 0";

	/**
	 * Validates the NumberOfRowsEqualOrGreaterThanZero constraint of '<em>Sheet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSheet_NumberOfRowsEqualOrGreaterThanZero(Sheet sheet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(JaxelPackage.Literals.SHEET,
				 sheet,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "NumberOfRowsEqualOrGreaterThanZero",
				 SHEET__NUMBER_OF_ROWS_EQUAL_OR_GREATER_THAN_ZERO__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the NumberOfColumnsEqualOrGreaterThanZero constraint of '<em>Sheet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String SHEET__NUMBER_OF_COLUMNS_EQUAL_OR_GREATER_THAN_ZERO__EEXPRESSION = "self.numberOfColumns >= 0";

	/**
	 * Validates the NumberOfColumnsEqualOrGreaterThanZero constraint of '<em>Sheet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSheet_NumberOfColumnsEqualOrGreaterThanZero(Sheet sheet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(JaxelPackage.Literals.SHEET,
				 sheet,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "NumberOfColumnsEqualOrGreaterThanZero",
				 SHEET__NUMBER_OF_COLUMNS_EQUAL_OR_GREATER_THAN_ZERO__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the NumberOfRowsEqualOrSmallerToTheIndicated constraint of '<em>Sheet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String SHEET__NUMBER_OF_ROWS_EQUAL_OR_SMALLER_TO_THE_INDICATED__EEXPRESSION = "self.row_sheet->size() <= self.numberOfRows";

	/**
	 * Validates the NumberOfRowsEqualOrSmallerToTheIndicated constraint of '<em>Sheet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSheet_NumberOfRowsEqualOrSmallerToTheIndicated(Sheet sheet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(JaxelPackage.Literals.SHEET,
				 sheet,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "NumberOfRowsEqualOrSmallerToTheIndicated",
				 SHEET__NUMBER_OF_ROWS_EQUAL_OR_SMALLER_TO_THE_INDICATED__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the NumberOfColumnsEqualOrSmallerToTheIndicated constraint of '<em>Sheet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String SHEET__NUMBER_OF_COLUMNS_EQUAL_OR_SMALLER_TO_THE_INDICATED__EEXPRESSION = "self.row_sheet.columns->forAll(map : EIntegerObjectToCellColumnMap | map.key <= numberOfColumns)";

	/**
	 * Validates the NumberOfColumnsEqualOrSmallerToTheIndicated constraint of '<em>Sheet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSheet_NumberOfColumnsEqualOrSmallerToTheIndicated(Sheet sheet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(JaxelPackage.Literals.SHEET,
				 sheet,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "NumberOfColumnsEqualOrSmallerToTheIndicated",
				 SHEET__NUMBER_OF_COLUMNS_EQUAL_OR_SMALLER_TO_THE_INDICATED__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDocument(Document document, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(document, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRow(Row row, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(row, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCellColumn(CellColumn cellColumn, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(cellColumn, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEIntegerObjectToCellColumnMap(Map.Entry<?, ?> eIntegerObjectToCellColumnMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)eIntegerObjectToCellColumnMap, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEIntegerObjectToRowMap(Map.Entry<?, ?> eIntegerObjectToRowMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)eIntegerObjectToRowMap, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //JaxelValidator
