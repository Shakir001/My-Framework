package com.crm.autodesk.GenericUtility;

import java.util.Date;
import java.util.Random;


/**
 * 
 * @author Shakir
 *
 */

public class JavaUtility {
	/**
	 * Its used to generate random number
	 * @return int data
	 */
	public int getRandomNum()
	{
		Random random=new Random();
		int randomNum=random.nextInt(10000);
		return randomNum;
	}
	
	/**
	 * Used to get system date & time in IST format
	 * @return
	 */
	public String getSystemDateAndTime()
	{
		Date date = new Date();
		String dateAndTime=date.toString().replace(":", "-");
		return dateAndTime;
	}
	
	/**
	 * Used to get system date in YYYY-MM-DD format
	 * @return
	 */
	public String getSystemDateWithFormat()
	{
		Date date = new Date();
		String dateAndTime = date.toString();
		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		
		String finalFormat = YYYY+"-"+MM+"-"+DD;
		return finalFormat;
	}
	
}


