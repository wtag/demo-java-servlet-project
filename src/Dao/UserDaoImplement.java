package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.SqlConnection;
import welldevdemomodel.io.User;

public class UserDaoImplement implements UserDao{


	@Override
	public boolean insertUser(User user) {
		try {
		Connection connection= SqlConnection.getInstance().getConnection();
		String sql = "insert into user(username,password,country,name) values (?,?,?,?) ";
		PreparedStatement ps= connection.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getCountry());
		ps.setString(4, user.getName());
		ps.executeUpdate();
		
		}
		
		catch (SQLException e)
		{
			e.printStackTrace();	
		}
		return true;
	}

	@Override
	public int getUser(User user) {
		int Id = 0;
		try {
			Connection connection= SqlConnection.getInstance().getConnection();
			String sql = "select username,password,iduser from user where username=? and password=?";
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet res = ps.executeQuery();
			
			
			
			while(res.next())
			{
				user.setUsername(res.getString("username"));
				user.setPassword(res.getString("password"));
				Id= res.getInt("iduser");
				user.setUserId(Id);
				
			}
			
			}
			
			catch (SQLException e)
			{
				e.printStackTrace();	
			}
			
			return Id;
	
	}

	@Override
	public boolean updatePassword(User user) {
		try {
		Connection connection= SqlConnection.getInstance().getConnection();
		String sql = "Update user set password=? where iduser=?";
		PreparedStatement ps= connection.prepareStatement(sql);
		ps.setString(1, user.getPassword());
		ps.setInt(2, user.getUserId());	
		ps.executeUpdate();
		}
		
		catch (SQLException e)
		{
			e.printStackTrace();	
		}
		return true;
	}

}
