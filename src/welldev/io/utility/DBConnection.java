package welldev.io.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	
	public static DBConnection dbConnection;
	//public static Connection myConnection;
	
	public static DBConnection getInstance() {
		if(dbConnection==null) {
			dbConnection = new DBConnection();
			
		}
		return dbConnection;
	}
	
	public Connection getConnection() throws ClassNotFoundException {
		Connection myConnection = null;
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "123456");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		
		return myConnection;
	}

	
	public void closeConnection() {
		dbConnection=null;
	}
}
