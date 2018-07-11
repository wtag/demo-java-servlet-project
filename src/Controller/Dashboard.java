package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import Model.Driver;
import Model.Product;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Driver driver = Driver.getInstance();
		
		HttpSession session;
		session=request.getSession();

		if(session.getAttribute("username")!=null) {
			List<Product> productList = new ArrayList<>();
			try {

				String sql = "select * from product";
				ResultSet resultSet = driver.select(sql);
				while (resultSet.next()) {
					Product product=new Product();
					int id = resultSet.getInt("pro_id");
					String name = resultSet.getString("name");
					String price = resultSet.getString("price");
					String quantity = resultSet.getString("quantity");
					product.setPid(id);
					product.setName(name);
					product.setPrice(price);
					product.setQuantity(quantity);
					productList.add(product);
				}


				request.setAttribute("products", productList);

			} catch (SQLException e) {
				
				e.printStackTrace();
			}

			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);
			driver.myConnection();
		}

		else {
			response.sendRedirect("index.jsp");
		}
	}

}
