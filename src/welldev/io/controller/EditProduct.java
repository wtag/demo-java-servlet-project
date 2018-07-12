package welldev.io.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import welldev.io.DAO.ProductDAOImplementation;
import welldev.io.model.Product;
import welldev.io.utility.ConstantStrings;

@WebServlet(ConstantStrings.editproduct)
public class EditProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String product_id = request.getParameter("product_id");
		ProductDAOImplementation productDao = new ProductDAOImplementation();
		Product product = productDao.getById(product_id);
		request.setAttribute("product", product);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("editproduct.jsp");
		requestDispatcher.forward(request, response);
	}

}
