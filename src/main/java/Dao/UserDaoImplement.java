package Dao;


import util.Constants;
import util.Hibernate;
import java.util.List;

import org.hibernate.Session;

import model.User;

import javax.persistence.Query;


public class UserDaoImplement implements UserDao{
	
	    private Session session;
	

	public boolean insertUser(User user) {
           boolean result = false;
           session= Hibernate.openSession();
           
		try{
			 session.beginTransaction();
			 session.save(user);
			 session.getTransaction().commit();
			 result = true;
	        
	     }catch(Exception ex){
	    	 result = false;
	    	 ex.printStackTrace();
	     }
		
	     finally{
	         session.close();
	     }
		
		return result;
		
	}

	public int getUser(User user) {
		
		int id=0;
		session= Hibernate.openSession();
		try{
		
		session.beginTransaction();
		Query query = session.createQuery(Constants.GET_USER);
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());
		List <User> users = (List<User>) query.getResultList();
		
		for (User userlist : users)
		{
			user.setUsername(userlist.getUsername());
			user.setPassword(userlist.getPassword());
			id=userlist.getUserId();
			user.setUserId(userlist.getUserId());
			user.setCountry(userlist.getCountry());
		}
		
		
		session.getTransaction().commit();
		}
		
		catch(Exception ex){
	    	 ex.printStackTrace();
	    }
		
		finally {
		session.close();
		}
		return id;
	}

	@Override
	public boolean updatePassword(User user) {
		boolean result= false;
		session= Hibernate.openSession();
		try {
			
		session.beginTransaction();
		
		Query query = session.createQuery(Constants.UPDATE_PASSWORD);
	     query.setParameter("password", user.getPassword());
	     query.setParameter("id", user.getUserId());
	     int value=query.executeUpdate();
	     session.getTransaction().commit();
	     
		 if (value>0){
			 result = true;
		 }
	
		}
		catch(Exception ex){
	    	 ex.printStackTrace();
	    }
		
		finally {
		session.close();
		}
		return result;
	}


}
