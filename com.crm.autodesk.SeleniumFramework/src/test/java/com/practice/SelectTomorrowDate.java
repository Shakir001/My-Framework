package com.practice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectTomorrowDate {

	public static void main(String[] args) {
		LocalDateTime dateAndTime = LocalDateTime.now().plusDays(4);
		int day = dateAndTime.getDayOfMonth();
		String month = dateAndTime.getMonth().toString();
		int year = dateAndTime.getYear();
		String actualMonth = month.substring(0, 1)+month.substring(1).toLowerCase();
		String monthAndYear = actualMonth+" "+year;
		
		System.out.println(monthAndYear);
		System.out.println(day);
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
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

	}
}
