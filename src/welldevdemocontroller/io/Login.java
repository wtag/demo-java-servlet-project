package welldevdemocontroller.io;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import welldevdemomodel.io.SqlConnection;


public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			String username= request.getParameter("username");
			String password= request.getParameter("password");
		

			HttpSession session = request.getSession();
			
			String sql = "select username,password,iduser from user where username=? and password=?";
			
			SqlConnection con= SqlConnection.connect();
			ResultSet res = con.login(sql,username,password);

			String UserName = null;
			String Pass= null;
			String Id=null;
			
			while(res.next())
			{
				UserName = res.getString("username");
				Pass= res.getString("password");
				Id=res.getString("iduser");
				
			}
			
			if (username.equals(UserName)&&password.equals(Pass))
			{
				session.setAttribute("username",username);
				session.setAttribute("password",password);
				session.setAttribute("id",Id);
				
				RequestDispatcher rd = request.getRequestDispatcher("Products");
				rd.forward(request, response);	
			}
			
			else
			{
				response.sendRedirect("login.jsp");
			}

		}
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
