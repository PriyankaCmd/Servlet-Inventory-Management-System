package com.inventory.servlet;
import com.inventory.dao.ProductDAO;
import com.inventory.model.Product;
import java.util.List;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import java.sql.*;
@WebServlet("/LowStockServlet")
public class LowStockServlet extends HttpServlet{

 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException{

    ProductDAO dao = new ProductDAO();
    List<Product> list = dao.getLowStock();

    request.setAttribute("products", list);
    RequestDispatcher rd = request.getRequestDispatcher("viewProducts.jsp");
    rd.forward(request,response);
 }
}