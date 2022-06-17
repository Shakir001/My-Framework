package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This is ProductsPage Object Repository
 * @author Shakir
 *
 */

public class ProductsPage {

	//initialization of web elements
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration of web elements
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProductsImg;
	
	@FindBy(linkText="Go to Advanced Search")
	private WebElement goTOAdvancedSearchLink;
	
	//getters method to use it in the test script
	public WebElement getCreateProductsImg() {
		return createProductsImg;
	}

	public WebElement getGoTOAdvancedSearchLink() {
		return goTOAdvancedSearchLink;
	}
	
	//business logic
	/**
	 * This method will click on create product
	 */
	public void clickOnCreateProductsImg() {
		createProductsImg.click();
	}
	
	/**
	 * This method will click on advanced search link
	 */
	public void clickOnGoTOAdvancedSearchLink() {
		goTOAdvancedSearchLink.click();
	}
	
	
}







