package com.crm.autodesk.Vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.GenericUtility.ExcelUtility;
import com.crm.autodesk.GenericUtility.FileUtility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationsTest {
	public static void main(String[] args) throws Throwable {
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		
		/*get random data*/
		int randomNum=jLib.getRandomNum();
		
		
		/*Read common data from Properties File*/
		String BROWSER=fLib.getPropertyKeyValue("browser");
		String URL=fLib.getPropertyKeyValue("url");
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");
		
		System.out.println("browser is: "+BROWSER);
		System.out.println("url is: "+URL);
		System.out.println("username is: "+USERNAME);
		System.out.println("password is: "+PASSWORD);	
		
		/*Read the test data from Excel File*/
		String orgName=eLib.getExcelData("Sheet1", 1, 4)+randomNum;
		
		/*Launch Browser*/
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("launched browser is: "+BROWSER);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("launched browser is: "+BROWSER);
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("launched browser is: "+BROWSER);
		}
		else
		{
			System.out.println("pls specify valid browser");
		}
		wLib.getWindowMaximize(driver);
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		
		/*Login to app*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();	
		
		/*Navigate to Organization*/
		driver.findElement(By.linkText("Organizations")).click();
		
		/*click on create organization page*/
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		/*Create a new organization*/
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Verify*/
		String headerMsg=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerMsg.contains(orgName))
		{
			System.out.println(orgName+" is verified=====>Pass");
		}
		else
		{
			System.out.println(orgName+" is not verified=====>Fail");
		}
		
		/*Logout*/
		wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
