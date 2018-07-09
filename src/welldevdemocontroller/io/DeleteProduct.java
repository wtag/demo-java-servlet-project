package welldevdemocontroller.io;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ProductDaoImplement;
import util.SqlConnection;
import welldevdemomodel.io.Product;

import java.sql.SQLException;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	   String productid = request.getParameter("productid");	
	   int productId= Integer.parseInt(productid);
	   
	   
	   Product product= new Product();
	   product.setProductId(productId);
	   
	   ProductDaoImplement productDaoImplement= new ProductDaoImplement();
	   
	   productDaoImplement.deleteProduct(product);
		
        HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		
		request.setAttribute("name", "Hello!! " +" " + username + " " + "Welcome!!");
		RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
		rd.forward(request, response);
	
	
	
	}
    

	
}

