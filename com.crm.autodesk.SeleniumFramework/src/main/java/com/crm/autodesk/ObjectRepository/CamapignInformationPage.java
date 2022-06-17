package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CamapignInformationPage {

	/*initialization of web elements*/
	public CamapignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*declaration of web elements*/
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	/*getters method*/
	public WebElement getHeaderText() {
		return headerText;
	}
	
	/*business logic*/
	public String captureHeaderText() {
		return headerText.getText();
	}
}






