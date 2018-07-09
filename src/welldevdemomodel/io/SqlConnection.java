package welldevdemomodel.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlConnection {
	private static Connection myconnection= null;
	private static SqlConnection conn=null;
	private static PreparedStatement ps= null;
	private static ResultSet res= null;
	private SqlConnection() {
		
	}
	
	public static SqlConnection connect() {
		
		if(conn==null)
		{
			conn=new SqlConnection();
			getConnection();
		}
		
		return conn;
	}
	public static Connection getConnection() {
		
		try {
			if (myconnection==null) {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
			myconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		}
			catch (SQLException e){
				
				e.printStackTrace();
				
			}
			}
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		return myconnection;
		
	}

	public void INSERT(String sql,String pname ,String price,String quantity) throws SQLException {
		
		ps= myconnection.prepareStatement(sql);
		ps.setString(1, pname);
		ps.setString(2, price);
		ps.setString(3, quantity);
			
		ps.executeUpdate();
	}

	public void DELETE(String sql, String productid) throws SQLException {
		
		ps= myconnection.prepareStatement(sql);
		ps.setString(1, productid);
		ps.executeUpdate();
		
	}

	public void InsertUser(String sql, String username, String password, String country, String name) throws SQLException {
		PreparedStatement ps= myconnection.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, country);
		ps.setString(4, name);
		ps.executeUpdate();
		
	}

	public void UPDATE(String sql, String upname, String uprice, String uquantity, String pid) throws SQLException {
		ps= myconnection.prepareStatement(sql);

		ps.setString(1, upname);
		ps.setString(2, uprice);
		ps.setString(3, uquantity);
		ps.setString(4, pid);
		ps.executeUpdate();
	
	}

	public void UpdatePass(String sql, String newpass, String Id) throws SQLException {
		
		ps= myconnection.prepareStatement(sql);
		ps.setString(1, newpass);
		ps.setString(2, Id);
			
		ps.executeUpdate();

	}

	public ResultSet login(String sql, String username, String password) throws SQLException {
		
		ps = myconnection.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		res = ps.executeQuery();
		
		return res;
		
	}
	

public static void closeConnection() {
		
		conn=null;
	}
	
	
    
}
