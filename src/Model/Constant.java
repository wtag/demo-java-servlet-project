package Model;

public class Constant {
	public static String INSER_USER=" insert into signup (name, password, username, country)"+ " values (?, ?, ?, ?)";
	public static String USER_LOGIN="select * from signup where username = ? and password = ?";
	public static String UPDATE_PASSWORD= "UPDATE signup SET password = ?" + "WHERE id = ?";
	public static String ADD_PRODUCT=" insert into product (name, quantity, price)" + " values (?, ?, ?)";
	public static String SHOW_PRODUCT= "select * from product";
	public static String UPDATE_PRODUCT="UPDATE product SET name = ? quantity = ?, price= ?" + "WHERE pro_id = ?";
	public static String DELETE_PRODUCT="DELETE FROM product WHERE pro_id = ?";
	public static String GETPRODUCT_BYID= "select * from product where pro_id= ?" ;

}
