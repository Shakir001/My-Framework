package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class CreatingNewOrganizationPage extends WebDriverUtility {

	//initialization of web elements
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration of web elements
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organizationNameTextField;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industryDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//getters method to use it in the test script
	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}
	
	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//business logic
	public void createOrganization(String organizationName, String dropDownValue) {
		organizationNameTextField.sendKeys(organizationName);
		selectOption(industryDropdown, dropDownValue);
		saveButton.click();
		
	}
	
}




