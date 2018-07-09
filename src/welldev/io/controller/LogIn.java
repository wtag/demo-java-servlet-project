package welldev.io.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import welldev.io.DAO.Driver;
import welldev.io.model.ProductList;


public class LogIn extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("un", un);
		session.setAttribute("p", pass);
		Driver dr = Driver.getInstance();
		int flag = dr.checkUser(un, pass);
		
		if(flag==1) {
			response.sendRedirect("showdashboard");	
		}
		if(flag == 0) {
			
			request.setAttribute("error", "Wrong User name or password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
