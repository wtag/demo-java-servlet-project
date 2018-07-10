package DAO;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import Model.Product;
import Model.User;

public interface ProductDAO {
	public boolean addProduct(Product product);
	public List<Product> showProductList();
	public boolean editProduct(Product product);
	public boolean getProductbyId(Product product);
	public boolean deleteProduct(Product product);

}
