package com.inventory.servlet;

import com.inventory.dao.DBConnection;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/RestockServlet")
public class RestockServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {
            Connection con = DBConnection.getConnection();

            // Update quantity in products table
            String updateProduct =
                "UPDATE products SET quantity = quantity + ? WHERE product_id = ?";

            PreparedStatement ps1 = con.prepareStatement(updateProduct);
            ps1.setInt(1, quantity);
            ps1.setInt(2, productId);
            ps1.executeUpdate();

            // Insert into stock history
            String insertStock =
                "INSERT INTO stock(product_id, quantity, last_updated) VALUES (?, ?, CURDATE())";

            PreparedStatement ps2 = con.prepareStatement(insertStock);
            ps2.setInt(1, productId);
            ps2.setInt(2, quantity);
            ps2.executeUpdate();

            response.sendRedirect("ViewProductsServlet");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}