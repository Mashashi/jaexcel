/**
 */
package  pt.iul.iscte.dcti.pa.jaxel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cell Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.CellColumn#getValue <em>Value</em>}</li>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.CellColumn#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage#getCellColumn()
 * @model
 * @generated
 */
public interface CellColumn extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage#getCellColumn_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link  pt.iul.iscte.dcti.pa.jaxel.CellColumn#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute.
	 * @see #setResult(String)
	 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage#getCellColumn_Result()
	 * @model
	 * @generated
	 */
	String getResult();

	/**
	 * Sets the value of the '{@link  pt.iul.iscte.dcti.pa.jaxel.CellColumn#getResult <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' attribute.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(String value);

} // CellColumn
