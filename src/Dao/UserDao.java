package Dao;

import welldevdemomodel.io.User;


public interface UserDao {
	
	public boolean insertUser(User user);
	public int getUser(User user);
	public boolean updatePassword(User user);
	

}
