package welldev.io.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import welldev.io.DAO.Driver;

@WebServlet("/dashboard")
public class InsertUser extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n = request.getParameter("name");
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		String coun = request.getParameter("country");
		
		String query =  "INSERT INTO user (username, password, name, country)" +
		        "VALUES (?, ?, ?, ?)";
		
		Driver dr= Driver.getInstance();
		
		dr.insertUser(query, n, un, pass, coun);
	
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	
}
