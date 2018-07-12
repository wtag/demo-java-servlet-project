package Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utility.DBConnection;
import Model.*;
import DAO.*;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		PrintWriter out=res.getWriter();
		User user=new User();
		user.setName( req.getParameter("name"));
		user.setPassword(req.getParameter("password"));
		user.setUsername(req.getParameter("username"));
		user.setCountry(req.getParameter("country"));

		UserDAOImpl userActivity=new UserDAOImpl();

         
		boolean flag=userActivity.insertUser(user);
        if(flag==true)
        {
        	RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
    		rd.forward(req, res);
        }
        else {
        	RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
    		rd.forward(req, res);
		}
		


	}


}

