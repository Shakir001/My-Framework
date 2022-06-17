package com.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureAllHotelsGoibgo {

	public static void main(String[] args) throws Throwable {
		
		String nameOfCity="Bangalore";
		String checkInMonthAndYear="March 2022";
		String checkInDay="31";
		String checkOutMonthAndYear="April 2022";
		String checkOutDay="1";
		String childAge="5";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		
		driver.findElement(By.xpath("//a[@href='/hotels/'][@class='nav-link .']")).click();
		driver.findElement(By.xpath("//input[@name='CountryType']/following-sibling::h4[text()='India']")).click();
		driver.findElement(By.xpath("//input[@class='HomePageAutosuggeststyles__SearchInputStyles-sc-1v6s32j-1 euhecC']")).sendKeys(nameOfCity);
		
		Thread.sleep(4000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
//		driver.findElement(By.xpath("//input[contains(text()='"+nameOfCity+"')]")).click();
		
		driver.findElement(By.xpath("//div[text()='Check-in']")).click();
		driver.findElement(By.xpath("//span[text()='"+checkInMonthAndYear+"']/ancestor::div[@class='dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq']/descendant::span[text()='"+checkInDay+"']")).click();
		driver.findElement(By.xpath("//span[text()='"+checkOutMonthAndYear+"']/ancestor::div[@class='dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq']/descendant::span[text()='"+checkOutDay+"']")).click();
		driver.findElement(By.xpath("//span[text()='Guests & Rooms']")).click();
		driver.findElement(By.xpath("//span[text()='Children']/ancestor::div[@class='dwebCommonstyles__CenteredDivWrap-sc-112ty3f-1 PaxWidgetstyles__ContentItemWrapperDiv-sc-gv3w6r-2 ibYPGm fAmNIr']/descendant::span[text()='+']")).click();
		driver.findElement(By.xpath("//h4[text()='Select']")).click();
		driver.findElement(By.xpath("//li[text()='"+childAge+"']")).click();
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		
		driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();
		
		List<WebElement> allHotels = driver.findElements(By.xpath("//div[@class='SRPstyles__BodyWrapperContentStyle-sc-19ucfhx-1 kwbcQS']/descendant::h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-9 bjZxoj']"));
		
		int count=0;
		for(WebElement hotels:allHotels)
		{
			System.out.println(hotels.getText());
			count++;
		}
		System.out.println("Total number of hotels: "+count);
		driver.quit();
	}
	
}






