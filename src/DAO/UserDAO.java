package DAO;

import Model.User;

public interface UserDAO {
	public boolean insertUser(User user);
	public boolean updatePassword(User user);
	public int userLogin(User user);
	

}
