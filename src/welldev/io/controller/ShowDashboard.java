package welldev.io.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import welldev.io.DAO.Driver;
import welldev.io.model.ProductList;
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
		HttpSession session = request.getSession();
		Driver dr = Driver.getInstance();
		String un = (String) session.getAttribute("un");
		String p = (String) session.getAttribute("p");
		if(un==null || p==null) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}else {
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


}
