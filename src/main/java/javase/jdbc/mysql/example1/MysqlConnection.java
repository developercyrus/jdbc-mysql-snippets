package javase.jdbc.mysql.example1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    Connection conn = null;
    
    public MysqlConnection() {
        String protocol = "mysql";
        String servername = "localhost";
        String port = "3306";
        String databasename = "javase_jdbc_mysql_example1";
        String username = "root";
        String password = "";            
        String CONNECTION = "jdbc:" + protocol + "://" + servername + ":" + port + "/" + databasename;         
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        
        try {
            Class.forName(DRIVER_NAME);
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            System.out.println(CONNECTION);
            conn = DriverManager.getConnection(CONNECTION, username, password);
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return conn;
    }
}

