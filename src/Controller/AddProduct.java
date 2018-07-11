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

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.sun.swing.internal.plaf.basic.resources.basic;

import Model.Driver;
@WebServlet("/addproduct")
public class AddProduct extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		String name = req.getParameter("name");
		String quantity = req.getParameter("quantity");
		String price=req.getParameter("price");
		PrintWriter out =response.getWriter();
		HttpSession session;
		session=req.getSession();
		Driver driver=Driver.getInstance();

		if(session.getAttribute("username")!=null)
		{
			driver.addproduct(name, quantity, price);
			RequestDispatcher rd = req.getRequestDispatcher("addproduct.jsp");
			rd.forward(req, response);
			driver.myConnection();


		}
		else {
			response.sendRedirect("index.jsp");
		}

	}


}
