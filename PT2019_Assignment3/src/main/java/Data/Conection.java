package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conection {

	 private static Conection instance = new Conection();
	    public static final String URL = "jdbc:mysql://localhost:3306/tema3";
	    public static final String USER = "root";
	    public static final String PASSWORD = "";
	    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
	
	//private static Conection singleInstance = new Conection();
	
	    public Conection() {
	        try {
	            Class.forName(DRIVER_CLASS);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	     
	    public Connection createConection() {
	        Connection connection = null;
	        try {
	            connection = DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return connection;
	    }   
	     
//	    public Conection getConnection() {
//	        return (Conection) instance.createConnection();
//	    }
//	    public static void close(Connection connection) {
//	        if (connection != null) {
//	            try {
//	                connection.close();
//	            } catch (SQLException e) {
//	                /*Ignore*/
//	            }
//	        }
//	    }
	
}
