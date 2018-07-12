package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import Model.Constant;
import Model.User;
import Utility.*;
public class UserDAOImpl implements UserDAO {
	PreparedStatement statement=null;
	Connection connection;
	ResultSet resultset=null;
	
	@Override
	public boolean insertUser(User user) {
		Connection connection=DBConnection.getInstance().getConnection();
		boolean flag=false;
		String name=user.getName();
		String password=user.getPassword();
		String username=user.getUsername();
		String country=user.getCountry();
		try {

			statement = connection.prepareStatement(Constant.INSER_USER);
			statement.setString (1, name );
			statement.setString(2,  password);
			statement.setString(3, username); 
			statement.setString(4, country);
			flag=statement.execute();

			System.out.println("successful");

		} catch (SQLException e) {
			
			System.out.println("something wrong" + e);
		}

		return flag;


	}
	public int userLogin(User user) {
   connection=DBConnection.getInstance().getConnection();

		int uid=0;
		String username=user.getUsername();
		String password=user.getPassword();

		try
		{ 
			statement = connection.prepareStatement(Constant.USER_LOGIN);
			statement.setString (1, username );
			statement.setString(2,  password);
			resultset=statement.executeQuery();
			while(resultset.next()) {
				uid=resultset.getInt("id");

			}
		}catch (Exception e) {
			
		}
		return uid;

	}
	public int updatePassword(User user) {
		 connection=DBConnection.getInstance().getConnection();
		 int flag=0;
		int user_Id=user.getUser_id();
		String password=user.getPassword();
		try {

			statement = connection.prepareStatement(Constant.UPDATE_PASSWORD);
			statement.setString (1, password);
			statement.setInt (2,user_Id);
			flag=statement.executeUpdate();

			System.out.println("update successful");
		} catch (SQLException e) {
			System.out.println("something wrong" + e);
		}
		return flag;
	}

}
