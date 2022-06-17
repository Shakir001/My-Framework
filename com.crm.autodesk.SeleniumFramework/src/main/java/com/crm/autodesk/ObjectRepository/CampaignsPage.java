package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {

	/*initialization of web elements*/
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*declaration of web elements*/
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createCampaignLink;
	
	/*getters method*/
	public WebElement getCreateCampaignLink() {
		return createCampaignLink;
	}
	
	/*business logic*/
	public void clickOnCreateCampaignLink() {
		createCampaignLink.click();
	}
}
