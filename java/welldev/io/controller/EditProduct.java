package welldev.io.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import welldev.io.DAO.ProductDaoImp;
import welldev.io.model.Product;


public class EditProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product_id = request.getParameter("product_id");
		ProductDaoImp productDao = new ProductDaoImp();
		Product toUpdateProduct = productDao.getProductById(Integer.parseInt(product_id));
		request.setAttribute("product", toUpdateProduct);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("editproduct.jsp");
		requestDispatcher.forward(request, response);
	}

}
