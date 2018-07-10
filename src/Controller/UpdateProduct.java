package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLService;

import DAO.ProductDAOImpl;
import Model.Product;

@WebServlet("/updateproduct")
public class UpdateProduct extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session;
		session=req.getSession();
		Product product=new Product();
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		String ename = req.getParameter("ename");
		String equantity = req.getParameter("equantity");
		String eprice=req.getParameter("eprice");;
		String eid=req.getParameter("eid");
		System.out.println(eid);
		int pid=Integer.parseInt(eid);
		System.out.println(pid);
		
		
//		if(session.getAttribute("username")!=null)
//		{
			product.setName(ename);
			product.setQuantity(equantity);
			product.setPrice(eprice);
			product.setPid(pid);
		  productDAOImpl.editProduct(product);
	
		response.sendRedirect("dashboard");
//	}
//		else {
//			response.sendRedirect("index.jsp");
//		}
	}

}
