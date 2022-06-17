package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureOlympic {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://olympics.com/en/athletes/");
		
		driver.findElement(By.xpath("//button[@id='onetrust-pc-btn-handler']")).click();
		driver.findElement(By.xpath("//button[text()='Reject All']")).click();
		driver.findElement(By.xpath("//button[@class='button-no-styles icon-close-button pvp-modal__close']")).click();
		driver.findElement(By.xpath("//span[text()='Mikael']")).click();
		
		String text=driver.findElement(By.xpath("//h1[text()='Mikael KINGSBURY']/ancestor::main[@id='content']/descendant::li[@class='detail__item text-small detail__item--medals']")).getText();
		System.out.println(text);
	}
}
