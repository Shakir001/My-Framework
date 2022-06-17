package com.practice;


import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SampleTest {
	public static void main(String[] args) throws IOException {
		
		Random random=new Random();
		int ranNum=random.nextInt(1000);
		String orgName="Qspider"+ranNum;
		
		ExcelLib lib=new ExcelLib();
		String data=lib.getExcelData("sheet1",1,2);
		
		System.out.println(data);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String text=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(text.contains(orgName))
		{
			System.out.println(orgName+" is present and validation pass");
		}
		else
		{
			System.out.println(orgName+" is not present and validation fail");
		}
		WebElement user=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(user).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
