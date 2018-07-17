package controller;

import util.Constants;
import java.io.IOException;
import Dao.ProductDaoImplement;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Product product = new Product();
		product.setProductName(request.getParameter("productname"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		
		ProductDaoImplement productDaoImplement = new ProductDaoImplement();
		productDaoImplement.insertProduct(product);
		
		
        HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		
		request.setAttribute("name", "Hello!! " +" " + username + " " + "Welcome!!");
		response.sendRedirect(request.getContextPath()+ Constants.PATH_PRODUCT);
		
	

	}

}
