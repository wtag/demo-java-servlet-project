package welldev.io.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import welldev.io.DAO.UserDaoImplementation;
import welldev.io.model.User;

@WebServlet("/dashboard")
public class InsertUser extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		User user = new User();
		user.setName(name);
		user.setUserName(userName);
		user.setPassword(password);
		user.setCountry(country);
		UserDaoImplementation userDao = new UserDaoImplementation();
		int result = userDao.insertUser(user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
	}
	
}
