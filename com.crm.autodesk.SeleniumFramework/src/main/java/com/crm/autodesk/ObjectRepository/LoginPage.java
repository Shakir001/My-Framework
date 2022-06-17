package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This is LoginPage Object Repository
 * @author Shakir
 *
 */

public class LoginPage {
	
	//initialization of web elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	//declaration of web elements
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	

	//getters method to use it in the test script
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//business logic
	/**
	 * This method will do the login action for application
	 * @param username
	 * @param password
	 */
	public void login(String username, String password)
	{
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
	
}







