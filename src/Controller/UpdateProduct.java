package Controller;

import java.io.IOException;
import java.io.PrintWriter;
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

		PrintWriter out=response.getWriter();
		Product product=new Product();
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();

		String eId=req.getParameter("eid");
		int pId=Integer.parseInt(eId);

		product.setName(req.getParameter("ename"));
		product.setQuantity(req.getParameter("equantity"));
		product.setPrice(req.getParameter("eprice"));
		product.setProId(pId);
		int flag=productDAOImpl.editProduct(product);
		if(flag==1) {
			response.sendRedirect("dashboard");
		}

		else {
			out.println("Product update not successful");

		}
	}



}
