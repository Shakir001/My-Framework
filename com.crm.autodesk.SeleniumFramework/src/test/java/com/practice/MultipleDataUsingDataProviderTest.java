package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleDataUsingDataProviderTest {

	/*to execute same script with multiple data*/
	/*use @DataProvider annotation >It will provide data to @Test annotated method*/
	
	@Test(dataProvider = "getData")
	public void multipleData(String lastName, String mobile) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobile);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement user = driver.findElement(By.xpath("//span[text()=' Administrator']/ancestor::tbody/descendant::img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(user).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
	}
		@DataProvider
		public Object[][] getData() {
			Object[][] objArray = new Object[5][2];
			objArray[0][0]="Kumar";
			objArray[0][1]="7004911242";
			
			objArray[1][0]="Ahmad";
			objArray[1][1]="7004913457";
			
			objArray[2][0]="Mahto";
			objArray[2][1]="7004911289";
			
			objArray[3][0]="Pandey";
			objArray[3][1]="7004589242";
			
			objArray[4][0]="Choubey";
			objArray[4][1]="7004957451";
			
			return objArray;
		}
		
		
	
}
