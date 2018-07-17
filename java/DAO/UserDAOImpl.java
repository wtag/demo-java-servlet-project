package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Model.Constant;
import Model.User;

public class UserDAOImpl implements UserDAO {
	static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public boolean insertUser(User user) {
		boolean flag = false;
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		}
		return flag;

	}

	public int userLogin(User user) {
		int userId = 0;
		Session session = factory.openSession();
		try {
			Query query = session.createQuery(Constant.USER_LOGIN);
			query.setParameter("username", user.getUsername());
			query.setParameter("password", user.getPassword());
			System.out.println("name" + user.getUsername() + "pass" + user.getPassword());
			List<User> users = (List<User>) query.list();

			System.out.println("resultset:" + users.toString());

			if (users.size() == 1) {
				userId = users.get(0).getUserId();
			}

			System.out.println(userId);
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return userId;

	}

	public int updatePassword(User user) {
		int flag = 0;
		Session session = factory.openSession();
		Query query = session.createQuery(Constant.UPDATE_PASSWORD);
		query.setParameter("password", user.getPassword());
		query.setParameter("userId", user.getUserId());
		session.beginTransaction();
		flag = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return flag;
	}

}
