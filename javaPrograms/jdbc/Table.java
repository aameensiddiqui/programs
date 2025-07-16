import java.sql.*;

class Table {
    
    final static String DB_URL = "jdbc:mysql://localhost/forjdbc";
    final static String USER = "root";
    final static String PASS = "root";
    final static String QUERY = "CREATE TABLE emailss (id INT AUTO_INCREMENT PRIMARY KEY, "+
    "name VARCHAR(20) NOT NULL, email VARCHAR(50) NOT NULL)";
    
    public static void main(String[]args) {
	
	try {
	    Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
	    Statement stmt = con.createStatement();
	    int result = stmt.executeUpdate(QUERY);

	    System.out.println(result + " rows affected");
	    
	    con.close();
	    
	} catch(Exception e) {
	    e.printStackTrace();
	}
	
    }
    
}
