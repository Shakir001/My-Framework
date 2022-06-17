package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Sample_Select_Sql_Query_Execution {
	public static void main(String[] args) throws Throwable {
		Connection conn=null;
		try
		{
		//Step1: Load/Register the database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step2: Connect to database
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys", "root", "root");
		System.out.println("======connected======");
		
		//Step3: Issue Sql Query
		Statement stat=conn.createStatement();
		
		//Step4: Execute Query
		String query="select * from infosys_emp";
		ResultSet result=stat.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		}
		catch(Exception e)
		{
		}
		finally
		{
		//Step5: close the db connection
		conn.close();
		System.out.println("========connection closed successfully========");
	}
	}
}
