package DAO;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import Model.Product;
import Model.User;

public interface ProductDAO {
	public boolean addProduct(Product product);
	public List<Product> showProductList();
	public int editProduct(Product product);
	public void getProductbyId(Product product);
	public int deleteProduct(Product product);

}
