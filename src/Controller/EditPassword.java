package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAOImpl;
import Model.User;
@WebServlet("/editpassword")
public class EditPassword extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        
		UserDAOImpl userDAOImpl=new UserDAOImpl();
		User user=new User();
		HttpSession session;
		session=req.getSession();
		
		String newpass = req.getParameter("password");
		int u_id=(int) session.getAttribute("uid");
		System.out.println(u_id);
		
		user.setPassword(newpass);
		user.setUser_id(u_id);
		
        	userDAOImpl.updatePassword(user);
    		response.sendRedirect("dashboard");

		
	}

}
