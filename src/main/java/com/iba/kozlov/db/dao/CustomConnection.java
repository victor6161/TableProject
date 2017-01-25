package com.iba.kozlov.db.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class CustomConnection {

	private static Connection con;

	public  CustomConnection() {
		Properties prop = new Properties();
		InputStream input = null;
		input=this.getClass().getClassLoader().getResourceAsStream("config.properties");
		
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		    String url=prop.getProperty("url");
		    String user=prop.getProperty("user");
		    String password=prop.getProperty("password");
		    String driver=prop.getProperty("driver");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try {
			
				con = DriverManager.getConnection(url, user, password);
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
	}
	
	public  Connection getConnection() {
		return con;
	}
	
	public  void close() {
		 try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

}