package welldev.io.DAO;

import welldev.io.model.User;

public interface UserDAO {
	public int insertUser(User user);
	public int checkIfUser(String username, String password);
	public int updatePassword(String username, String password);
}
