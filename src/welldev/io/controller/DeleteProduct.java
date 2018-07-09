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

@WebServlet("/deleteproduct")
public class DeleteProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		if(username==null || password==null) {
			RequestDispatcher requestDispather = request.getRequestDispatcher("login.jsp");
			requestDispather.forward(request, response);
		}else {
			ProductDAOImplementation productDao = new ProductDAOImplementation();
			productDao.deleteProduct(request.getParameter("product_id"));
			ArrayList<Product> product_list = productDao.retrieveAll();
			
			request.setAttribute("product_list", product_list);
			RequestDispatcher requestDispather = request.getRequestDispatcher("dashboard.jsp");
			requestDispather.forward(request, response);
		}
		
	}


}
