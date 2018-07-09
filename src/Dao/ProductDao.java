package Dao;

import welldevdemomodel.io.Product;

public interface ProductDao {
	
	public boolean insertProduct(Product product);
	
	public boolean editProduct(Product product);
	
	public boolean deleteProduct(Product product);

}
