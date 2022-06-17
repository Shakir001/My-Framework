package com.crm.autodesk.ContactsTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.ObjectRepository.ContactInformationPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.ContactsPopup;
import com.crm.autodesk.ObjectRepository.CreatingNewContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;

@Listeners(com.crm.autodesk.GenericUtility.ListenerImplementationClass.class)
public class CreateContactsTest extends BaseClass {

	@Test(groups = "regressionTest")
	public void createContact() throws Throwable {
		
		int randomNum=jLib.getRandomNum();
		
		//getting the data from excel
		String lastName=eLib.getExcelData("Sheet1", 1, 2)+"-"+randomNum;
		String organizationName=eLib.getExcelData("Sheet1", 1, 4);
		
		/*navigate to contacts*/
		HomePage homePage=new HomePage(driver);
		homePage.clickOnContacts();
		
		/*navigate to create contact page*/
		ContactsPage contactPage=new ContactsPage(driver);
		contactPage.clickOnCreateContactImg();
		
		/*click on organization name Image popup*/
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.clickOnOrganizatioNameImg();
		
		/*switch to popup window*/
		ContactsPopup cp=new ContactsPopup(driver);
		cp.selectOrganizationNameFromPopup(driver, "Accounts", organizationName, "Contacts");
//		Assert.fail();
		
		/*enter all the mandatory text field in creating new contact page*/
		cncp.createContactWithTextField(lastName, driver, organizationName);
		
		/*verification*/
		ContactInformationPage cip=new ContactInformationPage(driver);
		String contactMsg=cip.captureContactText();
//		if(contactMsg.contains(lastName))
//		{
//			System.out.println("Contacts created successfully=====>Pass");
//		}
//		else
//		{
//			System.out.println("Contacts not created======>Fail");
//		}
		
		Assert.assertEquals(contactMsg.contains(lastName),true);
	}
	
}







