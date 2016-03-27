/**
 */
package  pt.iul.iscte.dcti.pa.jaxel;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.Row#getColumns <em>Columns</em>}</li>
 * </ul>
 * </p>
 *
 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage#getRow()
 * @model
 * @generated
 */
public interface Row extends EObject {
	/**
	 * Returns the value of the '<em><b>Columns</b></em>' map.
	 * The key is of type {@link java.lang.Integer},
	 * and the value is of type {@link  pt.iul.iscte.dcti.pa.jaxel.CellColumn},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' map.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage#getRow_Columns()
	 * @model mapType=" pt.iul.iscte.dcti.pa.jaxel.EIntegerObjectToCellColumnMap<org.eclipse.emf.ecore.EIntegerObject,  pt.iul.iscte.dcti.pa.jaxel.CellColumn>"
	 * @generated
	 */
	EMap<Integer,  CellColumn> getColumns();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return \"Number of filled columns: \"+columns.size();'"
	 * @generated
	 */
	String toString();

} // Row
