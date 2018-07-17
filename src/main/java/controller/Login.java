package controller;
import util.Constants;
import java.io.IOException;
import Dao.UserDaoImplement;
import model.User;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
			
			User user= new User();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			
			UserDaoImplement userDaoImplement = new UserDaoImplement();
			int result=userDaoImplement.getUser(user);
			
			if (result>0)
			{
				session.setAttribute("username",request.getParameter("username"));
				session.setAttribute("password",request.getParameter("password"));
				session.setAttribute("id",result);
				
				response.sendRedirect(request.getContextPath()+ Constants.PATH_PRODUCT);
			}
			
			else
			{
				response.sendRedirect(request.getContextPath());
			}	
	}

}
