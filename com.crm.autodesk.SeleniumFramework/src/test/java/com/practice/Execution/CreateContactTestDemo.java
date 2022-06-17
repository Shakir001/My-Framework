package com.practice.Execution;

import org.testng.annotations.Test;

public class CreateContactTestDemo {

	@Test(groups= "regressionTest")
	public void contactName() {
		System.out.println("contact name created");
	}
	@Test(groups= "regressionTest")
	public void contactWithOrg() {
		System.out.println("contact is with organization");
	}
}
