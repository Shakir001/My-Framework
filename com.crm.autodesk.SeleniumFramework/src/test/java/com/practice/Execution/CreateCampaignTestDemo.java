package com.practice.Execution;

import org.testng.annotations.Test;

public class CreateCampaignTestDemo {

	@Test(groups= "integrationTest")
	public void campWithMandatoryFields() {
		System.out.println("campaign is created with all amndatory fields");
	}
	@Test(groups= "smokeTest")
	public void campWithContact() {
		System.out.println("campaign is created with contact");
	}
}
