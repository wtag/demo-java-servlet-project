package welldev.io.DAO;

import java.util.ArrayList;
import welldev.io.model.Product;

public interface ProductDAO {
	public ArrayList<Product> retrieveAll();
	public int insertProduct(String product_name, int quantity, float price);
	public Product getById(String id);
	public int updateProduct(int id, String product_name, int quantity, float price);
	public int deleteProduct(String product_id);
}
