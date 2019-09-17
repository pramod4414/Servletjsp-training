package com.bv.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBconnect {
	
	public static Connection getConnection()
	{
		Connection connection = null;
		//step1. create properties class object
		try {
			FileInputStream fis = new FileInputStream("C:\\BV_programs\\Connection.properties");
			Properties properties = new Properties();
			
			//step2. load the proprties file
			
			properties.load(fis);
			System.out.println("Driver found");
			
			
			//get the data from proprties file using key
			
			String driverClass =(String) properties.get("driverclass");
			String url =(String) properties.get("url");
			String username=(String) properties.get("username");
			String password =(String) properties.get("password");
			Class.forName(driverClass);
			
			//create connection
			
			 connection = DriverManager.getConnection(url,username,password);
			System.out.println("COnnection Established");
			
			
			
			
		} catch (IOException | SQLException | ClassNotFoundException e) {
			
			System.out.println(e);
		}
		return connection;
	}

}
