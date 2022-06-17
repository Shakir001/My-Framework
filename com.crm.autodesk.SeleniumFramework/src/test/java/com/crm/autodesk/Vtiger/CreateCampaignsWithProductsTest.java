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

public class CreateCampaignsWithProductsTest {
	public static void main(String[] args) throws Throwable {
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		
		/*get random data*/
		int randomNum=jLib.getRandomNum();
		
		
		//Read common data from Properties File
		String BROWSER=fLib.getPropertyKeyValue("browser");
		String URL=fLib.getPropertyKeyValue("url");
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");
		
		System.out.println("browser is: "+BROWSER);
		System.out.println("url is: "+URL);
		System.out.println("username is: "+USERNAME);
		System.out.println("password is: "+PASSWORD);	
		
		//Read the test data from Excel File
		String productName=eLib.getExcelData("Sheet1", 1, 1)+randomNum;
		String campName=eLib.getExcelData("Sheet1", 1, 3)+randomNum;
		
			
		//Launch Browser
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
		
		//Login to app
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*Navigate to products*/
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productName);
		
		/*Select start date*/
		String date=jLib.getSystemDateWithFormat();
		driver.findElement(By.xpath("//input[@name='start_date']")).sendKeys(date);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*verify*/
		String headerMsg=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(headerMsg.contains(productName))
		{
			System.out.println(productName+" is verified=====>Pass");
		}
		else
		{
			System.out.println(productName+" is not verified=====>Fail");
		}
		
		/*Navigate to campaigns*/
		WebElement user=driver.findElement(By.linkText("More"));
		wLib.mouseOverOnElement(driver, user);
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campName);
		driver.findElement(By.xpath("//input[@name='product_name']/parent::td/child::img")).click();
		
		/*switch to child window*/
		wLib.switchToWindow(driver, "Products");
		driver.findElement(By.name("search_text")).sendKeys(productName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		
		/*switch to main window*/
		wLib.switchToWindow(driver, "Campaigns");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*verify*/
		String headerMsg1=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerMsg1.contains(campName))
		{
			System.out.println(campName+" is verified=======>Pass");
		}
		else
		{
			System.out.println(campName+" is not verified======>Fail");
		}
		
		/*Logout*/
        wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img")));
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
	}
}








