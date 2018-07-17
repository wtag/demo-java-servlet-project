package controller;

import java.io.IOException;
import java.io.PrintWriter;
import Dao.UserDaoImplement;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SignUp")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			String name= request.getParameter("name");
			String username= request.getParameter("username");
			String password= request.getParameter("password");
			String country= request.getParameter("country");
			
			User user= new User();
			user.setName(name);
			user.setUsername(username);
			user.setPassword(password);
			user.setCountry(country);
			
			UserDaoImplement userDaoImplement = new UserDaoImplement();
			
			PrintWriter out = response.getWriter();
			
			if (name.isEmpty()||username.isEmpty()||password.isEmpty()||country.isEmpty()){	
			out.println("One or more fields are empty");
			}
			
			else {
		    boolean result = userDaoImplement.insertUser(user);
		    
		    if(result){
		    response.sendRedirect(request.getContextPath());
		    }
		    
		    else{
		    getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
		    }
			
			}
	
	}

}
