package com.jdbc.mysqlQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateTable {
	public static void updateTable(String QUERY) {
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, "Phaltan");
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
