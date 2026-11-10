package com.inventory.servlet;
import com.inventory.dao.ProductDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String idStr= request.getParameter("id");
	        System.out.println("ID RECEIVED = "+idStr);
		int id = Integer.parseInt(idStr.trim());
		ProductDAO dao = new ProductDAO();
		dao.deleteProduct(id);
		response.sendRedirect("viewProducts.jsp");
}
}