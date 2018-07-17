package welldev.io.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import welldev.io.DAO.ProductDaoImp;
import welldev.io.model.Product;


public class InsertProduct extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product newProduct = new Product();
		
		newProduct.setName(request.getParameter("product_name"));
		newProduct.setQuantity(Integer.parseInt(request.getParameter("product_quantity")));
		newProduct.setPrice(Float.parseFloat(request.getParameter("product_price")));
		ProductDaoImp productDao = new ProductDaoImp();
		if(request.getParameter("product_id")==null) {
			productDao.insertProduct(newProduct);

		}
		else {
			productDao.updateProduct(Integer.parseInt(request.getParameter("product_id")), newProduct);
		}
		ArrayList<Product>product_list = (ArrayList<Product>) productDao.getAllProducts();
		request.setAttribute("product_list", product_list);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
