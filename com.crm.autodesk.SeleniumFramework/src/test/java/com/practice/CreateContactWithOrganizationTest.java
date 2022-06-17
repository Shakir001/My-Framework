package com.practice;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganizationTest {
	public static void main(String[] args) throws Throwable {
		//Read common data from Properties File
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData/credential.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		
		System.out.println("browser is: "+browser);
		System.out.println("url is: "+url);
		System.out.println("username is: "+username);
		System.out.println("password is: "+password);	
		
		Random r=new Random();
		int ranNum=r.nextInt(1000);
		
		//Read the test data from Excel File
		FileInputStream fil=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book=WorkbookFactory.create(fil);
		Sheet sh=book.getSheet("Contacts");
		String orgName=sh.getRow(1).getCell(4).getStringCellValue()+"_"+ranNum;
		String lastName=sh.getRow(1).getCell(2).getStringCellValue()+"_"+ranNum;
		
		//Launch Browser
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("launched browser is: "+browser);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("launched browser is: "+browser);
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("launched browser is: "+browser);
		}
		else
		{
			System.out.println("pls specify valid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		driver.get(url);
		
		//Login to app
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();	
		
		//Navigate to Organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//Navigate to create organization page
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Create a new organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Verify
		String headerMsg=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerMsg.contains(orgName))
		{
			System.out.println(orgName+" is verified=====>Pass");
		}
		else
		{
			System.out.println(orgName+" is not verified=====>Fail");
		}
		//Explicit Wait
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Contacts"))));
		
		//Navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Navigate to create contact page
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//create a new contact
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//Capture all window ID
		Set<String> allId=driver.getWindowHandles();
		
		Iterator<String> it=allId.iterator();
		while(it.hasNext())
		{
			String window_id=it.next();
			driver.switchTo().window(window_id);
			if(driver.getTitle().contains("Accounts"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		Set<String> allId1=driver.getWindowHandles();
		Iterator<String> it1=allId1.iterator();
		while(it1.hasNext())
		{
			String window_id=it1.next();
			driver.switchTo().window(window_id);
			if(driver.getTitle().contains("Contacts"))
			{
				break;
			}
		}
		
//		//Switch to child window
//		String mainId=driver.getWindowHandle();
//		Set<String> allId=driver.getWindowHandles();
//		for(String id:allId)
//		{
//			if(!mainId.equals(id))
//			{
//				driver.switchTo().window(id);
//			}
//		}
//		driver.findElement(By.id("search_txt")).sendKeys(orgName);
//		driver.findElement(By.name("search")).click();
//		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
//		
//		//Switch to main window
//		driver.switchTo().window(mainId);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String headerMsg1=driver.findElement(By.className("dvHeaderText")).getText();
		if(headerMsg1.contains(lastName))
		{
			System.out.println(lastName+" is verified====>Pass");
		}
		else
		{
			System.out.println(lastName+" is not verified====>Fail");
		}
		
		//Logout
		WebElement user=driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
		Actions act=new Actions(driver);
		act.moveToElement(user).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	
}




