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
	PreparedStatement statement=null;
	ResultSet resultSet=null;
	

	@Override
	public boolean addProduct(Product product) {
		Connection connection=DBConnection.getInstance().getConnection();
            boolean flag=false;
		try {

			statement = connection.prepareStatement(Constant.ADD_PRODUCT);
			statement.setString (1, product.getName());
			statement.setString (2, product.getQuantity());
			statement.setString (3, product.getPrice());

			flag=statement.execute();


		} catch (SQLException e) {
			System.out.println("something wrong" + e);
		}
		finally {
			DBConnection.getInstance().colseConnection();
		}
		return flag;

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
				product.setProId(resultSet.getInt("pro_id"));;
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getString("price"));
				product.setQuantity(resultSet.getString("quantity"));
				productList.add(product);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return productList;
	}
	public void getProductbyId(Product product) {
		Connection connection=DBConnection.getInstance().getConnection();
		int pro_Id=product.getProId();
		try {

			statement = connection.prepareStatement(Constant.GETPRODUCT_BYID);
			statement.setInt(1, pro_Id);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				product.setName(resultSet.getString("name"));
				product.setQuantity(resultSet.getString("quantity"));
				product.setPrice(resultSet.getString("price"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	
	}
	public int editProduct(Product product) {
		Connection connection=DBConnection.getInstance().getConnection();
		int flag=0;
		try {

			statement = connection.prepareStatement(Constant.UPDATE_PRODUCT);
			statement.setString (1, product.getName());
			statement.setString (2,product.getQuantity());
			statement.setString (3, product.getPrice());
			statement.setInt(4, product.getProId());

			flag=statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("something wrong" + e);
		}
		return flag;
	}
	public int deleteProduct(Product product) {
		Connection connection=DBConnection.getInstance().getConnection();
		int flag=0;
		int pro_Id=product.getProId();
		try  {

			statement=connection.prepareStatement(Constant.DELETE_PRODUCT);
			statement.setInt(1,pro_Id);
			flag=statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

}
