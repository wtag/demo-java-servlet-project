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

import DAO.ProductDAO;
import DAO.ProductDAOImpl;
import Model.Product;
@WebServlet("/addproduct")
public class AddProduct extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Product product=new Product();
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		product.setName(req.getParameter("name"));
		product.setQuantity(req.getParameter("quantity"));
		product.setPrice(req.getParameter("price"));
		boolean flag=productDAOImpl.addProduct(product);
		if(flag==true)
		{
			RequestDispatcher rd = req.getRequestDispatcher("addproduct.jsp");
			rd.forward(req, response);
		}
		else {
			out.println("Product add not successful");

		}
		



	}


}
