package com.practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert_SoftAssertTest {

	@Test
	public void assertCheckInt() {
		int a=20;
		int b=30;
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(a, b);
//		sa.assertAll();
		
		
	}
}
