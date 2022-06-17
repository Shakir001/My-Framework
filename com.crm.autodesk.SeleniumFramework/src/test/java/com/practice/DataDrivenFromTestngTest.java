package com.practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class DataDrivenFromTestngTest {

	@Test
	public void getValues(XmlTest xml) {
		System.out.println(xml.getParameter("browser"));
		System.out.println(xml.getParameter("url"));
		System.out.println(xml.getParameter("username"));
		System.out.println(xml.getParameter("password"));
	}
}
