package Controller;

import java.io.*;
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jdbc.pool.DataSource;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.sun.xml.internal.bind.v2.runtime.Name;

import DAO.UserDAOImpl;
import Model.User;
import Utility.DBConnection;
import sun.net.www.content.text.plain;
import sun.security.util.Password;


@WebServlet("/login")
public class Login extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession session;
		PrintWriter out=response.getWriter();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		UserDAOImpl userDAOImpl=new UserDAOImpl();



		int user_Id=userDAOImpl.userLogin(user);

		if(user_Id!=0) {
			session=request.getSession();
			session.setAttribute("uid", user_Id);
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			response.sendRedirect("dashboard");
			System.out.println("Login Successful"); 

		}
		else {
			out.println("username and password invalied");

		}

	}


}

