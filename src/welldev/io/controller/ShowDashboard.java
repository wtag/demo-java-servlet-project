package welldev.io.controller;

import java.io.IOException;
import java.util.List;
import welldev.io.DAO.ProductDAOImplementation;
import welldev.io.model.Product;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/showdashboard")
public class ShowDashboard extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDAOImplementation productDao = new ProductDAOImplementation();
		List<Product> productList = productDao.retrieveAll();
		
		request.setAttribute("product_list", productList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
		requestDispatcher.forward(request, response);
	}


}
