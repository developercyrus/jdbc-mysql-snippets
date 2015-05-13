package javase.jdbc.mysql.example1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	
    public static void insert() {    	
    	Date d = new Date();
    	SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
    	try {
	        MysqlConnection db = new MysqlConnection();
	        Connection conn = db.getConnection();
	        Statement stmt = conn.createStatement();
	        stmt.executeUpdate("insert into javase_jdbc_mysql_example1.student(firstname, create_date) values ('sam', '" + sdf.format(d) +"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static String select() {    	
    	try {
	        MysqlConnection db = new MysqlConnection();
	        Connection conn = db.getConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("select firstname from javase_jdbc_mysql_example1.student");
	        if (rs.next()) {
	        	return rs.getString("firstname");
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public static void main(String[] args) {
    	insert();
    	System.out.println(select());
    }
}
