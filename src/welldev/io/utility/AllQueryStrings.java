package welldev.io.utility;

public final class AllQueryStrings {
	
	public static final String login = "Select * from user where username=? and password=?";
	public static final String signup = "INSERT INTO user (username, password, name, country) VALUES (?, ?, ?, ?)";
	public static final String updatePassword = "UPDATE user SET password=?"+" where username=?";
	public static final String allProduct = "SELECT * FROM product";
	public static final String insertProduct = "INSERT INTO product (product_name, quantity, price)" +
    "VALUES (?, ?, ?)";
	public static final String getProductById = "Select * from product where id=?";
	public static final String updateProduct = "UPDATE product SET product_name=?, quantity=?, price=?"+" where id=?";
	public static final String deleteProduct = "delete from product where id=?";
}
