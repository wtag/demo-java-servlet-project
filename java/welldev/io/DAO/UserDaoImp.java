package welldev.io.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import welldev.io.Constants;
import welldev.io.model.User;

public class UserDaoImp implements UserDAO{
	private static SessionFactory sesssionFactory = new Configuration().configure().buildSessionFactory();
	
	public void insertUser(User user) {
		
		Session session = sesssionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
	}

	public User checkIfUser(String userName, String password) {
		
		Session session = sesssionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(Constants.checkIfUser);
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		if(query.list().size()>0) {
			return (User) query.list().get(0);
		}
		else
			return null;
	}

	public int updatePassword(int id, String changePassword) {
		Session session = sesssionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(Constants.updatePassword);
		query.setParameter("id", id);
		query.setParameter("password", changePassword);
		int updatedRowCount = query.executeUpdate();
		session.close();
		return updatedRowCount;
	}

	public static SessionFactory getSesssionFactory() {
		return sesssionFactory;
	}

}
