package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SqlConnection {
	private static Connection connection= null;
	private static SqlConnection instance=null;

	
	private SqlConnection() {
	}
		
	
	public static SqlConnection getInstance() {
		
		if(instance==null)
		{
			instance =new SqlConnection();
		}
		
		return instance;
	}
	public Connection getConnection() {
		
		
		try {
			if (connection==null) {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		}
			catch (SQLException e){
				
				e.printStackTrace();
				
			}
			}
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return connection;
		
	}
		

public static void closeConnection() {
	
	instance=null;
}


	
	
    
}
