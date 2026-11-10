package com.inventory.servlet;
import com.inventory.dao.ProductDAO;
import com.inventory.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet{
protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
         int id = Integer.parseInt(request.getParameter("id"));
         ProductDAO dao = new ProductDAO();
         Product product = dao.getProductById(id);
         request.setAttribute("product", product);
         RequestDispatcher rd = request.getRequestDispatcher("updateProduct.jsp");
         rd.forward(request, response);
     }
  protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String category = request.getParameter("category");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Product p = new Product();
            p.setProductId(id);
           p.setName(name);
           p.setCategory(category);
           p.setPrice(price);
           p.setQuantity(quantity);
           ProductDAO dao = new ProductDAO();
           dao.updateProduct(p);
           response.sendRedirect("viewProducts.jsp");
          }
}