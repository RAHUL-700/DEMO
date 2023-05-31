package com.Twinlite.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * this class is used to get property file data
 * @author satya
 *
 */
public class FileUtilities {
/**
 * this method is used to fetch data from the property files
 * @param key
 * @return
 * @throws IOException
 */
	public String getPropertyKeyValue(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream(IPATHConstants.propertyfilepath);
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
		return data;
	}
}
