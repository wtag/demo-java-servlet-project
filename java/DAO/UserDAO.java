package DAO;

import Model.User;

public interface UserDAO {
	public boolean insertUser(User user);

	public int updatePassword(User user);

	public int userLogin(User user);

}
