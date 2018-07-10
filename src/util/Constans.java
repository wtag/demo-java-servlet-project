package util;


public class Constans {
	
	public static String INSERT_USER ="insert into user(username,password,country,name) values (?,?,?,?)";
	public static String GET_USER = "select username,password,iduser from user where username=? and password=?";
	public static String UPDATE_PASSWORD ="Update user set password=? where iduser=?";
	public static String INSERT_PRODUCT = "insert into product(Name,price,quantity) values (?,?,?) ";
	public static String EDIT_PRODUCT = "Update product set Name=?,Price=?,Quantity=? where productid=?";
	public static String DELETE_PRODUCT = "delete from product where productid=?";

}
