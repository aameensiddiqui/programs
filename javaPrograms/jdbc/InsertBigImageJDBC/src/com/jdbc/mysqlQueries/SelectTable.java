package com.jdbc.mysqlQueries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTable {
	public static void selectTable(String tName) {
		try {
			Connection con = ConnectionProvider.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM "+tName);
			while(rs.next()) {
				System.out.println(rs.getInt("tId")+" | "+rs.getString("tName")+" | "+rs.getString("tCity"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
