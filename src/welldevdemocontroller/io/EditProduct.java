package welldevdemocontroller.io;

import java.io.IOException;
import java.sql.SQLException;

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


@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

			
	    String pid = request.getParameter("pid");
	    int productId= Integer.parseInt(pid);
		String upname= request.getParameter("upname");
		String uprice= request.getParameter("uprice");
		int updatedProductPrice= Integer.parseInt(uprice);
		String uquantity= request.getParameter("uquantity");
		int updatedProductQuantity= Integer.parseInt(uquantity);
		
		Product product =new Product();
		ProductDaoImplement productDaoImplement = new ProductDaoImplement();
		
		product.setProductId(productId);
		product.setProductName(upname);
		product.setPrice(updatedProductPrice);
		product.setQuantity(updatedProductQuantity);
		
		boolean result= productDaoImplement.editProduct(product);
		
		
        HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		
		request.setAttribute("name", "Hello!! " +" " + username + " " + "Welcome!!");
		RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
		rd.forward(request, response);
	
	
	

	
	}
	

    
   
}
