package com.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest1 {
	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver(option);
		driver.get("http://localhost:8888/");
		
	}
}
