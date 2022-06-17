package com.crm.vtiger.practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
	public static void main(String[] args) throws Throwable {
		//Read the test data from Excel File
		FileInputStream fil=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book=WorkbookFactory.create(fil);
		Sheet sh=book.getSheet("Contacts");
		int rowCount=sh.getLastRowNum();
		int columnCount=sh.getRow(0).getLastCellNum();
		System.out.println("total no of row: "+rowCount);
		System.out.println("total no of column: "+columnCount);
		for(int i=0; i<=rowCount; i++)
		{
			for(int j=0; j<columnCount; j++)
			{
				Row row=sh.getRow(i);
				Cell cell=row.getCell(j);
				String data=cell.getStringCellValue();
				System.out.print(data+" ");
			}
			System.out.println();
		}
		System.out.println("======================================");
		
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
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		String lastName=sh.getRow(3).getCell(2).getStringCellValue();
		
		Random r=new Random();
		int ranNum=r.nextInt(1000);
		lastName=lastName+ranNum;
		
		System.out.println("lastName is: "+lastName);
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		String mainId=driver.getWindowHandle();
		Set<String> allId=driver.getWindowHandles();
		for(String id:allId)
		{
			if(!mainId.equals(id))
			{
				driver.switchTo().window(id);
			}
		}
		String orgName=sh.getRow(1).getCell(4).getStringCellValue();
		
		WebElement ele=driver.findElement(By.xpath("//input[@name='idlist']/following-sibling::div[1]"));
		ele.findElement(By.linkText(orgName)).click();
		
		System.out.println("Organization name is: "+orgName);
		
		driver.switchTo().window(mainId);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement user=driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
		Actions act=new Actions(driver);
		act.moveToElement(user).perform();
		driver.findElement(By.linkText("Sign Out")).click();
//		driver.quit();
	}

}

