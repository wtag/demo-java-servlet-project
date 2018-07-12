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

		int user_Id=(int) session.getAttribute("uid");

		user.setPassword(req.getParameter("password"));
		user.setUser_id(user_Id);

		int flag=userDAOImpl.updatePassword(user);
		if(flag==1) {
			response.sendRedirect("dashboard");
		}
		else {
			response.sendRedirect("updatepassword");
		}
		


	}

}
