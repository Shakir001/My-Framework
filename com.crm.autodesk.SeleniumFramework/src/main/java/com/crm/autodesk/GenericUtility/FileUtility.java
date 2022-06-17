package com.crm.autodesk.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author Shakir
 *
 */

public class FileUtility {
	/**
	 * It is used to read the data from commonData credential.properties file based on key which you pass as an argument
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.PROPERTYFILE_PATH);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
}
