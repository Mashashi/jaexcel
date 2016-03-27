/**
 */
package  pt.iul.iscte.dcti.pa.jaxel;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sheet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.Sheet#getName <em>Name</em>}</li>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.Sheet#getNumberOfRows <em>Number Of Rows</em>}</li>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.Sheet#getNumberOfColumns <em>Number Of Columns</em>}</li>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.Sheet#getRows <em>Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage#getSheet()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NumberOfRowsEqualOrGreaterThanZero NumberOfColumnsEqualOrGreaterThanZero NumberOfRowsEqualOrSmallerToTheIndicated NumberOfColumnsEqualOrSmallerToTheIndicated NumberOfRowsEqualOrGreaterThanZero NumberOfColumnsEqualOrGreaterThanZero NumberOfRowsEqualOrSmallerToTheIndicated NumberOfColumnsEqualOrSmallerToTheIndicated'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot NumberOfRowsEqualOrGreaterThanZero='self.numberOfRows >= 0' NumberOfColumnsEqualOrGreaterThanZero='self.numberOfColumns >= 0' NumberOfRowsEqualOrSmallerToTheIndicated='self.row_sheet->size() <= self.numberOfRows' NumberOfColumnsEqualOrSmallerToTheIndicated='self.row_sheet.columns->forAll(map : EIntegerObjectToCellColumnMap | map.key <= numberOfColumns)'"
 * @generated
 */
public interface Sheet extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage#getSheet_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link  pt.iul.iscte.dcti.pa.jaxel.Sheet#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Number Of Rows</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Rows</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Rows</em>' attribute.
	 * @see #setNumberOfRows(int)
	 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage#getSheet_NumberOfRows()
	 * @model
	 * @generated
	 */
	int getNumberOfRows();

	/**
	 * Sets the value of the '{@link  pt.iul.iscte.dcti.pa.jaxel.Sheet#getNumberOfRows <em>Number Of Rows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Rows</em>' attribute.
	 * @see #getNumberOfRows()
	 * @generated
	 */
	void setNumberOfRows(int value);

	/**
	 * Returns the value of the '<em><b>Number Of Columns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Columns</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Columns</em>' attribute.
	 * @see #setNumberOfColumns(int)
	 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage#getSheet_NumberOfColumns()
	 * @model
	 * @generated
	 */
	int getNumberOfColumns();

	/**
	 * Sets the value of the '{@link  pt.iul.iscte.dcti.pa.jaxel.Sheet#getNumberOfColumns <em>Number Of Columns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Columns</em>' attribute.
	 * @see #getNumberOfColumns()
	 * @generated
	 */
	void setNumberOfColumns(int value);

	/**
	 * Returns the value of the '<em><b>Rows</b></em>' map.
	 * The key is of type {@link java.lang.Integer},
	 * and the value is of type {@link  pt.iul.iscte.dcti.pa.jaxel.Row},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rows</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rows</em>' map.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage#getSheet_Rows()
	 * @model mapType=" pt.iul.iscte.dcti.pa.jaxel.EIntegerObjectToRowMap<org.eclipse.emf.ecore.EIntegerObject,  pt.iul.iscte.dcti.pa.jaxel.Row>"
	 * @generated
	 */
	EMap<Integer,  Row> getRows();

} // Sheet
