package com.inventory.servlet;
import com.inventory.dao.*;
import com.inventory.model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.sql.*;
@WebServlet("/ViewProductsServlet")
public class ViewProductsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.getAllProducts();

        request.setAttribute("products", list);
        RequestDispatcher rd =
                request.getRequestDispatcher("viewProducts.jsp");
        rd.forward(request, response);
    }
}