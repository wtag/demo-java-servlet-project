package Dao;

import java.sql.SQLException;

import util.Constans;
import util.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

import welldevdemomodel.io.Product;

public class ProductDaoImplement implements ProductDao{

	@Override
	public boolean insertProduct(Product product) {
		
		try {
		String sql = Constans.INSERT_PRODUCT;
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
			String sql =Constans.EDIT_PRODUCT;
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
			String sql = Constans.DELETE_PRODUCT;
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
