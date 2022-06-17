package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	/*initialization of web elements*/
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*declaration of web elements*/
	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement createLeadsImg;
	
	@FindBy(xpath="//img[@title='Search in Leads...']")
	private WebElement searchInLeadsImg;
	
	/*getters method to use it in the test script*/
	public WebElement getCreateLeadsImg() {
		return createLeadsImg;
	}
	
	public WebElement getSearchInLeadsImg() {
		return searchInLeadsImg;
	}
	
	/*business logic*/
	/**
	 * This method will click on create leads Image
	 */
	public void clickOnCreateLeadsImg() {
		createLeadsImg.click();
	}
	
	/**
	 * This method will click on search in leads Image
	 */
	public void clickOnSearchInLeadsImg() {
		searchInLeadsImg.click();
	}
	
}
