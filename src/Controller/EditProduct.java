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

		String id=req.getParameter("id");
		System.out.println(id);
		int pid=Integer.parseInt(id);
		System.out.println(pid);
		ResultSet resultSet;

		HttpSession session;
		session=req.getSession();
		Product product=new Product();
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();

//		if(session.getAttribute("username")!=null)
//		{
			product.setPid(pid);
			productDAOImpl.getProductbyId(product);
			
			req.setAttribute("name", product.getName());
			req.setAttribute("quantity", product.getQuantity());
			req.setAttribute("price", product.getPrice());
			session.setAttribute("pid", pid);
			req.setAttribute("pid", pid);

//		}
//		else {
//			res.sendRedirect("index.jsp");
//		}

		RequestDispatcher rd = req.getRequestDispatcher("editproduct.jsp");
		rd.forward(req, res);
		

	}

}
