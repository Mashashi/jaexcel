/**
 */
package  pt.iul.iscte.dcti.pa.jaxel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.Document#getSheet_file <em>Sheet file</em>}</li>
 *   <li>{@link  pt.iul.iscte.dcti.pa.jaxel.Document#getBinFolder <em>Bin Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage#getDocument()
 * @model
 * @generated
 */
public interface Document extends EObject {
	/**
	 * Returns the value of the '<em><b>Sheet file</b></em>' containment reference list.
	 * The list contents are of type {@link  pt.iul.iscte.dcti.pa.jaxel.Sheet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sheet file</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sheet file</em>' containment reference list.
	 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage#getDocument_Sheet_file()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList< Sheet> getSheet_file();

	/**
	 * Returns the value of the '<em><b>Bin Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bin Folder</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bin Folder</em>' attribute.
	 * @see #setBinFolder(String)
	 * @see  pt.iul.iscte.dcti.pa.jaxel.JaxelPackage#getDocument_BinFolder()
	 * @model
	 * @generated
	 */
	String getBinFolder();

	/**
	 * Sets the value of the '{@link  pt.iul.iscte.dcti.pa.jaxel.Document#getBinFolder <em>Bin Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bin Folder</em>' attribute.
	 * @see #getBinFolder()
	 * @generated
	 */
	void setBinFolder(String value);

} // Document
