package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {

	//initialization of web elements
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration of web elements
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	//getters method to use it in the test script
	public WebElement getHeaderText() {
		return headerText;
	}
	
	//business logic
	public String getOrganizationText() {
		return headerText.getText();	
	}
	
}
