package welldev.io.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import welldev.io.DAO.UserDaoImp;
import welldev.io.model.User;
import welldev.io.Constants;

@WebServlet(Constants.insertuseruri)
public class InsertUser extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User newUser = new User();
		newUser.setName(request.getParameter("name"));
		newUser.setUserName(request.getParameter("username"));
		newUser.setPassword(request.getParameter("password"));
		newUser.setCountry(request.getParameter("country"));
		UserDaoImp userDao = new UserDaoImp();
		userDao.insertUser(newUser);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
	}


}
