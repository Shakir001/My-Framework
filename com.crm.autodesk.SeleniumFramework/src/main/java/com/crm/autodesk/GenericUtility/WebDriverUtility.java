package com.crm.autodesk.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Its contains WebDriver specific reusable actions
 * @author Shakir
 *
 */

public class WebDriverUtility {
	/**
	 * wait for page to load before identifying any synchronized element in DOM[HTML-Document]
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * wait for page to load before identifying any assynchronized[java script actions] element in DOM[HTML-Document]
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
	/**
	 * Used to wait for element to be clickable in GUI, & check for specific element for every 500 milli seconds
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickAble(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Used to wait for element to be clickable in GUI, & check for specific element for every 500 milli seconds
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws Throwable
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Used to switch to any window based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) 
		{
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * Used to switch to alert window & click on ok button 
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * Used to switch to alert window & click on cancel button
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * Used to switch to frame window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * Used to switch to frame window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver, String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * Used to select the value from the dropdown based on index
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * Used to select the value from the dropdown based on value/option available in GUI
	 * @param element
	 * @param text
	 */
	public void selectOption(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * Used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	
	/**
	 * Used to right click on specified element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver, String javaScript)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeAsyncScript(javaScript, null);
	}
	
	/**
	 * 
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebElement element) throws Throwable
	{
		int count=0;
		while(count<20)
		{
			try
			{
				element.click();
				break;
			}
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * 
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable
	{
		JavaUtility jLib=new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+screenshotName+jLib.getSystemDateAndTime()+".PNG");
		FileUtils.copyFile(src, dest);
		
		return dest.getAbsolutePath();
	}
	
	/**
	 * 
	 * @param driver
	 */
	public void pressEnterKey(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * Used to maximize the window
	 * @param driver
	 */
	public void getWindowMaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * Used to make fullscreen the window
	 * @param driver
	 */
	public void getWindowFullscreen(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	
//	public void launchBrowserWithUrl(WebDriver driver, String browser, String url)
//	{
//		if(browser.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver.get(url);
//			System.out.println("launched browser is: "+browser);
//		}
//		
//	}
}






