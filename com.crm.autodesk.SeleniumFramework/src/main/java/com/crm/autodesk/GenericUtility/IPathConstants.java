package com.crm.autodesk.GenericUtility;
/**
 * All the constant value and paths are stored in this interface
 * @author Shakir
 *
 */

public interface IPathConstants {

	public String PROPERTYFILE_PATH="./src/test/resources/commonData/credential.properties";
	public String EXCEL_PATH="./src/test/resources/TestData.xlsx";
	
	public String CHROME_KEY="webdriver.chrome.driver";
	public String CHROME_VALUE="./src/main/resources/chromedriver.exe";
	
	public String FIREFOX_KEY="webdriver.gecko.driver";
	public String FIREFOX_VALUE="./src/main/resources/geckodriver.exe";
	
	public String DATABASE_URL="jdbc:mysql://localhost:3306/projects";
	public String DATABASE_USERNAME="admin";
	public String DATABASE_PASSWORD="root";
	
	public int ITO=20;
}
