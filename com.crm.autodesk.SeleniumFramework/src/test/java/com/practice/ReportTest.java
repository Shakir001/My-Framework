package com.practice;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClass;

@Listeners(com.crm.autodesk.GenericUtility.ListenerImp.class)
public class ReportTest extends BaseClass {

	@Test
	public void createOrg() {
		System.out.println("passed");
	}
	@Test
	public void createContact() {
		System.out.println("fail");
		Assert.fail();
	}
	@Test
	public void createLead() {
		System.out.println("skip");
		throw new SkipException(null);
	}
}
