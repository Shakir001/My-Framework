package com.crm.autodesk.ProductsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ProductsPopup;
import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.ObjectRepository.CreatingNewProductPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.ProductInformationPage;
import com.crm.autodesk.ObjectRepository.ProductsPage;

public class CreatingProductsWithProductInformationTest extends BaseClass {

	@Test(groups = {"smokeTest","functionalTest"})
	public void createProductWithProductInfo() throws Throwable {
		
		//getting the data from excel
		String productName=eLib.getExcelData("Products", 4, 0);
		String salesStartDate=eLib.getExcelData("Products", 4, 1);
		String partNumber=eLib.getExcelData("Products", 4, 2);
		String manufacturer=eLib.getExcelData("Products", 4, 3);
		String productCategory=eLib.getExcelData("Products", 4, 4);
		String salesEndDate=eLib.getExcelData("Products", 4, 5);
		String supportStartDate=eLib.getExcelData("Products", 4, 6);
		String supportExpiryDate=eLib.getExcelData("Products", 4, 7);
		String website=eLib.getExcelData("Products", 4, 9);
		String vendorPartNo=eLib.getExcelData("Products", 4, 10);
		String mfrPartNo=eLib.getExcelData("Products", 4, 11);
		String productSheet=eLib.getExcelData("Products", 4, 12);
		String serialNo=eLib.getExcelData("Products", 4, 13);
		String glAccount=eLib.getExcelData("Products", 4, 14);	
		String vendorName=eLib.getExcelData("Products", 4, 8);
		
		/*navigate to product*/
		HomePage homePage=new HomePage(driver);
		homePage.clickOnProducts();
		
		/*click on create product*/
		ProductsPage productPage=new ProductsPage(driver);
		productPage.clickOnCreateProductsImg();
		
		/*click on Vendor Name Image*/
		CreatingNewProductPage cncp=new CreatingNewProductPage(driver);
		cncp.clickOnVendorNameImg();
		
		/*switch to popup window*/
		ProductsPopup popup=new ProductsPopup(driver);
		popup.selectVendorFromPopup(driver, "Vendors", vendorName, "Products");
		
		/*Enter all text fiels in creating new product page*/
		cncp.createProductTextField(productName, salesStartDate, partNumber, manufacturer, productCategory, salesEndDate, supportStartDate, supportExpiryDate, website, vendorPartNo, mfrPartNo, productSheet, serialNo, glAccount, vendorName, driver);
		
		//verification
		ProductInformationPage productInfoPage=new ProductInformationPage(driver);
		String productMsg=productInfoPage.captureProductText();
//		if(productMsg.contains(productName))
//		{
//			System.out.println("Product name is created successfully===>Pass");
//		}
//		else
//		{
//			System.out.println("Product is not created===>Fail");
//		}
		
		Assert.assertEquals(productMsg.contains(productName),true);
		
	}
}







