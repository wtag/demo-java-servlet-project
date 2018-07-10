package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Constant;
import Model.Product;
import Model.User;
import Utility.DBConnection;

public class ProductDAOImpl implements ProductDAO {
	private Connection dbConnection = DBConnection.getInstance().getConnection();
	PreparedStatement statement=null;
	ResultSet resultSet=null;
	@Override
	public boolean addProduct(Product product) {
		Connection connection=DBConnection.getInstance().getConnection();
		String name=product.getName();
		String quantity=product.getQuantity();
		String price=product.getPrice();
		try {

			statement = connection.prepareStatement(Constant.ADD_PRODUCT);
			statement.setString (1, name);
			statement.setString (2, quantity);
			statement.setString (3, price);

			statement.execute();

			System.out.println("successful");


		} catch (SQLException e) {
			System.out.println("something wrong" + e);
		}
		return true;
		
	}
	@Override
	public List<Product> showProductList() {
		Connection connection=DBConnection.getInstance().getConnection();
		List<Product> productList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(Constant.SHOW_PRODUCT);
			resultSet = statement.executeQuery(Constant.SHOW_PRODUCT);
			while (resultSet.next()) {
				Product product=new Product();
				int id = resultSet.getInt("pro_id");
				String name = resultSet.getString("name");
				String price = resultSet.getString("price");
				String quantity = resultSet.getString("quantity");
				product.setPid(id);
				product.setName(name);
				product.setPrice(price);
				product.setQuantity(quantity);
				productList.add(product);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return productList;
	}
	public boolean getProductbyId(Product product) {
		Connection connection=DBConnection.getInstance().getConnection();
		int pro_id=product.getPid();
		try {
		
			statement = connection.prepareStatement(Constant.GETPRODUCT_BYID);
			statement.setInt(1, pro_id);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				String name = resultSet.getString("name");
				String quantity = resultSet.getString("quantity");
				String price = resultSet.getString("price");
				

				product.setName(name);
				product.setQuantity(quantity);
				product.setPrice(price);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return true;
	}
	public boolean editProduct(Product product) {
		Connection connection=DBConnection.getInstance().getConnection();
		String name=product.getName();
		String quantity=product.getQuantity();
		String price=product.getPrice();
		int pro_id=product.getPid();
		try {
               
				statement = connection.prepareStatement(Constant.UPDATE_PRODUCT);
				statement = connection.prepareStatement(Constant.UPDATE_PRODUCT);
				statement.setString (1, name);
				statement.setString (2, quantity);
				statement.setString (3, price);
				statement.setInt(4, pro_id);

				statement.executeUpdate();

				System.out.println("update successful");
			} catch (SQLException e) {
				System.out.println("something wrong" + e);
			}
		return true;
	}
	public boolean deleteProduct(Product product) {
		Connection connection=DBConnection.getInstance().getConnection();
		int pro_id=product.getPid();
		try  {

			statement=connection.prepareStatement(Constant.DELETE_PRODUCT);
			statement.setInt(1,pro_id);
			statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return true;
	}
  
}
