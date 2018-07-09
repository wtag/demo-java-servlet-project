package welldev.io.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import welldev.io.DAO.Driver;

@WebServlet("/updatepasswerd")
public class UpdatePasswerd extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String un = (String) session.getAttribute("un");
		String p = (String) session.getAttribute("p");
		
		if(p!=null) {
			
			Driver dr = Driver.getInstance();
			dr.updatePassword(un, request.getParameter("change"));
			request.setAttribute("msg", "");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}else {
			
			request.setAttribute("msg", "Please Log In First");
			RequestDispatcher rd = request.getRequestDispatcher("changepass.jsp");
			rd.forward(request, response);
		}
		
	}

}
