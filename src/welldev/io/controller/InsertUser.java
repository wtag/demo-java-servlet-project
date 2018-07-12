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
import welldev.io.utility.ConstantStrings;

@WebServlet(ConstantStrings.insertuser)
public class InsertUser extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setCountry(request.getParameter("country"));
		UserDaoImplementation userDao = new UserDaoImplementation();
		int result = userDao.insertUser(user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
	}
	
}
