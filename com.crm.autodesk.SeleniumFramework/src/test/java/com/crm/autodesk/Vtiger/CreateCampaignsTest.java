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

public class CreateCampaignsTest {
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
		String campName=eLib.getExcelData("Sheet1", 1, 2)+"-"+randomNum;
		String productName=eLib.getExcelData("Sheet1", 1, 1);
		
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
		
		/*Navigate to campaigns*/
		WebElement more=driver.findElement(By.linkText("More"));
		wLib.mouseOverOnElement(driver, more);
		driver.findElement(By.linkText("Campaigns")).click();
		
		/*click on create campaigns*/
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		driver.findElement(By.name("campaignname")).sendKeys(campName);
		driver.findElement(By.xpath("//input[@name='product_name']/../img")).click();
		
		/*switch to child window*/
		wLib.switchToWindow(driver, "Products");
		driver.findElement(By.name("search_text")).sendKeys(productName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		
		/*switch to main window*/
		wLib.switchToWindow(driver, "Campaigns");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		/*verify*/
		String headerMsg=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerMsg.contains(campName))
		{
			System.out.println(campName+" is verified=====>Pass");
		}
		else
		{
			System.out.println(campName+" is not verified====>Fail");
		}
		
		/*sign out*/
		WebElement user=driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
		wLib.mouseOverOnElement(driver, user);
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
	
	}	
	
}
