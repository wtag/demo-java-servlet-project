package welldevdemocontroller.io;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import welldevdemomodel.io.SqlConnection;

import java.sql.SQLException;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
	   String productid = request.getParameter("productid");	
	   
	   String sql = "delete from product where productid=?";
		
	    SqlConnection con= SqlConnection.connect();
		con.DELETE(sql,productid);
		
		
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

