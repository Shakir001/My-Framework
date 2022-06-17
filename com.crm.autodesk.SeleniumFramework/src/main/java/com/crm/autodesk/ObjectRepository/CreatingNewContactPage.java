package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {

	/*initialization of web elements*/
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*declaration of web elements*/
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	
	@FindBy(xpath="//input[@name='account_name']/parent::td/child::img")
	private WebElement organizationNameImg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	/*getters method*/
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getOrganizationNameImg() {
		return organizationNameImg;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*business logic*/
	public void clickOnOrganizatioNameImg() {
		organizationNameImg.click();
	}
	
	public void createContactWithTextField(String lastName,WebDriver driver,String organizationName) {
		lastNameTextField.sendKeys(lastName);

		saveButton.click();
	}
	
	
	
}








