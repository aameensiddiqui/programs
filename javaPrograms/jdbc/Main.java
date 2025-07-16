/*
 *
 * javac -cp .:mysql-connector-j-9.3.0.jar Main.java
 * java -cp .:mysql-connector-j-9.3.0.jar Main
 *
 */

import java.sql.*;

class Main {
    
    final static String DB_URL = "jdbc:mysql://localhost/forjdbc";
    final static String USER   = "root";
    final static String PASS   = "root";
    final static String QUERY1 = "INSERT INTO sample VALUES (1, 'Chintu'), (2, 'Raju'), (3, 'Neha'), (4, 'Pappu'), (5, 'Mini')";
    final static String QUERY2 = "SELECT * FROM sample";

    public static void main(String[]args){
	try(
	    Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
	    Statement stmt = con.createStatement();
	    ) {

	    int r = stmt.executeUpdate(QUERY1);
	    System.out.println("rows affected "+r);
	    ResultSet rs = stmt.executeQuery(QUERY2);
	    
	    while(rs.next()){
		System.out.println(rs.getInt("id")+" "+rs.getString("name"));
	    }
	    
	} catch(SQLException e){
	    e.printStackTrace();
	}
    }
}
