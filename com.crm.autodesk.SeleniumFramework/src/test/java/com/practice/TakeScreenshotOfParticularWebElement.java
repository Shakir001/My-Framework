package com.practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakeScreenshotOfParticularWebElement {
	@Test
	public void homePage() throws IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
		
		WebElement ele=driver.findElement(By.linkText("Dashboard"));
		File srcImg=ele.getScreenshotAs(OutputType.FILE);
		File dstImg=new File("./Screenshot/Demo.png");
		FileUtils.copyFile(srcImg, dstImg);
	}
}
