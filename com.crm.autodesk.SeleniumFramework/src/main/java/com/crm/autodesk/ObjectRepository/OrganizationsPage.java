package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	//initialization of web elements
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration of web elements
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationsImg;
	
	@FindBy(xpath="//img[@title='Search in Organizations...']")
	private WebElement searchInOrganizationsImg;
	
	//getters method to use it in the test script
	public WebElement getCreateOrganizationsImg() {
		return createOrganizationsImg;
	}
	
	public WebElement getSearchInOrganizationsImg() {
		return searchInOrganizationsImg;
	}
	
	//business logic
	public void clickOnCreateOrganizationsImg() {
		createOrganizationsImg.click();
	}
	
	public void clickOnSearchInOrganizationsImg() {
		searchInOrganizationsImg.click();
	}
	
	
}






