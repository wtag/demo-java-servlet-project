package welldevdemocontroller.io;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import welldevdemomodel.io.SqlConnection;

public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		String pname= request.getParameter("pname");
		String price= request.getParameter("price");
		String quantity= request.getParameter("quantity");
		
		
		String sql = "insert into product(Name,price,quantity) values (?,?,?) ";
		
		SqlConnection con= SqlConnection.connect();
		con.INSERT(sql,pname,price,quantity);
		
        HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		
		request.setAttribute("name", "Hello!! " +" " + username + " " + "Welcome!!");
		RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
		rd.forward(request, response);	
		
	}
	
	catch (SQLException e) {
		e.printStackTrace();
	}
	
	}

}
