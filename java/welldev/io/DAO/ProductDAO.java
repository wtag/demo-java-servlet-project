package welldev.io.DAO;

import java.util.List;

import welldev.io.model.Product;

public interface ProductDAO {
	public List<Product> getAllProducts();
	public void insertProduct(Product product);
	public Product getProductById(int id);
	public int updateProduct(int id, Product product);
	public int deleteProductById(int id);
}
