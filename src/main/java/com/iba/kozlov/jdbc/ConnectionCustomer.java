package com.iba.kozlov.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionCustomer {
	private static final String url = "jdbc:mysql://localhost:3306/mydb";
	private static final String user = "root";
	private static final String password = "f68IUZUfiox";

	private static Connection con;

	public  ConnectionCustomer() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
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