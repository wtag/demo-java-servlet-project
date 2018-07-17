package Model;

public class Constant {
	public static String USER_LOGIN = "from User where username=:username and password=:password";
	public static String SHOW_PRODUCT = " from Product";
	public static String GETPRODUCT_BYID = "from Product where proId=:proId";
	public static String UPDATE_PRODUCT = "UPDATE Product set name = :name, price = :price, quantity = :quantity "
			+ "WHERE proId = :proId";
	public static String DELETE_PRODUCT = "DELETE FROM Product WHERE proId = :proId";
	public static String UPDATE_PASSWORD = "UPDATE User set password = :password " + "WHERE userId = :userId";

}
