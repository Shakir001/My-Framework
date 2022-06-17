package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsAdvancedSearchPage {

	//initialization of web elements
	public ProductsAdvancedSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration of web elements
	@FindBy(xpath="//select[@class='detailedViewTextBox']")
	private WebElement productNameDropdown;
	
	@FindBy(xpath="//select[@class='repBox']")
	private WebElement noneDropDown;
	
	@FindBy(xpath="//input[@class='repBox']")
	private WebElement textRepBox;
	
	@FindBy(xpath="//div[@id='advSearch']/descendant::input[@value=' Search Now ']")
	private WebElement searchNow;
	
	//getters method to use it in the test script
	public WebElement getProductNameDropdown() {
		return productNameDropdown;
	}
	
	public WebElement getNoneDropDown() {
		return noneDropDown;
	}
	
	public WebElement getTextRepBox() {
		return textRepBox;
	}
	
	public WebElement getSearchNow() {
		return searchNow;
	}
	
	//Business logic
	public void advancedSearch(String productName, String noneDrop, String repBox) {
		productNameDropdown.sendKeys(productName);
		noneDropDown.sendKeys(noneDrop);
		textRepBox.sendKeys(repBox);
		searchNow.click();
	}
	
	
	
	
}
