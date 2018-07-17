package welldev.io.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import welldev.io.DAO.UserDaoImp;


public class UpdatePassword extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer userId =  (Integer) session.getAttribute("userId");
		String password = (String) session.getAttribute("password");
		if(password!=null) {
			UserDaoImp userDao = new UserDaoImp();
			int result = userDao.updatePassword(userId, request.getParameter("change"));
			request.setAttribute("msg", "");
			session.removeAttribute("userId");
			session.removeAttribute("username");
			session.removeAttribute("password");
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}else {
			
			request.setAttribute("msg", "Please Log In First");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("changepass.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
