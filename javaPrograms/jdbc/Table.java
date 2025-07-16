import java.sql.*;

class Table {
    
    public static void main(String[]args) {
	
	try {
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/forjdbc","root","root");
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("SELECT * FROM sample");
	    while(rs.next()) {
		System.out.println(rs.getInt("id")+" "+rs.getString("name"));
	    }
	} catch(Exception e) {
	    e.printStackTrace();
	}
	
    }
    
}
