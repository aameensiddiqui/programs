/*
*
* CREATE TABLE images (id INT AUTO_INCREMENT PRIMARY KEY, image BLOB);
* BLOB (Binary Large Object):
* can store large binary data like audio, video, image files in binary form
* 
* TINYBLOB:   Can store a maximum of 255           bytes of data
* BLOB:       Can store a maximum of 65,535        bytes of data
* MEDIUMBLOB: Can store a maximum of 16,777,215    bytes of data
* LONGBLOB:   Can store a maximum of 4,294,967,295 bytes of data
*
*/

import java.sql.*;
import java.io.*;

class InsertImage {
    public static void main(String[]args) {

	String DB_URL = "jdbc:mysql://localhost/forjdbc";
	String USER = "root";
	String PASS = "root";
	String QUERY = "INSERT INTO images(image) VALUES(?)";
	
	try {
	    Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

	    PreparedStatement pstmt = con.prepareStatement(QUERY);

	    FileInputStream f = new FileInputStream("/home/amin/Pictures/154116549.jpeg");
	    
	    // f.available() returns approx number of bytes available in the stream 
	    pstmt.setBinaryStream(1, f, f.available());

	    pstmt.executeUpdate();

	    System.out.println("[OK] Image inserted.");
	    
	} catch(Exception e) {
	    e.printStackTrace();
	}
    }
}
