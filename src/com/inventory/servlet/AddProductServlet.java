package com.inventory.servlet;

import com.inventory.dao.DBConnection;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {
            Connection con = DBConnection.getConnection();

            // Insert product
            String sql = "INSERT INTO products(product_name, category, price) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, name);
            ps.setString(2, category);
            ps.setDouble(3, price);

            ps.executeUpdate();

            // Get generated product ID
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int productId = rs.getInt(1);

                // Insert quantity into stock
                String stockSql =
                    "INSERT INTO stock(product_id, quantity, last_updated) VALUES (?, ?, CURDATE())";

                PreparedStatement stockPs = con.prepareStatement(stockSql);

                stockPs.setInt(1, productId);
                stockPs.setInt(2, quantity);

                stockPs.executeUpdate();
            }

            response.sendRedirect("dashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}