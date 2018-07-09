package welldev.io.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import welldev.io.DAO.Driver;
import welldev.io.model.ProductList;

@WebServlet("/editproduct")
public class EditProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		Driver dr = Driver.getInstance();
		ResultSet r =  dr.getById(pid);
		ProductList p = new ProductList();
		try {
			while(r.next()) {
				
				p.setId(r.getInt("id"));
				p.setName(r.getString("product_name"));
				p.setQuantity(r.getInt("quantity"));
				p.setPrice(r.getFloat("price"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("id", p.getId());
		request.setAttribute("n", p.getName());
		request.setAttribute("q", p.getQuantity());
		request.setAttribute("pp", p.getPrice());
		RequestDispatcher rd = request.getRequestDispatcher("editproduct.jsp");
		rd.forward(request, response);
	}

}
