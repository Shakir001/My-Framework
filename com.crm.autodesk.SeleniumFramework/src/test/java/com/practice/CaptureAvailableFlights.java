package com.practice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureAvailableFlights {

	public static void main(String[] args)  {
		LocalDateTime dateAndTime = LocalDateTime.now();
		int day = dateAndTime.getDayOfMonth();
		String month = dateAndTime.getMonth().toString();
		int year = dateAndTime.getYear();
		String actualMonth = month.substring(0, 1)+month.substring(1).toLowerCase();
		String monthAndYear = actualMonth+" "+year;
		
		String fromLocation="Ranchi";
		String toLocation="New Delhi";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		/*From*/
		driver.findElement(By.cssSelector("[id='fromCity']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(fromLocation);
		driver.findElement(By.xpath("//div[@id='react-autowhatever-1']/descendant::p[contains(text(),'"+fromLocation+"')]")).click();
		
		/*To*/
//		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(toLocation);
		driver.findElement(By.xpath("//div[@id='react-autowhatever-1']/descendant::p[contains(text(),'"+toLocation+"')]")).click();

		
		/*click on departure date*/
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String path="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']";
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath(path)).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		List<WebElement> allFlights = driver.findElements(By.xpath("//div[@id='premEcon']/descendant::span[@class='boldFont blackText airlineName']"));
		int count=0;
		for(WebElement flight:allFlights)
		{
			System.out.println(flight.getText());
			count++;
		}
		System.out.println("No of flights available: "+count);
	}
}
