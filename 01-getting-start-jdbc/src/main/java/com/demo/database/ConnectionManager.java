package com.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionManager {
	
	String URL = "jdbc:mysql://localhost:3306/blogen";
	String USER = "root";
	String PASS = "admin";
	
	Connection getConnection() throws SQLException;
	
	public static ConnectionManager getInstance() {
		return () -> 
			DriverManager.getConnection(URL, USER, PASS);
	}

}
