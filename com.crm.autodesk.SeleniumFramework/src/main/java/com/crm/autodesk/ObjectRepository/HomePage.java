package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;
/**
 * This is HomePage Object Repository
 * @author Shakir
 *
 */

public class HomePage extends WebDriverUtility {
	
	//initialization of web elements
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration of web elements
	@FindBy(linkText="Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLink;
	
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaignsLink;
	
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutIconImage;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	//getters method to use it in the test script
	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}
	
	public WebElement getProductsLink() {
		return productsLink;
	}
	
	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getSignOutIconImage() {
		return signOutIconImage;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	//business logic
	/**
	 * This method will click on organizations link
	 */
	public void clickOnOrganizations() {
		organizationsLink.click();
	}
	
	/**
	 * This method will click on products link
	 */
	public void clickOnProducts() {
		productsLink.click();
	}
	
	/**
	 * This method will click on leads link
	 */
	public void clickOnLeads() {
		leadsLink.click();
	}
	
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContacts() {
		contactsLink.click();
	}
	
	/**
	 * This method will click on Opportunities link
	 */
	public void clickOnOpportunities() {
		opportunitiesLink.click();
	}
	
	public void clickOnCampaigns(WebDriver driver) {
		mouseOverOnElement(driver, moreLink);
		campaignsLink.click();
	}
	
	/**
	 * This method will logout the application
	 * @param driver
	 */
	public void logout(WebDriver driver) {
		mouseOverOnElement(driver, signOutIconImage);
		signOutLink.click();
	}
	
	
}






