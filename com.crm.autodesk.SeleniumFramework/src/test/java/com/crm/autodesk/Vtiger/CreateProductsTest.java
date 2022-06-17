package com.crm.autodesk.Vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.GenericUtility.ExcelUtility;
import com.crm.autodesk.GenericUtility.FileUtility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductsTest {
	public static void main(String[] args) throws Throwable {
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		int randomNum=jLib.getRandomNum();
		
		/*get common data from properties file*/
		String BROWSER=fLib.getPropertyKeyValue("browser");
		String URL=fLib.getPropertyKeyValue("url");
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");
		
		System.out.println("browser is: "+BROWSER);
		System.out.println("url is: "+URL);
		System.out.println("username is: "+USERNAME);
		System.out.println("password is: "+PASSWORD);
		
		/*get data from excel file*/
		String productName=eLib.getExcelData("Sheet1", 1, 1)+"-"+randomNum;
		
		/*Launch browser*/
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("launched browser is: "+BROWSER);
		}
		else if(BROWSER.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("launched browser is: "+BROWSER);
		}
		else if(BROWSER.equals("edge"))
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
		
		/*Login*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*Navigate to product*/
		driver.findElement(By.linkText("Products")).click();
		
		/*Navigate to create product*/
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		/*create new product*/
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName);
		
		/*Select start date*/
		String date=jLib.getSystemDateWithFormat();
		driver.findElement(By.xpath("//input[@name='start_date']")).sendKeys(date);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*verify*/
		String headerMsg=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(headerMsg.contains(productName))
		{
			System.out.println(productName+" is verified======>Pass");
		}
		else
		{
			System.out.println(productName+" is not verified======>Fail");
		}
		/*sign out*/
		WebElement user=driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
		wLib.mouseOverOnElement(driver, user);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}







