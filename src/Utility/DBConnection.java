package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DisposableConnectionFacade;

public class DBConnection {
	public static DBConnection dbConnection;
	public static Connection connection;
	public static PreparedStatement statement;
	private DBConnection() {
	
	}
	public static DBConnection getInstance() {
		if(null==dbConnection) {
			dbConnection=new DBConnection();
			dbConnection.bdConnection();
		}
		return dbConnection;
	}
	public Connection bdConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver found");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found"+e);
		}
		String url="jdbc:mysql://localhost:3306/dbname";
		String user="root";
		String password ="root";

		try {
			connection = DriverManager.getConnection(url, user, password);

			System.out.println("successful");
		} catch (SQLException e) {
			System.out.println("something wrong" + e);;
		}

		return connection;
	}
	public Connection getConnection() {
		return dbConnection.bdConnection(); 
	}
	
}
