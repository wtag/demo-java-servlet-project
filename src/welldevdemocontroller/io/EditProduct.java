package welldevdemocontroller.io;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import welldevdemomodel.io.SqlConnection;


@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			
	    String pid = request.getParameter("pid");
		String upname= request.getParameter("upname");
		String uprice= request.getParameter("uprice");
		String uquantity= request.getParameter("uquantity");
		
		
		String sql ="Update product set Name=?,Price=?,Quantity=? where productid=?";
		
		SqlConnection con= SqlConnection.connect();
		con.UPDATE(sql,upname,uprice,uquantity,pid);
		
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
