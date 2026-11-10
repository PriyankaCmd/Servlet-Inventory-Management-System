package com.inventory.servlet;

import com.inventory.dao.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;

@WebServlet("/DeleteSaleServlet")
public class DeleteSaleServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int saleId =
                Integer.parseInt(request.getParameter("saleId"));

        try {

            Connection con =
                    DBConnection.getConnection();

            String getSale =
                "SELECT product_id, quantity_sold " +
                "FROM sales WHERE sale_id=?";

            PreparedStatement ps1 =
                    con.prepareStatement(getSale);

            ps1.setInt(1, saleId);

            ResultSet rs = ps1.executeQuery();

            int productId = 0;
            int quantitySold = 0;

            if(rs.next()) {

                productId =
                    rs.getInt("product_id");

                quantitySold =
                    rs.getInt("quantity_sold");
            }

            String restoreStock =
                "UPDATE products " +
                "SET quantity = quantity + ? " +
                "WHERE product_id=?";

            PreparedStatement ps2 =
                    con.prepareStatement(restoreStock);

            ps2.setInt(1, quantitySold);
            ps2.setInt(2, productId);

            ps2.executeUpdate();

            String deleteSale =
                    "DELETE FROM sales WHERE sale_id=?";

            PreparedStatement ps3 =
                    con.prepareStatement(deleteSale);

            ps3.setInt(1, saleId);

            ps3.executeUpdate();

            response.sendRedirect("ViewSalesServlet");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}