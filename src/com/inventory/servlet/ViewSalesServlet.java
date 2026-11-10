package com.inventory.servlet;

import com.inventory.dao.*;
import com.inventory.model.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.*;

@WebServlet("/ViewSalesServlet")
public class ViewSalesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        SalesDAO dao = new SalesDAO();

        List<Sale> list =
                dao.getAllSales();

        request.setAttribute("sales", list);

        RequestDispatcher rd =
                request.getRequestDispatcher("viewSales.jsp");

        rd.forward(request, response);
    }
}