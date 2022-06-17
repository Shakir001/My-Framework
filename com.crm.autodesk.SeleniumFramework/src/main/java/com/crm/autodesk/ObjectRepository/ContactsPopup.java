package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class ContactsPopup extends WebDriverUtility {

	public ContactsPopup(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement searchTextField;
	
	@FindBy(name="search")
	private WebElement searchNowButton;

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchNowButton;
	}
	
	public void selectOrganizationNameFromPopup(WebDriver driver,String partialWindowTitle,String organizationName,String mainWindowTitle) {
		waitForPageToLoad(driver);
		switchToWindow(driver, partialWindowTitle);
		searchTextField.sendKeys(organizationName);
		searchNowButton.click();
		driver.findElement(By.xpath("//a[text()='"+organizationName+"']")).click();
		switchToWindow(driver, mainWindowTitle);
		
	}
}
