package welldevdemocontroller.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import welldevdemomodel.io.SqlConnection;



public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			String name= request.getParameter("name");
			String username= request.getParameter("username");
			String password= request.getParameter("password");
			String country= request.getParameter("country");
			
			PrintWriter out = response.getWriter();
			
			if (name.isEmpty()||username.isEmpty()||password.isEmpty()||country.isEmpty()) {
				
				out.println("One or more fields are empty");
			}
			
			else {
			String sql = "insert into user(username,password,country,name) values (?,?,?,?) ";
			
			SqlConnection con= SqlConnection.connect();
			con.InsertUser(sql,username,password,country,name);
			response.sendRedirect("login.jsp");
			}
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
