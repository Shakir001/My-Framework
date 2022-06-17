package com.crm.autodesk.LeadsTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.ObjectRepository.CreatingNewLeadPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LeadInformationPage;
import com.crm.autodesk.ObjectRepository.LeadsPage;

@Listeners(com.crm.autodesk.GenericUtility.ListenerImplementationClass.class)
public class CreateLeadsTest extends BaseClass{

	@Test(groups = "integrationTest")
	public void createLeads() throws Throwable {
		
		int randomNum=jLib.getRandomNum();
		
		//getting the data from excel
		String lastName=eLib.getExcelData("Leads", 2, 0)+"-"+randomNum;
		String company=eLib.getExcelData("Leads", 2, 1);
		
		/*navigate to leads*/
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLeads();
		
		/*navigate to create leads Image*/
		LeadsPage leadsPage=new LeadsPage(driver);
		leadsPage.clickOnCreateLeadsImg();
		
		/*navigate to creating new leads page*/
		CreatingNewLeadPage createNewLeadPage=new CreatingNewLeadPage(driver);
		createNewLeadPage.lead(lastName, company);
//		Assert.fail();
		
		/*verification*/
		LeadInformationPage leadInfoPage=new LeadInformationPage(driver);
		String leadMsg=leadInfoPage.captureLeadText();
//		if(leadMsg.contains(lastName))
//		{
//			System.out.println("Last_Name created successfully=====>Pass");
//		}
//		else
//		{
//			System.out.println("Last_Name not created======>Fail");
//		}	
		
		Assert.assertEquals(leadMsg.contains(lastName),true);
	}
}









