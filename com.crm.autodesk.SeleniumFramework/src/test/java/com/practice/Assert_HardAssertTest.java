package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert_HardAssertTest {

	@Test
	public void assertCheckInt() {
		int a=10;
		int b=10;
		Assert.assertEquals(a, b);
	}
	
	@Test
	public void assertCheckString() {
		String name1="Shakir";
		String name2="Shakir";
		
		Assert.assertEquals(name1, name2);
	}
	
	@Test
	public void assertCheckBoolean() {
		boolean flag1=true;
		boolean flag2=true;
		
		Assert.assertEquals(flag1, flag2);
	}
	
	@Test
	public void assertCheckChar() {
		char ch1='A';
		char ch2='A';
		
		Assert.assertEquals(ch1, ch2);
	}
	
}









