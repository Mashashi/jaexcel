package pt.iul.iscte.dcti.pa.jaxel;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.HashMultimap;

public class DynamicMethodGetter{
	
	private File path;
	private ClassLoader parent;
	public Set<Entry<Class<?>, Method>> methodsRead;
	
	public DynamicMethodGetter(ClassLoader parent, File path) {
		this.path = path;
		this.parent = parent;
	}

	private List<Class<?>> getAllCompiledClasses(File path, String pakkage){
		List<Class<?>> list = new LinkedList<Class<?>>();
		
		for(File file: path.listFiles()){
			try {
				//So classes that belongs to a certain package can be read
				if(file.isDirectory()){
					list.addAll(getAllCompiledClasses(file, pakkage+"."+file.getName()));
				}else{
					if(file.toString().endsWith(".class")){
						String clazz = pakkage.substring(1)+"."+file.getName().substring(0, file.getName().indexOf("."));
						list.add(new CustomClassLoader(parent, file).loadClass(clazz));
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public Set<Entry<Class<?>, Method>> getAllValidMethods(){
		HashMultimap<Class<?>, Method> methods = HashMultimap.create();
		for(Class<?> clazz: getAllCompiledClasses(path, "")){
			for (Method method: clazz.getMethods()){ //Only public methods
				Class<?> returns = method.getReturnType();
				if( returns.equals(Double.class) ||  returns.equals(Integer.class)){ //Only methods witch return Double or INteger
					if(Modifier.isStatic(method.getModifiers())){ // Only static methods
						methods.put(clazz, method);
					}
				}
				
			}
		}
		
		methodsRead = methods.entries();
		return methodsRead;
	}
	
}
