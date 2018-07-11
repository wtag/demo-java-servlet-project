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

import Model.Driver;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		String name = req.getParameter("name");
		String pass = req.getParameter("password");
		String username=req.getParameter("username");
		String country =req.getParameter("country");
		PrintWriter out=res.getWriter();

		Driver driver=Driver.getInstance();

		if(name.isEmpty()||pass.isEmpty()||username.isEmpty()||country.isEmpty())
		{
			System.out.println("Input field is empty");
			out.println("Field must not be empty");

		}
		else {
			driver.insert(name, pass, username, country);

			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, res);
		}
		driver.myConnection();
	}


}

