package com.practice;

import com.crm.autodesk.GenericUtility.JavaUtility;

public class DemoJavaU {
	public static void main(String[] args) {
		JavaUtility jLib=new JavaUtility();
		String time=jLib.getSystemDateAndTime();
		System.out.println(time);
		
		String time1=jLib.getSystemDateWithFormat();
		System.out.println(time1);
		
	}
}
