package controller;


import java.util.List;
import java.io.IOException;
import Dao.ProductDaoImplement;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{	
		ProductDaoImplement productDaoImplement = new ProductDaoImplement();
		List<Product> productList = productDaoImplement.getProducts();
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		request.setAttribute("list_of_product", productList);
		request.setAttribute("name", "Hello!! " +" " + username + " " + "Welcome!!");
		RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
		rd.forward(request, response);
		
		} 
		catch (Exception e) 
		{
		e.printStackTrace();
		}
		
	}

}
