package com.inventory.servlet;

import java.io.IOException;
import java.util.List;

import com.inventory.dao.ProductDAO;
import com.inventory.model.Product;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/LoadRestockPage")
public class LoadRestockPage extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        ProductDAO dao = new ProductDAO();

        List<Product> products =
            dao.getAllProducts();

        request.setAttribute("products", products);

        request.getRequestDispatcher("restock.jsp")
               .forward(request, response);
    }
}