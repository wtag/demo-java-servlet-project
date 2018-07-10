package welldevdemocontroller.io;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ProductDaoImplement;
import welldevdemomodel.io.Product;

public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pname= request.getParameter("pname");
		String price= request.getParameter("price");
		int productPrice= Integer.parseInt(price);
		String quantity= request.getParameter("quantity");
		int productQuantity= Integer.parseInt(quantity);
		
		Product product = new Product();
		ProductDaoImplement productDaoImplement = new ProductDaoImplement();
		product.setProductName(pname);
		product.setPrice(productPrice);
		product.setQuantity(productQuantity);
		
		productDaoImplement.insertProduct(product);
		
		
        HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		
		
		request.setAttribute("name", "Hello!! " +" " + username + " " + "Welcome!!");
		response.sendRedirect(request.getContextPath()+ "/Products");
		
	

	}

}
