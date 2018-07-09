package welldev.io.DAO;


import java.sql.*;

public class Driver {
	private static Driver driver;
	private static Connection myConn;
	private static PreparedStatement preparedStatement;
	private static Statement stmt;
	private static ResultSet rs;
	
	public static Driver getInstance() {
		if(driver==null) {
			driver = new Driver();
			try {
				myConn = connect();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
		return driver;
	}
	
	public static Connection connect() throws ClassNotFoundException {
		if(myConn==null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "123456");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return myConn;
	}
	
	public void insertUser(String str, String n, String un, String pass, String coun) {
		try {
			
			preparedStatement = myConn.prepareStatement(str);
			preparedStatement.setString(1, un);
			preparedStatement.setString(2, pass);
			preparedStatement.setString(3, n);
			preparedStatement.setString(4, coun);
			preparedStatement.executeUpdate(); 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public int checkUser(String username, String password) {
		int result = 0;
		String sql = "Select * from user where username=? and password=?";
		try {
			preparedStatement = myConn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				result=1;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ResultSet retrieveAll(String table) {
		
		try {
			
			stmt = myConn.createStatement();
			String q = "SELECT * FROM "+table;
			rs = stmt.executeQuery(q);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public void updatePassword(String u, String p) {
		
		String s = "UPDATE user SET password=?"+" where username=?";
		try {
			
			preparedStatement = myConn.prepareStatement(s);
			preparedStatement.setString(1, p);
			preparedStatement.setString(2, u);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	
	public void insertProduct(String pn, int q, float p) {
		
		try {
			String str = "INSERT INTO product (product_name, quantity, price)" +
			        "VALUES (?, ?, ?)";
			preparedStatement = myConn.prepareStatement(str);
			preparedStatement.setString(1, pn);
			preparedStatement.setInt(2, q);
			preparedStatement.setFloat(3, p);
			
			preparedStatement.executeUpdate(); 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public ResultSet getById(String id) {

		String s = "Select * from product where id=?";
		
		try {
			preparedStatement = myConn.prepareStatement(s);
			preparedStatement.setInt(1, Integer.parseInt(id));
			rs = preparedStatement.executeQuery();
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	
	public void updateProduct(int id, String name, int quantity, float price) {
		
		String s = "UPDATE product SET product_name=?, quantity=?, price=?"+" where id=?";
		try {
			preparedStatement = myConn.prepareStatement(s);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, quantity);
			preparedStatement.setFloat(3, price);
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}
		
	}
	
	public void deleteProduct(String pid) {
		
		String s = "delete from product where id=?";
		try {
			preparedStatement = myConn.prepareStatement(s);
			preparedStatement.setInt(1, Integer.parseInt(pid));
			preparedStatement.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	
	}
	
	public void closeConnection() {
		driver=null;
	}
	
}


