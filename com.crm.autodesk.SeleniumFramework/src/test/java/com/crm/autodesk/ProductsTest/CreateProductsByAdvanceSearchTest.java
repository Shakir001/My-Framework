package com.crm.autodesk.ProductsTest;

import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.ProductsAdvancedSearchPage;
import com.crm.autodesk.ObjectRepository.ProductsPage;

public class CreateProductsByAdvanceSearchTest extends BaseClass {

	@Test(groups = {"smokeTest","regressionTest"})
	public void createProductByAdvSearch() throws Throwable {
		
		//getting the data from excel
		String productName=eLib.getExcelData("Products", 1, 0);
		String noneDrop=eLib.getExcelData("Products", 1, 1);
		String repBox=eLib.getExcelData("Products", 1, 2);
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnProducts();
		
		ProductsPage productPage=new ProductsPage(driver);
		productPage.clickOnGoTOAdvancedSearchLink();
		
		ProductsAdvancedSearchPage advSearchPage=new ProductsAdvancedSearchPage(driver);
		advSearchPage.advancedSearch(productName, noneDrop, repBox);
		System.out.println("Advanced search done=====>Pass");
		
	}
}






