package Dao;

import util.Hibernate;
import util.Constants;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;

import model.Product;

import javax.persistence.Query;

public class ProductDaoImplement implements ProductDao{
	
	private Session session;
  
	@Override
	public boolean insertProduct(Product product) {
		boolean result = false;
        session= Hibernate.openSession();
		try{
		     
			 session.beginTransaction();
			 session.save(product);
			 session.getTransaction().commit();
			 result = true;
	        
	     }catch(Exception ex){
	    	 
	    	 ex.printStackTrace();
	    	 result = false;
	         }
		
	     finally{
	         session.close();
	     }
		
		return result;
	}
	public List<Product> getProducts() {
		
		session= Hibernate.openSession();
		List <Product> products = new ArrayList<Product>();	
		
		try{
		    session.beginTransaction();
		    products = session.createQuery(Constants.GET_PRODUCT).list();  
		    session.getTransaction().commit();
		}
		
		catch(Exception ex){
	    	 ex.printStackTrace();
	    }
		
		finally {
		session.close();
		}
		return products;
	}
	
	@Override
	public boolean editProduct(Product product) {
		boolean result = false;
        session= Hibernate.openSession();
		try{
			 session.beginTransaction();
		     Query edit_product = session.createQuery(Constants.EDIT_PRODUCT);
		     edit_product.setParameter("name", product.getProductName());
		     edit_product.setParameter("price", product.getPrice());
		     edit_product.setParameter("quantity", product.getQuantity());
		     edit_product.setParameter("id", product.getProductId());
		     int value= edit_product.executeUpdate();
			 session.getTransaction().commit();
			 
			 if (value>0) {
				 result = true;
			 }
	        
	     }catch(Exception ex){
	    	 ex.printStackTrace();
	         }
		
	     finally{
	         session.close();
	     }
		
		return result;
	}
	@Override
	public boolean deleteProduct(Product product) {
		
		boolean result = false;
        session= Hibernate.openSession();
		try{
			 session.beginTransaction();
		     Query delete_product = session.createQuery(Constants.DELETE_PRODUCT);
		     delete_product.setParameter("id", product.getProductId());
		     int value=delete_product.executeUpdate();
			 session.getTransaction().commit();
			 result = true;
			 
     		 if (value>0) {
			 result = true;
			 }
	        
	     }catch(Exception ex){
	    	 ex.printStackTrace();
	     }
		
	     finally{
	         session.close();
	     }
		
		return result;
	}

	}
