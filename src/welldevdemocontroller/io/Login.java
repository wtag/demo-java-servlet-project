package welldevdemocontroller.io;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDaoImplement;
import util.SqlConnection;
import welldevdemomodel.io.User;


public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String username= request.getParameter("username");
			String password= request.getParameter("password");
		

			HttpSession session = request.getSession();
			
			User user= new User();
			UserDaoImplement userDaoImplement = new UserDaoImplement();
			
			user.setUsername(username);
			user.setPassword(password);
			
			int result=userDaoImplement.getUser(user);

			
			if (result>0)
			{
				session.setAttribute("username",username);
				session.setAttribute("password",password);
				session.setAttribute("id",result);
				
				RequestDispatcher rd = request.getRequestDispatcher("Products");
				rd.forward(request, response);	
			}
			
			else
			{
				response.sendRedirect("login.jsp");
			}

		
		
	
		
	}

}
