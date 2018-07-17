package util;


public class Constants {
	
	
	public static String GET_USER = "from User where username=:username and password=:password";
	public static String UPDATE_PASSWORD ="Update User set password=:password where userId=:id";
	public static String EDIT_PRODUCT = "Update Product set productName=:name,price=:price,quantity=:quantity where productId=:id";
	public static String DELETE_PRODUCT = "delete from Product where productId=:id";
	public static String GET_PRODUCT = "from Product";
	
	
	public static final String PATH_UPDATE_PASSWORD = "/UpdatePass";
	public static final String PATH_PRODUCT = "/Products";
	public static final String PATH_PRODUCT_ADD ="/HibernateProject/ProductAdd";
	public static final String PATH_PASSWORD_UPDATE ="/HibernateProject/PasswordUpdate";
	public static final String PATH_LOGOUT ="/HibernateProject/Logout";
	public static final String PATH_EDIT_PRODUCT = "/EditProduct";
	public static final String PATH_DELETE_PRODUCT = "/DeleteProduct";
	public static final String LOGOUT = "/Logout";

}
