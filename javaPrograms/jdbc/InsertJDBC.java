/*
*
* if an sql query is accepting any ? (parameters) then it is a dynamic query
* like INSERT INTO table_name VALUES (?, ?)
* PreparedStatement is for dynamic/parameterised query.
*
*/

import java.sql.*;
import java.util.Scanner;

class InsertJDBC {
    public static void main(String[]args) {
	String DB_URL = "jdbc:mysql://localhost/forjdbc";
	String USER = "root";
	String PASS = "root";
	// String QUERY = "INSERT INTO emails (name, email) VALUES (?, ?), (?, ?)";
	String QUERY = "INSERT INTO emails (name, email) VALUES (?, ?)";
	
	try {
	    Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
	    PreparedStatement pstmt = con.prepareStatement(QUERY);

	    /* 1 is first question mark, 2 is 2nd ?, ...*/
	    
	    Scanner scan = new Scanner(System.in);
	    System.out.print("Enter Name: ");
	    String name = scan.next();
	    System.out.print("Enter Name: ");
	    String email = scan.next();	    

	    pstmt.setString(1,name);
	    pstmt.setString(2,email);
	    
	    pstmt.executeUpdate();
	    
	    System.out.println("[OK] Data inserted.");

	    con.close();
	    
	} catch(Exception e) {
	    e.printStackTrace();
	}
    }
}
