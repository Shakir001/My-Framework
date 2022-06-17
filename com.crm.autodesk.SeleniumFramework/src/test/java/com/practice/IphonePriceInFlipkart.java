package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IphonePriceInFlipkart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Iphone 13",Keys.ENTER);
		
		driver.findElement(By.xpath("//div[@title='2★ & above']")).click();
		
		String price=driver.findElement(By.xpath("//div[text()='APPLE iPhone 13 (Blue, 128 GB)']/ancestor::div[@class='_3pLy-c row']/descendant::div[@class='_30jeq3 _1_WHN1']")).getText();
		System.out.println("Price is "+price);
		
		String offOnExchange=driver.findElement(By.xpath("//div[text()='APPLE iPhone 13 (Blue, 128 GB)']/ancestor::div[@class='_3pLy-c row']/descendant::div[@class='_2ZdXDB']")).getText();
		System.out.println("offOnExchange: "+offOnExchange);
		
		driver.quit();
	}

}







