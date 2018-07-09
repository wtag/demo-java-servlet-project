package welldev.io.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import welldev.io.model.Product;
import welldev.io.model.User;
import welldev.io.utility.DBConnection;

public class UserDaoImplementation implements UserDAO{
	
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	@Override
	public int insertUser(User user) {
		String queryString =  "INSERT INTO user (username, password, name, country)" +
		        "VALUES (?, ?, ?, ?)";
		int success = 0;
		try {
			Connection dbConnection = DBConnection.getInstance().getConnection();
			preparedStatement = dbConnection.prepareStatement(queryString);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getCountry());
			success = preparedStatement.executeUpdate(); 
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public int checkIfUser(String username, String password) {
		int result = 0;
		String sql = "Select * from user where username=? and password=?";
		try {
			Connection dbConnection = DBConnection.getInstance().getConnection();
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				result=1;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int updatePassword(String username, String password) {
		int success = 0;
		String s = "UPDATE user SET password=?"+" where username=?";
		try {
			Connection dbConnection = DBConnection.getInstance().getConnection();
			preparedStatement = dbConnection.prepareStatement(s);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, username);
			success = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

}
