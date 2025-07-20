package com.jdbc.mysqlQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class InsertTable {
	public static void insertMethod(String QUERY) {
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, "name");
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "[OK] data inserted successfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
