package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAOImpl;
import Model.Product;
@WebServlet("/editproduct")
public class EditProduct extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
		HttpSession session;
		session=req.getSession();
		
		
		Product product=new Product();
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		int proId=Integer.parseInt(req.getParameter("id"));
		product.setProId(proId);
		productDAOImpl.getProductbyId(product);

		req.setAttribute("name", product.getName());
		req.setAttribute("quantity", product.getQuantity());
		req.setAttribute("price", product.getPrice());
		session.setAttribute("pid", proId);
		req.setAttribute("pid", proId);


		RequestDispatcher rd = req.getRequestDispatcher("editproduct.jsp");
		rd.forward(req, res);


	}

}
