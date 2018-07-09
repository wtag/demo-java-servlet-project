package welldev.io.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import welldev.io.DAO.UserDaoImplementation;

@WebServlet("/updatepasswerd")
public class UpdatePasswerd extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		
		if(password!=null) {
			UserDaoImplementation userDao = new UserDaoImplementation();
			int result = userDao.updatePassword(username, request.getParameter("change"));
			request.setAttribute("msg", "");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}else {
			
			request.setAttribute("msg", "Please Log In First");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("changepass.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}

}
