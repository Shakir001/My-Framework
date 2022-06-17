package com.practice;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationsAndDeleteTest {

	@Test
	public void createOrgAndDelete() throws Throwable {
		WebDriverUtility wLib=new WebDriverUtility();
		
		String orgName="Amazon";
		
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
		
		URL url=new URL("http://34.211.144.176:4444/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver=new RemoteWebDriver(url,cap);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
//		WebElement organizationLink=driver.findElement(By.linkText("Organizations"));
//		WebDriverWait wait=new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(organizationLink));
		Thread.sleep(4000);
		driver.findElement(By.linkText("Organizations")).click();
		
		for(;;) {
		try {
			driver.findElement(By.xpath("//a[@title='Organizations'][text()='"+orgName+"']")).click();
			break;
		}
		catch(Exception e) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
		}
	}
		String headerMsg=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerMsg.contains(orgName)) {
			System.out.println(orgName+" is created successfully======>Pass");
		}else {
			System.out.println(orgName+" is not created successfully======>Fail");
		}
		
		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		
		/*alert popup*/
		driver.switchTo().alert().accept();
		System.out.println(orgName+" is deleted successfully");
		
		/*logout*/
		WebElement user = driver.findElement(By.xpath("//span[text()=' Administrator']/ancestor::tbody/descendant::img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(user).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
	}
}
