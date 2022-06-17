package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryImpClass {

	@Test(retryAnalyzer=com.crm.autodesk.GenericUtility.RetryAnalyserImplementationClass.class)
	public void create() {
		System.out.println("retry");
		Assert.assertEquals(false, true);
	}
}
