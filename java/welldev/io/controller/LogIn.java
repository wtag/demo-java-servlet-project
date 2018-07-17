package welldev.io.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import welldev.io.DAO.UserDaoImp;
import welldev.io.model.User;
import welldev.io.Constants;

@WebServlet(Constants.checkuser)
public class LogIn extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		UserDaoImp userDao = new UserDaoImp();
		
		User user = userDao.checkIfUser(userName, password);
		
		
		if(user!=null) {
			session.setAttribute("userId", user.getId());
			session.setAttribute("username", userName);
			session.setAttribute("password", password);
			
			response.sendRedirect("ShowDashboard");	
		}
		else {			
			request.setAttribute("error", "Wrong User name or password");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}

}
