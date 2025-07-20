package com.jdbc.mysqlQueries;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			if(con == null) {
				con = DriverManager.getConnection("jdbc:mysql://localhost/forjdbc", "root", "root");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
}
