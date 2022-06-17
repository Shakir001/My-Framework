package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInformationPage {

	/*initialization of web elements*/
	public LeadInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*declaration of web elements*/
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	/*getters method to use it in the test script*/
	public WebElement getHeaderText() {
		return headerText;
	}
	
	/*business logic*/
	/**
	 * This method is used to capture the header text
	 * @return
	 */
	public String captureLeadText() {
		return headerText.getText();
	}
	
}







