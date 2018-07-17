package welldev.io.DAO;

import welldev.io.model.User;

public interface UserDAO {
	public void insertUser(User user);
	public User checkIfUser(String userName, String password);
	public int updatePassword(int id, String changePassword);
}
