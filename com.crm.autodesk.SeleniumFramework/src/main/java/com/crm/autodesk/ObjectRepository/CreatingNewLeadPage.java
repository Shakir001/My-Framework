package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadPage {

	/*initialization of web elements*/
	public CreatingNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*declaration of web elements*/
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	
	@FindBy(name="company")
	private WebElement companyTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	/*getters method to use it in the test script*/
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getCompanyTextField() {
		return companyTextField;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*business logic*/
	public void lead(String lastName,String company) {
		lastNameTextField.sendKeys(lastName);
		companyTextField.sendKeys(company);
		saveButton.click();
	}
	
	
	
}
