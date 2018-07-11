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

@WebServlet("/deleteproduct")
public class DeleteProduct extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {

		Driver driver = Driver.getInstance();
		
		String id=req.getParameter("id");
		System.out.println(id);
		int pid=Integer.parseInt(id);
		System.out.println(pid);
		driver.delete(pid);

		res.sendRedirect("dashboard");
		driver.myConnection();

	}

}
