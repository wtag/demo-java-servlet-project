package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sun.security.jca.GetInstance;

public class Driver {
	public static Driver driver;
	public static Connection connection;
	public static  ResultSet resultSet;
	PreparedStatement statement=null;
	private Driver() {
		//constructor
	}
	public static Driver getInstance() {
		if(null==driver) {
			driver=new Driver();
			driver.bdConnection();
		}
		return driver;
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
	public PreparedStatement insert(String name, String password, String username, String country) {


		try {
			Connection connection = driver.bdConnection(); 
			String query = " insert into signup (name, password, username, country)"
					+ " values (?, ?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setString (1, name );
			statement.setString(2,  password);
			statement.setString(3, username); 
			statement.setString(4, country);
			statement.execute();

			System.out.println("successful");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("something wrong" + e);
		}

		return statement;

	}

	public PreparedStatement delete(int pid)
	{
		
		try  {

			connection = driver.bdConnection();
			String sql= "DELETE FROM product WHERE pro_id = ?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1,pid);
			statement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return statement;
	}

	public ResultSet getproductbyId(int pid) {
		PreparedStatement statement=null;

		try {
			connection = driver.bdConnection(); 
			String sql = "select * from product where pro_id= ?" ;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pid);
			resultSet = statement.executeQuery();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return resultSet;
	}
	public PreparedStatement updateproduct(String ename,String equantity,String eprice, int nid)
	{
		try {
			connection = driver.bdConnection();
			String query = "UPDATE product SET name = ?, quantity = ?, price= ?" + 
					"WHERE pro_id = ?";

			
			statement = connection.prepareStatement(query);
			statement.setString (1, ename);
			statement.setString (2, equantity);
			statement.setString (3, eprice);
			statement.setInt(4, nid);

			statement.executeUpdate();

			System.out.println("update successful");
		} catch (SQLException e) {
			System.out.println("something wrong" + e);
		}
		return statement;
	}
	public ResultSet select(String query)
	{
		
		try {
			connection = driver.bdConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return resultSet;
	}
	public PreparedStatement updatepassword(String pass, int uid)
	{
		try {

			String query = "UPDATE signup SET password = ?" + 
					"WHERE id = ?";

			
			statement = connection.prepareStatement(query);
			statement.setString (1, pass);
			statement.setInt (2, uid);

			
			statement.executeUpdate();

			System.out.println("update successful");
		} catch (SQLException e) {
			System.out.println("something wrong" + e);
		}
		return statement;
	}
	public PreparedStatement addproduct(String name,String quantity, String price)
	{
		 connection = driver.bdConnection();
		try {
			String query = " insert into product (name, quantity, price)"
					+ " values (?, ?, ?)";
		
			statement = connection.prepareStatement(query);
			statement.setString (1, name);
			statement.setString (2, quantity);
			statement.setString (3, price);

			statement.execute();

			System.out.println("successful");
		

		} catch (SQLException e) {
			System.out.println("something wrong" + e);
		}
		return statement;
	}
	public void myConnection() {
		
		driver=null;
		
	}
	
}
