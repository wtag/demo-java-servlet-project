package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Driver;

@WebServlet("/editproduct")
public class EditProduct extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
		
		Driver driver = Driver.getInstance();
	
		String id=req.getParameter("id");
		System.out.println(id);
		int pid=Integer.parseInt(id);
		System.out.println(pid);
		ResultSet resultSet;

		try {
			resultSet =driver.getproductbyId(pid);
			while(resultSet.next())
			{
				String name = resultSet.getString("name");
				String quantity = resultSet.getString("quantity");
				String price = resultSet.getString("price");

				req.setAttribute("name", name);
				req.setAttribute("quantity", quantity);
				req.setAttribute("price", price);
				req.setAttribute("pid", pid);

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}



		RequestDispatcher rd = req.getRequestDispatcher("editproduct.jsp");
		rd.forward(req, res);
		driver.myConnection();

	}

}
