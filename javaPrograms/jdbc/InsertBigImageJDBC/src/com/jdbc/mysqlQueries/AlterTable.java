package com.jdbc.mysqlQueries;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AlterTable {
	public static void alterMethod(String QUERY) {
		try {
			Connection con = ConnectionProvider.getConnection();
			Statement stmt = con.createStatement();
			stmt.execute(QUERY);
			JOptionPane.showMessageDialog(null, "[OK] table altered successfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
