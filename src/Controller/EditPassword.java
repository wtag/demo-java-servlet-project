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

import Model.Driver;
@WebServlet("/editpassword")
public class EditPassword extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		String newpass = req.getParameter("password");
		String id=req.getParameter("uid");
		int u_id=Integer.parseInt(id);
		System.out.println(u_id);
		
		Driver driver=Driver.getInstance();

		driver.updatepassword(newpass, u_id);
		response.sendRedirect("dashboard");
		driver.myConnection();
	}

}
