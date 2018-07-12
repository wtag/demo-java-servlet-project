package welldev.io.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import welldev.io.model.Product;
import welldev.io.utility.ConstantStrings;
import welldev.io.utility.DBConnection;

public class ProductDAOImplementation implements ProductDAO{
	
	private static PreparedStatement preparedStatement;
	private static Statement statement;
	private static ResultSet resultSet;

	@Override
	public ArrayList<Product> retrieveAll() {
		Connection dbConnection = null;
		ArrayList<Product>productList = new ArrayList<>();
		try {
			dbConnection = DBConnection.getInstance().getConnection();
			statement = dbConnection.createStatement();
			
			resultSet = statement.executeQuery(ConstantStrings.allProduct);
			while(resultSet.next()) {
				Product pl = new Product();
				pl.setId(resultSet.getInt("id"));
				pl.setName(resultSet.getString("product_name"));
				pl.setPrice(resultSet.getFloat("price"));
				pl.setQuantity(resultSet.getInt("quantity"));
				productList.add(pl);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public int insertProduct(String product_name, int quantity, float price) {
		int success = 0;
		Connection dbConnection =null;
		try {
			dbConnection = DBConnection.getInstance().getConnection();
			
			preparedStatement = dbConnection.prepareStatement(ConstantStrings.insertProduct);
			preparedStatement.setString(1, product_name);
			preparedStatement.setInt(2, quantity);
			preparedStatement.setFloat(3, price);
			
			success = preparedStatement.executeUpdate(); 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public Product getById(String id) {
		Connection dbConnection = null;
		Product product = new Product();
		try {
			dbConnection = DBConnection.getInstance().getConnection();
			preparedStatement = dbConnection.prepareStatement(ConstantStrings.getProductById);
			preparedStatement.setInt(1, Integer.parseInt(id));
			resultSet = preparedStatement.executeQuery();			
			
			while(resultSet.next()) {
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("product_name"));
				product.setQuantity(resultSet.getInt("quantity"));
				product.setPrice(resultSet.getFloat("price"));
			}
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public int updateProduct(int id, String product_name, int quantity, float price) {
		int success = 0;
		Connection dbConnection = null;
		
		try {
			dbConnection = DBConnection.getInstance().getConnection();
			preparedStatement = dbConnection.prepareStatement(ConstantStrings.updateProduct);
			preparedStatement.setString(1, product_name);
			preparedStatement.setInt(2, quantity);
			preparedStatement.setFloat(3, price);
			preparedStatement.setInt(4, id);
			success = preparedStatement.executeUpdate();
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public int deleteProduct(String product_id) {
		int success = 0;
		Connection dbConnection = null;
		
		try {
			dbConnection = DBConnection.getInstance().getConnection();
			preparedStatement = dbConnection.prepareStatement(ConstantStrings.deleteProduct);
			preparedStatement.setInt(1, Integer.parseInt(product_id));
			success = preparedStatement.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

}
