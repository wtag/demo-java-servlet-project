package welldev.io.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import welldev.io.DAO.Driver;
import welldev.io.model.ProductList;

@WebServlet("/insertproduct")
public class InsertProduct extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String pn = request.getParameter("pname");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		float price = Float.parseFloat(request.getParameter("price"));
		Driver dr = Driver.getInstance();
		if(pid==null) {
			dr.insertProduct(pn, quantity, price);
		}
		else {
			dr.updateProduct(Integer.parseInt(pid), pn, quantity, price);
		}
		ArrayList<ProductList> product_list = new ArrayList<>();
		ResultSet r = dr.retrieveAll("product");
		
		if(r!=null) {
			try {
				while(r.next()) {
					ProductList pl = new ProductList();
					pl.setId(r.getInt("id"));
					pl.setName(r.getString("product_name"));
					pl.setPrice(r.getFloat("price"));
					pl.setQuantity(r.getInt("quantity"));
					product_list.add(pl);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			request.setAttribute("product_list", product_list);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	
	}

}
