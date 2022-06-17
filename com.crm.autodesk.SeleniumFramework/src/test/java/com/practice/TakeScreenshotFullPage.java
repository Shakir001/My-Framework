package com.practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class TakeScreenshotFullPage {
	@Test
	public void homePage() throws IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
		
		//Step1: create an object EventFiringWebdriver class & pass driver object
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		
		//Step2: take screenshot & return File type of screenshot
		File srcImg=eDriver.getScreenshotAs(OutputType.FILE);
		
		//Step3: create one empty file is in specified location
		File dstImg=new File("./Screenshot/Test.png");
		
		//Step4: copy the screenshot using common-io 3rd party tool
		FileUtils.copyFile(srcImg, dstImg);	
		
		driver.close();
	}
}
