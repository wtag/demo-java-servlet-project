package welldevdemocontroller.io;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		
		request.setAttribute("name", "Hello!! " +" " + username + " " + "Welcome!!");
		RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
		rd.forward(request, response);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
