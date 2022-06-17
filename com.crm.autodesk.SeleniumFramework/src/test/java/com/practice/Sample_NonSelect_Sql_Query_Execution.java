package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


import com.mysql.jdbc.Driver;

public class Sample_NonSelect_Sql_Query_Execution {
	public static void main(String[] args) throws Throwable {
		Connection conn=null;
		int result=0;
		try
		{
		//Step1: load/register the database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step2: connect the database
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Infosys","root","root");
		System.out.println("======connected=======");
	    
		//Step3: Issue Sql query
		Statement stat=conn.createStatement();
		
		//Step4: Execute Query
		String query="insert into infosys_emp values('1', 'ram', 'gowda', 'h');";
				
		result=stat.executeUpdate(query);
		}
		catch(Exception e)
		{
		}
		finally
		{
		if(result==1)
		{
			System.out.println("inserted successfully=====>Pass");
		}
		else
		{
			System.out.println("failed to create======>Fail");
		}	
		//Step5: close the db connection
		conn.close();
		System.out.println("========connection closed successfully========");
		}
	}
}
