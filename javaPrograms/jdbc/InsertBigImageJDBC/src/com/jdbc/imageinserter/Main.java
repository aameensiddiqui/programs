package com.jdbc.imageinserter;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO images(image) VALUES(?)");
			JFileChooser jfc = new JFileChooser();
			jfc.showOpenDialog(null);
			File file = jfc.getSelectedFile();
			FileInputStream f = new FileInputStream(file);
			pstmt.setBinaryStream(1, f, f.available());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "[OK] file inserted successfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
