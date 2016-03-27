package pt.iul.iscte.dcti.pa.jaxel;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

public class FileOperations {
	
	private final String file;
	
	
	//private static Resource.Factory.Registry registry = getXMIResourceFactory();
	public static Resource.Factory.Registry getXMIResourceFactory(){
		// Register the XMI resource factory for the .library extension globally
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("jaxel", new XMIResourceFactoryImpl());
		return reg;
	}
	
	public FileOperations(String file){
		this.file = file;
	}
	
	public void save(Document document) throws IOException{
		 ResourceSet resSet = new ResourceSetImpl();
		 Resource resource = resSet.createResource(URI.createURI(file));
		 resource.getContents().add(EcoreUtil.copy(document));
		 // Now save the content
	     resource.save(Collections.EMPTY_MAP);
	}
	
	public Document load() {
		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();
		// Get the resource
		Resource resource = resSet.getResource(URI.createURI(file), true);
		// Get the first model element and cast it to the right type
		return (Document) resource.getContents().get(0);
	}
	
	public static void print(EObject eobject){
		 Resource resource = new XMLResourceImpl ();
		 // EcoreUtil.copy(eobject)
		 resource.getContents().add(EcoreUtil.copy(eobject));
		 // Now save the content
	    try {
	      resource.save(System.out, null);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
}
