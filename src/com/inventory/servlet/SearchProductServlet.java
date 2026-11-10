package com.inventory.servlet;

import java.io.IOException;
import java.util.List;

import com.inventory.dao.ProductDAO;
import com.inventory.model.Product;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");
        System.out.println("Keyword = " + keyword);

        ProductDAO dao = new ProductDAO();

        List<Product> list = dao.searchProducts(keyword);
         System.out.println("Total products found = " + list.size());
        request.setAttribute("products", list);

        // important for keeping text in search box
        request.setAttribute("keyword", keyword);

        RequestDispatcher rd =
            request.getRequestDispatcher("viewProducts.jsp");

        rd.forward(request, response);
    }
}