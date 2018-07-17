package welldev.io.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import welldev.io.Constants;
import welldev.io.model.Product;

public class ProductDaoImp implements ProductDAO{
	private static SessionFactory sesssionFactory = new Configuration().configure().buildSessionFactory();
	
	public List<Product> getAllProducts() {
		
		Session session = ProductDaoImp.getSesssionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(Constants.getAllProduct);
		ArrayList<Product> product_list = (ArrayList<Product>) query.list();
		session.close();
		
		return product_list;
	}

	public void insertProduct(Product product) {
		
		Session session = ProductDaoImp.getSesssionFactory().openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
		//sesssionFactory.close();
		
	}

	public Product getProductById(int id) {
		
		Session session = ProductDaoImp.getSesssionFactory().openSession();
		session.beginTransaction();
		Product product = session.get(Product.class, id);
		return product;
	}

	public int updateProduct(int id, Product product) {
		
		Session session = ProductDaoImp.getSesssionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(Constants.updateProductById);
		query.setParameter("name", product.getName());
		query.setParameter("quantity", product.getQuantity());
		query.setParameter("price", product.getPrice());
		query.setParameter("id", id);
		int changedRow = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		
		return changedRow;
	}

	public int deleteProductById(int id) {
		
		Session session = ProductDaoImp.getSesssionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(Constants.deleteProductById);
		query.setParameter("id", id);
		int changedRow=query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		
		return changedRow;
	}

	public static SessionFactory getSesssionFactory() {
		return sesssionFactory;
	}

	
}
