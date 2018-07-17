package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Model.Constant;
import Model.Product;
import Model.User;

public class ProductDAOImpl implements ProductDAO {

	static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public boolean addProduct(Product product) {
		boolean flag = false;
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		}
		return flag;
	}

	public List<Product> showProductList() {
		Session session = factory.openSession();
		List<Product> products = new ArrayList<Product>();
		products = session.createQuery(Constant.SHOW_PRODUCT).list();
		session.close();
		return products;

	}

	public void getProductbyId(Product product) {
		Session session = factory.openSession();
		List<Product> products = new ArrayList<Product>();
		Query query = session.createQuery(Constant.GETPRODUCT_BYID);
		query.setParameter("proId", product.getProId());
		products = query.list();
		if (products.size() == 1) {

			product.setName(products.get(0).getName());
			product.setPrice(products.get(0).getPrice());
			product.setQuantity(products.get(0).getQuantity());

		}

		session.close();

	}

	public int editProduct(Product product) {
		int flag = 0;
		Session session = factory.openSession();
		Query query = session.createQuery(Constant.UPDATE_PRODUCT);
		query.setParameter("name", product.getName());
		query.setParameter("price", product.getPrice());
		query.setParameter("quantity", product.getQuantity());
		query.setParameter("proId", product.getProId());
		session.beginTransaction();
		flag = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return flag;
	}

	public int deleteProduct(Product product) {
		int flag = 0;
		Session session = factory.openSession();
		Query query = session.createQuery(Constant.DELETE_PRODUCT);
		query.setParameter("proId", product.getProId());
		session.beginTransaction();
		flag = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return flag;
	}

}
