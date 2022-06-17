package com.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateModifyAndDeleteContactUsingFlagDependsOnMethods {

	String lastName="Mahto";
	String newLastName="Gupta";
//	@Parameters("browser")
	@Test
	public void createContact() throws Throwable {
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		
		URL url=new URL("http://34.211.144.176:4444/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver=new RemoteWebDriver(url,cap);
		
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String headerMsg=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerMsg.contains(lastName))
		{
			System.out.println("last name created successfully i.e, "+lastName);
		}
		else
		{
			System.out.println("last name not created====>Fail");
		}
		
		WebElement user = driver.findElement(By.xpath("//span[text()=' Administrator']/ancestor::tbody/descendant::img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(user).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}
	
//	@Test(dependsOnMethods = "createContact")
//	public void modifyContact() throws MalformedURLException {
//		
////		WebDriverManager.chromedriver().setup();
////		WebDriver driver=new ChromeDriver();
//		
//		URL url=new URL("http://34.211.144.176:4444/wd/hub");
//		DesiredCapabilities cap=new DesiredCapabilities();
//		cap.setBrowserName("chrome");
//		cap.setPlatform(Platform.WINDOWS);
//		
//		RemoteWebDriver driver=new RemoteWebDriver(url,cap);
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("http://localhost:8888/");
//		
//		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
//		
//		driver.findElement(By.linkText("Contacts")).click();
//		for(;;) {
//		try {
//			driver.findElement(By.xpath("//a[text()='"+lastName+"']")).click();
//			break;
//		}
//		catch(Exception e) {
//			driver.findElement(By.xpath("//a[@title='Next']")).click();
//		}
//	}
//		driver.findElement(By.xpath("//input[@title='Edit [Alt+E]']")).click();
//		driver.findElement(By.xpath("//input[@name='lastname']")).clear();
//		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(newLastName);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		
//		String headerMsg=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if(headerMsg.contains(newLastName))
//		{
//			System.out.println("last name modified successfully i.e, "+newLastName);
//		}
//		else
//		{
//			System.out.println("last name not modified====>Fail");
//		}
//		
//		WebElement user = driver.findElement(By.xpath("//span[text()=' Administrator']/ancestor::tbody/descendant::img[@src='themes/softed/images/user.PNG']"));
//		Actions act=new Actions(driver);
//		act.moveToElement(user).perform();
//		driver.findElement(By.linkText("Sign Out")).click();
//		driver.close();
//	}
//	
//	@Test(dependsOnMethods = {"createContact", "modifyContact"})
//	public void deleteContact() throws MalformedURLException {
//		
////		WebDriverManager.chromedriver().setup();
////		WebDriver driver=new ChromeDriver();
//		
//		URL url=new URL("http://34.211.144.176:4444/wd/hub");
//		DesiredCapabilities cap=new DesiredCapabilities();
//		cap.setBrowserName("chrome");
//		cap.setPlatform(Platform.WINDOWS);
//		
//		RemoteWebDriver driver=new RemoteWebDriver(url,cap);
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("http://localhost:8888/");
//		
//		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
//		
//		driver.findElement(By.linkText("Contacts")).click();
//		for(;;) {
//		try {
//			driver.findElement(By.xpath("//a[text()='"+newLastName+"']")).click();
//			break;
//		}
//		catch(Exception e) {
//			driver.findElement(By.xpath("//a[@title='Next']")).click();
//		}
//	}
//		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
//		driver.switchTo().alert().accept();
//		System.out.println("last name deleted successfully");
//		
//		WebElement user = driver.findElement(By.xpath("//span[text()=' Administrator']/ancestor::tbody/descendant::img[@src='themes/softed/images/user.PNG']"));
//		Actions act=new Actions(driver);
//		act.moveToElement(user).perform();
//		driver.findElement(By.linkText("Sign Out")).click();
//		driver.close();
//
//	}
}

