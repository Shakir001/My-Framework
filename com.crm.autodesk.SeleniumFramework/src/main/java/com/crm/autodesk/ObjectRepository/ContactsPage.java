package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	/*initialization of web elements*/
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*declaration of web elements*/
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactImg;
	
	@FindBy(xpath="//img[@title='Search in Contacts...']")
	private WebElement searchInContactsImg;
	
	/*getters method*/
	public WebElement getCreateContactImg() {
		return createContactImg;
	}

	public WebElement getSearchInContactsImg() {
		return searchInContactsImg;
	}
	
	/*business logic*/
	public void clickOnCreateContactImg() {
		createContactImg.click();
	}
	
	
}





