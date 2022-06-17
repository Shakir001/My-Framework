package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToSelectAllCheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
		
		/*Navigate to leads*/
		driver.findElement(By.linkText("Leads")).click();
		
		/*Click on all check box*/
		List<WebElement> allChkBox = driver.findElements(By.xpath("//input[@onclick='check_object(this)']"));
		int count=0;
		for(WebElement chkBox:allChkBox)
		{
			chkBox.click();
			count++;
		}
		System.out.println("no of check box: "+count);
		
		/*Click on all check box*/
//		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]")).click();
		
	}
}





