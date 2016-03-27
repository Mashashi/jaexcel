package pt.iul.iscte.dcti.pa.jaxel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader{

	private File path;

	public CustomClassLoader(ClassLoader parent, File path) {
		super(parent);
		if(!path.exists() || !path.isFile())
			throw new IllegalArgumentException("Path is not a file");
		
		this.path = path;
	}



	public Class<?> loadClass(String name) throws ClassNotFoundException {
		Class<?> clazz = null;
		try {
			if(name.startsWith("java.") || name.startsWith("sun.reflect")) { 
				clazz = getParent().loadClass(name);
			}
			else {		
				byte[] classData = null;
				try {
					classData = getBytesFromFile(path);
				} catch (IOException e) {					
					e.printStackTrace();
				}
				clazz = defineClass(name, classData, 0, classData.length);
			}
		}
		catch(SecurityException securityException) {
			return super.loadClass(name);
		}
		return clazz;
	}


	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);

		// Get the size of the file
		long length = file.length();

		if (length > Integer.MAX_VALUE) {
			// File is too large
		}

		// Create the byte array to hold the data
		byte[] bytes = new byte[(int)length];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
			offset += numRead;
		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			is.close();
			throw new IOException("Could not completely read file "+file.getName());
		}

		// Close the input stream and return bytes
		is.close();
		return bytes;
	}

}
