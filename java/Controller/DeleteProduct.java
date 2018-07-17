package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Utility.*;
import DAO.ProductDAOImpl;
import Model.Product;
@WebServlet("/deleteproduct")
public class DeleteProduct extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
		PrintWriter out=res.getWriter();
		Product product=new Product();
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();

		product.setProId(Integer.parseInt(req.getParameter("id")));

		int flag=productDAOImpl.deleteProduct(product);
		if(flag==1) {
			res.sendRedirect("dashboard");
		}
		else {
			out.println("Product is not deleted");

		}




	}

}
