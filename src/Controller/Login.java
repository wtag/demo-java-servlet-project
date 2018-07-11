package Controller;

import java.io.*;
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jdbc.pool.DataSource;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.sun.xml.internal.bind.v2.runtime.Name;

import Model.Driver;
import sun.security.util.Password;


@WebServlet("/login")
public class Login extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ResultSet rs = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String user1=null;
		String pass1=null;
		int uid=0;
		HttpSession session;
		PrintWriter out=response.getWriter();

		Driver driver=Driver.getInstance();


		try {
			String query = "select * from signup";
			rs=driver.select(query);

			while(rs.next()) {
				user1=rs.getString("username");
				pass1=rs.getString("password");
				if(user1.equals(username)&& pass1.equals(password)){
					uid=rs.getInt("id");
					session=request.getSession();
					session.setAttribute("uid", uid);
					session.setAttribute("username", username);
					session.setAttribute("password", password);
					response.sendRedirect("dashboard");
					System.out.println("Login Successful"); 
					System.out.println("username"+user1+"pass"+pass1);


				} 
				else {
					out.println("username and password invalied");

				}

			}

		} catch (SQLException e) {
			System.out.println("something wrong" + e);
		}


		driver.myConnection();
	}


}

