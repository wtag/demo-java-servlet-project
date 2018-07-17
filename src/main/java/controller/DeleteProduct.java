package controller;


import util.Constants;
import java.io.IOException;
import Dao.ProductDaoImplement;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(Constants.PATH_DELETE_PRODUCT)
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   Product product= new Product();
	   product.setProductId(Integer.parseInt(request.getParameter("productid")));
	   
	   ProductDaoImplement productDaoImplement= new ProductDaoImplement();
	   boolean result = productDaoImplement.deleteProduct(product);
	
	   HttpSession session = request.getSession();
	   String username = (String) session.getAttribute("username");
	   
	   if(result){
	      request.setAttribute("name", "Hello!! " +" " + username + " " + "Welcome!!");
	      response.sendRedirect(request.getContextPath()+ Constants.PATH_PRODUCT);
	   }
	   
	   else {
	      request.setAttribute("name", "Sorry!! " +" " + username + " " + "Delete Failed!!");
	      response.sendRedirect(request.getContextPath()+ Constants.PATH_PRODUCT);   
	   }	
	
	}
}

