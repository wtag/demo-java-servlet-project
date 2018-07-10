package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Constant;
import Model.User;
import Utility.*;
public class UserDAOImpl implements UserDAO {
	private Connection dbConnection = DBConnection.getInstance().getConnection();
	PreparedStatement statement=null;
	ResultSet resultset=null;
	@Override
	public boolean insertUser(User user) {
		Connection connection=DBConnection.getInstance().getConnection();
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
			statement.execute();

			System.out.println("successful");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("something wrong" + e);
		}

		return true;


	}
	public int userLogin(User user) {
		Connection connection=DBConnection.getInstance().getConnection();

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
			// TODO: handle exception
		}
		return uid;

	}
	public boolean updatePassword(User user) {
		Connection connection=DBConnection.getInstance().getConnection();
		int user_id=user.getUser_id();
		String password=user.getPassword();
		try {

			statement = connection.prepareStatement(Constant.UPDATE_PASSWORD);
			statement.setString (1, password);
			statement.setInt (2,user_id);
			statement.executeUpdate();

			System.out.println("update successful");
		} catch (SQLException e) {
			System.out.println("something wrong" + e);
		}
		return true;
	}

}
