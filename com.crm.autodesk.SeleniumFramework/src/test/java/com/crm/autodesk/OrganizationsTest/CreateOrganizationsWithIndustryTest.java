package com.crm.autodesk.OrganizationsTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.ObjectRepository.CreatingNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInformationPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;

@Listeners(com.crm.autodesk.GenericUtility.ListenerImplementationClass.class)
public class CreateOrganizationsWithIndustryTest extends BaseClass{
	
	@Test(groups = "functionalTest")
	public void createOrgWithIndustry() throws Throwable {

		int randomNum=jLib.getRandomNum();
		
		//getting the data from excel
		String organizationName=eLib.getExcelData("Organizations", 1, 2)+"-"+randomNum;
		String dropDownValue=eLib.getExcelData("Organizations", 1, 3);
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnOrganizations();
		
		OrganizationsPage organizationsPage=new OrganizationsPage(driver);
		organizationsPage.clickOnCreateOrganizationsImg();
//		Assert.fail();
		
		CreatingNewOrganizationPage createNewOrgPg=new CreatingNewOrganizationPage(driver);
		createNewOrgPg.createOrganization(organizationName, dropDownValue);
		
		//verification
		OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
		String actualOrgName=orgInfoPage.getOrganizationText();
		
//		if(actualOrgName.contains(organizationName))
//		{
//			System.out.println("Organization is created successfully=====>Pass");
//		}else {
//			System.out.println("Organization is failed to create======>Fail");
//		}
		
		Assert.assertEquals(actualOrgName.contains(organizationName),true);
	}
}








