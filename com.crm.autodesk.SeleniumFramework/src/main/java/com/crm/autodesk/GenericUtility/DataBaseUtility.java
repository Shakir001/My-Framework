package com.crm.autodesk.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
/**
 * This method will establish the connection between java and database
 * @throws SQL Exception
 */
	Connection connection;
	public void connectToDataBase() {
		
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection(IPathConstants.DATABASE_URL, IPathConstants.DATABASE_USERNAME, IPathConstants.DATABASE_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will close the database connection
	 * @throws SQLException
	 */
	public void closeDataBase() throws SQLException {
		connection.close();
	}
	
	/**
	 * This method will return all the data from database
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getAllData(String query) throws SQLException {
		ResultSet result = connection.createStatement().executeQuery(query);
		return result;	
	}
	
	/**
	 * This method will return true if data is added to database
	 * @param querry
	 * @return
	 * @throws SQLException
	 */
	public boolean insertData(String query) throws SQLException {
		int result = connection.createStatement().executeUpdate(query);
		boolean flag=false;
		if(result==1) {
			System.out.println("data is added");
			flag=true;
			return flag;
		}else {
			System.out.println("data is not added");
		}
		return flag;
	}
	
}





