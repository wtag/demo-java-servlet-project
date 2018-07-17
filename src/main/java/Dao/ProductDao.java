package Dao;

import java.util.List;

import model.Product;

public interface ProductDao {
	
	public boolean insertProduct(Product product);
	
	public boolean editProduct(Product product);
	
	public boolean deleteProduct(Product product);
	
	public List<Product> getProducts();

}
