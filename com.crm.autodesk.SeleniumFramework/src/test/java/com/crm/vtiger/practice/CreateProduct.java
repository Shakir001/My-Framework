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

public class CreateProduct {
	public static void main(String[] args) throws Throwable {
		FileInputStream fil=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book=WorkbookFactory.create(fil);
		Sheet sh=book.getSheet("Products");
		int rowCount=sh.getLastRowNum();
		int columnCount=sh.getRow(0).getLastCellNum();
		System.out.println("total no of row: "+rowCount);
		System.out.println("total no of column: "+columnCount);
//		for(int i=0; i<=rowCount; i++)
//		{
//			for(int j=0; j<columnCount; j++)
//			{
//				Row row=sh.getRow(i);
//				Cell cell=row.getCell(j);
//				String data=cell.getStringCellValue();
//				System.out.print(data+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("======================================");
		
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
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		String productName=sh.getRow(7).getCell(0).getStringCellValue();
		
		Random r=new Random();
		int ranNum=r.nextInt(1000);
		productName=productName+ranNum;
		
		System.out.println("productName is: "+productName);
		
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Create campaign
		WebElement more=driver.findElement(By.linkText("More"));
		Actions act=new Actions(driver);
		act.moveToElement(more).perform();
		
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		String campName=sh.getRow(7).getCell(1).getStringCellValue();
		
		int ranNum1=r.nextInt(1000);
		campName=campName+ranNum1;
		
		System.out.println("campaign name is: "+campName);
		
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campName);
		driver.findElement(By.xpath("//input[@name='product_name']/../img")).click();
		
		String mainId=driver.getWindowHandle();
		Set<String> allId=driver.getWindowHandles();
		for(String id:allId)
		{
			if(!mainId.equals(id))
			{
				driver.switchTo().window(id);
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(productName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(productName)).click();
		
		System.out.println("Product name is: "+productName);
		
		driver.switchTo().window(mainId);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement user=driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
		act.moveToElement(user).perform();
		driver.findElement(By.linkText("Sign Out")).click();
//		driver.quit();
		
	}
}
