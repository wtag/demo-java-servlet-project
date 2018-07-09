package welldevdemocontroller.io;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import welldevdemomodel.io.SqlConnection;


@WebServlet("/UpdatePass")
public class UpdatePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldpass = request.getParameter("opass");
		String newpass = request.getParameter("npass");
		
		HttpSession session = request.getSession();
		
		String password = (String) session.getAttribute("password");
		String Id =       (String) session.getAttribute("id");
		
		if(password==null)
		{
			request.setAttribute("msg","Login first");
			getServletContext().getRequestDispatcher("/updatepass.jsp").forward(request, response);
		}
		else if(oldpass.isEmpty()||newpass.isEmpty())
		{
			request.setAttribute("msg","Password cannot be null");
			getServletContext().getRequestDispatcher("/updatepass.jsp").forward(request, response);
		}
		
		else if(!oldpass.equals(password))
		{
			request.setAttribute("msg","Old Password is not correct");
			getServletContext().getRequestDispatcher("/updatepass.jsp").forward(request, response);
		}
		
		else {
			try {
								
				String sql = "Update user set password=? where iduser=?";
				
				SqlConnection con= SqlConnection.connect();
				con.UpdatePass(sql,newpass,Id);				
				response.sendRedirect("login.jsp");
			
			}
			
             catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	
	}

}
