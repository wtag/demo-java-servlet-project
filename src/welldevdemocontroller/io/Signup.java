package welldevdemocontroller.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDaoImplement;
import util.SqlConnection;
import welldevdemomodel.io.User;



public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			String name= request.getParameter("name");
			String username= request.getParameter("username");
			String password= request.getParameter("password");
			String country= request.getParameter("country");
			
			PrintWriter out = response.getWriter();
			
			User user= new User();
			UserDaoImplement userDaoImplement = new UserDaoImplement();
			user.setName(name);
			user.setUsername(username);
			user.setPassword(password);
			user.setCountry(country);
			
			
			if (name.isEmpty()||username.isEmpty()||password.isEmpty()||country.isEmpty()) {
				
				out.println("One or more fields are empty");
			}
			
			else {
			
		    boolean result = userDaoImplement.insertUser(user);
		    if(result)
		    {
		    	out.println("Sign up Successful");
		    	response.sendRedirect("login.jsp");
		    }
		    
		    else
		    {
		    	out.println("Sign up Failed");
		    	response.sendRedirect("signup.jsp");
		    }
			
			}
			
		
		
		
	}

}
