package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaignPage {

	/*initialization of web elements*/
	public CreatingNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*declaration of web elements*/
	@FindBy(name="campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	/*getters method*/
	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*business logic*/
	public void campaign(String campName) {
		campaignNameTextField.sendKeys(campName);
		saveButton.click();
	}
	
}






