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
import javax.servlet.http.HttpSession;

import DAO.ProductDAOImpl;
import Model.Product;
@WebServlet("/deleteproduct")
public class DeleteProduct extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {

		HttpSession session;
		session=req.getSession();
		Product product=new Product();
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		
			String id=req.getParameter("id");
			System.out.println(id);
			int pid=Integer.parseInt(id);
			System.out.println(pid);
			product.setPid(pid);
			
             productDAOImpl.deleteProduct(product);
			res.sendRedirect("dashboard");
			

		

	}

}
