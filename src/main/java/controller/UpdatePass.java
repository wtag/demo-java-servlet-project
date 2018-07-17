package controller;


import util.Constants;
import java.io.IOException;
import Dao.UserDaoImplement;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(Constants.PATH_UPDATE_PASSWORD)
public class UpdatePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String oldpass = request.getParameter("oldpassword");
		String newpass = request.getParameter("newpassword");
		
		HttpSession session = request.getSession();
		String password = (String) session.getAttribute("password");
		int Id = (Integer) session.getAttribute("id");
		
		User user= new User();
		user.setPassword(newpass);
		user.setUserId(Id);
		UserDaoImplement userDaoImplement = new UserDaoImplement();
		
		if(password==null){
		   request.setAttribute("msg","Login first");
		   getServletContext().getRequestDispatcher("/updatepass.jsp").forward(request, response);
		}
		
		else if(oldpass.isEmpty()||newpass.isEmpty()){
		   request.setAttribute("msg","Password cannot be null");
		   getServletContext().getRequestDispatcher("/updatepass.jsp").forward(request, response);
		}
		
		else if(!oldpass.equals(password)){
		   request.setAttribute("msg","Old Password is not correct");
		   getServletContext().getRequestDispatcher("/updatepass.jsp").forward(request, response);
		}
		
		else {				
		   boolean result = userDaoImplement.updatePassword(user);
			
		   if(result) {
			 session.invalidate();
		     session= null;
		     response.sendRedirect(request.getContextPath());
		   }
			
		   else{
		     request.setAttribute("msg","Password is not updated");
		     getServletContext().getRequestDispatcher("/updatepass.jsp").forward(request, response);
		   }
				
		}
	}
}
