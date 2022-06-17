package com.crm.autodesk.CampaignsTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.ObjectRepository.CamapignInformationPage;
import com.crm.autodesk.ObjectRepository.CampaignsPage;
import com.crm.autodesk.ObjectRepository.CreatingNewCampaignPage;
import com.crm.autodesk.ObjectRepository.HomePage;

@Listeners(com.crm.autodesk.GenericUtility.ListenerImplementationClass.class)
public class CreateCampaignsTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createCampaigns() throws Throwable {
		
		/*get data from excel*/
		String campName=eLib.getExcelData("Campaigns", 1, 1);
		
		/*navigate to campaigns*/
		HomePage homePage=new HomePage(driver);
		homePage.clickOnCampaigns(driver);
//		Assert.fail();
		
		/*navigate to create create campaign page*/
		CampaignsPage cp=new CampaignsPage(driver);
		cp.clickOnCreateCampaignLink();
		
		/*enter campaign name and save*/
		CreatingNewCampaignPage cncp=new CreatingNewCampaignPage(driver);
		cncp.campaign(campName);
		
		/*validation*/
		CamapignInformationPage cip=new CamapignInformationPage(driver);
		String campMsg=cip.captureHeaderText();
//		if(campMsg.contains(campName)) {
//			System.out.println("campaign name is created successfully=====>Pass");
//		}else {
//			System.out.println("campaign name is not created=====>Fail");
//		}
		
		Assert.assertEquals(campMsg.contains(campName),true);
		
	}
}






