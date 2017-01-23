package com.iba.kozlov.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionCustomer {
	/*private static final String url = "jdbc:mysql://localhost:3306/mydb";
	private static final String user = "root";
	private static final String password = "f68IUZUfiox";*/
	

	private static Connection con;

	public  ConnectionCustomer() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try {
				Properties prop = new Properties();
				InputStream input = null;
				input=this.getClass().getClassLoader().getResourceAsStream("config.properties");
				
				try {
					prop.load(input);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   System.out.println(prop.getProperty("url"));
				    System.out.println(prop.getProperty("user"));
				    System.out.println(prop.getProperty("password"));
				    String url=prop.getProperty("url");
				    String user=prop.getProperty("user");
				    String password=prop.getProperty("password");
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