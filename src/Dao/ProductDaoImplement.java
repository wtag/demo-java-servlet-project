package Dao;

import java.sql.SQLException;

import util.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

import welldevdemomodel.io.Product;

public class ProductDaoImplement implements ProductDao{

	@Override
	public boolean insertProduct(Product product) {
		
		try {
		String sql = "insert into product(Name,price,quantity) values (?,?,?) ";
		Connection connection = SqlConnection.getInstance().getConnection();
		PreparedStatement ps= connection.prepareStatement(sql);
		ps.setString(1, product.getProductName());
		ps.setInt(2, product.getPrice());
		ps.setInt(3, product.getQuantity());	
		ps.executeUpdate();
		
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean editProduct(Product product) {
		try {
			String sql ="Update product set Name=?,Price=?,Quantity=? where productid=?";
			Connection connection = SqlConnection.getInstance().getConnection();
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setInt(2, product.getPrice());
			ps.setInt(3, product.getQuantity());
			ps.setInt(4, product.getProductId());
			ps.executeUpdate();
			
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return true;
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			String sql = "delete from product where productid=?";
			Connection connection = SqlConnection.getInstance().getConnection();
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setInt(1, product.getProductId());
			ps.executeUpdate();
			
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return true;
	
	}

}
