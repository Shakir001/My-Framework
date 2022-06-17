package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This is create new product page object repository
 * @author Shakir
 *
 */
public class CreatingNewProductPage {

	//initialization of web elements
	public CreatingNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration of web elements
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//input[@name='sales_start_date']")
	private WebElement salesStartDateTextField;
	
	@FindBy(xpath="//input[@id='productcode']")
	private WebElement partNumberTextField;
	
	@FindBy(xpath="//select[@name='manufacturer']")
	private WebElement manufacturerDropdown;
	
	@FindBy(xpath="//select[@name='productcategory']")
	private WebElement productCategoryDropdown;
	
	@FindBy(xpath="//input[@name='sales_end_date']")
	private WebElement salesEndDateTextField;
	
	@FindBy(xpath="//input[@id='jscal_field_start_date']")
	private WebElement supportStartDateTextField;
	
	@FindBy(xpath="//input[@id='jscal_field_expiry_date']")
	private WebElement supportExpiryDateTextField;
	
	
	@FindBy(xpath="//input[@name='website']")
	private WebElement websiteTextField;
	
	@FindBy(id="vendor_part_no")
	private WebElement vendorPartNoTextField;
	
	
	@FindBy(id="mfr_part_no")
	private WebElement mfrPartNoTextField;
	
	@FindBy(id="productsheet")
	private WebElement productSheetTextField;
	
	@FindBy(id="serial_no")
	private WebElement serialNoTextField;
	
	@FindBy(name="glacct")
	private WebElement glAccountDropdown;
	
	@FindBy(xpath="//input[@name='vendor_name']/parent::td/child::img")
	private WebElement vendorNameImg;
	

	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	
	//getters method to use it in the test script
	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSalesStartDate() {
		return salesStartDateTextField;
	}

	public WebElement getPartNumber() {
		return partNumberTextField;
	}

	public WebElement getManufacturer() {
		return manufacturerDropdown;
	}

	public WebElement getProductCategory() {
		return productCategoryDropdown;
	}

	public WebElement getSalesEndDate() {
		return salesEndDateTextField;
	}

	public WebElement getSupportStartDate() {
		return supportStartDateTextField;
	}

	public WebElement getSupportExpiryDate() {
		return supportExpiryDateTextField;
	}


	public WebElement getWebsite() {
		return websiteTextField;
	}

	public WebElement getVendorPartNo() {
		return vendorPartNoTextField;
	}

	public WebElement getMfrPartNo() {
		return mfrPartNoTextField;
	}

	public WebElement getProductSheet() {
		return productSheetTextField;
	}

	public WebElement getSerialNo() {
		return serialNoTextField;
	}

	public WebElement getGlAccount() {
		return glAccountDropdown;
	}
	
	public WebElement getVendorName() {
		return vendorNameImg;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	//business logic
	public void clickOnVendorNameImg() {
		vendorNameImg.click();
	}
	
	
	
	/**
	 * This method is used to create product with all fields
	 */
	public void createProductTextField(String productName,String salesStartDate,String partNumber,String manufacturer,
			                  String productCategory,String salesEndDate,String supportStartDate,
			                  String supportExpiryDate,String website,String vendorPartNo,String mfrPartNo,
			                  String productSheet,String serialNo,String glAccount,String vendorName,WebDriver driver ){
		productNameTextField.sendKeys(productName);
		salesStartDateTextField.sendKeys(salesStartDate);
		partNumberTextField.sendKeys(partNumber);
		manufacturerDropdown.sendKeys(manufacturer);
		productCategoryDropdown.sendKeys(productCategory);
		salesEndDateTextField.sendKeys(salesEndDate);
		supportStartDateTextField.sendKeys(supportStartDate);
		supportExpiryDateTextField.sendKeys(supportExpiryDate);
		websiteTextField.sendKeys(website);
		vendorPartNoTextField.sendKeys(vendorPartNo);
		mfrPartNoTextField.sendKeys(mfrPartNo);
		productSheetTextField.sendKeys(productSheet);
		serialNoTextField.sendKeys(serialNo);
		glAccountDropdown.sendKeys(glAccount);
		
		saveButton.click();
		
	}
	
	
}







