package welldev.io.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import welldev.io.DAO.UserDaoImplementation;

public class LogIn extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		UserDaoImplementation userDao = new UserDaoImplementation();
		int flag = userDao.checkIfUser(userName, password);
		
		if(flag==1) {
			session.setAttribute("username", userName);
			session.setAttribute("password", password);
			
			response.sendRedirect("showdashboard");	
		}
		if(flag == 0) {			
			request.setAttribute("error", "Wrong User name or password");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
