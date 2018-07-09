package welldevdemocontroller.io;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDaoImplement;
import util.SqlConnection;
import welldevdemomodel.io.User;


@WebServlet("/UpdatePass")
public class UpdatePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldpass = request.getParameter("opass");
		String newpass = request.getParameter("npass");
		
		HttpSession session = request.getSession();
		
		String password = (String) session.getAttribute("password");
		int Id =       (Integer) session.getAttribute("id");
		
		
		User user= new User();
		UserDaoImplement userDaoImplement = new UserDaoImplement();
		user.setPassword(newpass);
		user.setUserId(Id);
		
		if(password==null)
		{
			request.setAttribute("msg","Login first");
			getServletContext().getRequestDispatcher("/updatepass.jsp").forward(request, response);
		}
		else if(oldpass.isEmpty()||newpass.isEmpty())
		{
			request.setAttribute("msg","Password cannot be null");
			getServletContext().getRequestDispatcher("/updatepass.jsp").forward(request, response);
		}
		
		else if(!oldpass.equals(password))
		{
			request.setAttribute("msg","Old Password is not correct");
			getServletContext().getRequestDispatcher("/updatepass.jsp").forward(request, response);
		}
		
		else {			
			userDaoImplement.updatePassword(user);
				response.sendRedirect("login.jsp");
			
			
		}
	
	}

}
