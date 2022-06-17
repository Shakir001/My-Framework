package com.practice.Execution;

import org.testng.annotations.Test;

public class CreateOrganizationTestDemo {

	@Test(groups= "smokeTest")
	public void orgWithMandatoryFields() {
		System.out.println("Organization is created with all mandatory fields");
	}
	@Test(groups= "smokeTest")
	public void orgWithContact() {
		System.out.println("Organization is created with Contact");
	}
	@Test(groups= "regressionTest")
	public void orgWithProduct() {
		System.out.println("Organization is created with Product");
	}
}
