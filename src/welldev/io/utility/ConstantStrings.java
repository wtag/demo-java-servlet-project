package welldev.io.utility;

public final class ConstantStrings {
	
	public static final String login = "Select * from user where username=? and password=?";
	public static final String signup = "INSERT INTO user (username, password, name, country) VALUES (?, ?, ?, ?)";
	public static final String updatePassword = "UPDATE user SET password=?"+" where username=?";
	public static final String allProduct = "SELECT * FROM product";
	public static final String insertProduct = "INSERT INTO product (product_name, quantity, price)" +
    "VALUES (?, ?, ?)";
	public static final String getProductById = "Select * from product where id=?";
	public static final String updateProduct = "UPDATE product SET product_name=?, quantity=?, price=?"+" where id=?";
	public static final String deleteProduct = "delete from product where id=?";
	
	public static final String showdashboard = "/showdashboard";
	public static final String changepassword = "/changepassword";
	public static final String deletepro = "/deleteproduct";
	public static final String editproduct = "/editproduct";
	public static final String addproduct = "/addproduct";
	public static final String insertproduct = "/insertproduct";
	public static final String insertuser = "/dashboard";
	public static final String logout = "/logout";
	public static final String signupuri = "/signup";
	public static final String updatepassword = "/updatepasswerd";
}
