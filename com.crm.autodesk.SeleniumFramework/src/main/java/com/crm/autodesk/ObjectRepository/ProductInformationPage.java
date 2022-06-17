package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This is product information page object repository
 * @author Shakir
 *
 */

public class ProductInformationPage {

	//initialization of web elements
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration of web elements
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement headerText;
	
	//getters method to use it in the test script
	public WebElement getHeaderText() {
		return headerText;
	}
	
	//business logic
	/**
	 * This method fetch the product text from product information page
	 * @return
	 */
	public String captureProductText() {
		return headerText.getText();
	}
	
}
