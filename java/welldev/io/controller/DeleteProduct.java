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

public class DeleteProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDaoImp productDao = new ProductDaoImp();
		int deletedRow = productDao.deleteProductById(Integer.parseInt(request.getParameter("product_id")));
		ArrayList<Product> product_list = (ArrayList<Product>) productDao.getAllProducts();
		request.setAttribute("product_list", product_list);
		RequestDispatcher requestDispather = request.getRequestDispatcher("dashboard.jsp");
		requestDispather.forward(request, response);
	}


}
