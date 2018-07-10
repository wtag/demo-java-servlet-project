package welldevdemocontroller.io;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDaoImplement;
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

			System.out.println("Login done" + result);
			if (result>0)
			{
				System.out.println("done" + result + request.getContextPath() );
				session.setAttribute("username",username);
				session.setAttribute("password",password);
				session.setAttribute("id",result);
				
				response.sendRedirect(request.getContextPath()+ "/Products");
			}
			
			else
			{
				response.sendRedirect(request.getContextPath());
			}

		
		
	
		
	}

}
