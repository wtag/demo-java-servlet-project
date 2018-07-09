package welldev.io.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import welldev.io.DAO.ProductDAOImplementation;
import welldev.io.model.Product;

@WebServlet("/insertproduct")
public class InsertProduct extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		if(username==null || password==null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}else {
			String product_id = request.getParameter("product_id");
			String product_name = request.getParameter("product_name");
			int product_quantity = Integer.parseInt(request.getParameter("product_quantity"));
			float product_price = Float.parseFloat(request.getParameter("product_price"));
			
			ProductDAOImplementation productDao = new ProductDAOImplementation();
			if(product_id==null) {
				productDao.insertProduct(product_name, product_quantity, product_price);
			}
			else {
				
				productDao.updateProduct(Integer.parseInt(product_id), product_name, product_quantity, product_price);
			}
			ArrayList<Product> product_list = productDao.retrieveAll();
			request.setAttribute("product_list", product_list);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
			requestDispatcher.forward(request, response);
		}
		
	
	}

}
