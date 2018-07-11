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
@WebServlet("/updateproduct")
public class UpdateProduct extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		Driver driver = Driver.getInstance();
		
		String ename = req.getParameter("ename");
		String equantity = req.getParameter("equantity");
		String eprice=req.getParameter("eprice");
		String eid=req.getParameter("eid");
		int nid=Integer.parseInt(eid);

		driver.updateproduct(ename, equantity, eprice, nid);
		response.sendRedirect("dashboard");
	}

}
