package com.inventory.dao;

import com.inventory.model.Sale;

import java.sql.*;
import java.util.*;

public class SalesDAO {

    public List<Sale> getAllSales() {

        List<Sale> list = new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM sales ORDER BY sale_id DESC";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Sale s = new Sale(
                        rs.getInt("sale_id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity_sold"),
                        rs.getDate("sale_date"),
                        rs.getDouble("total_amount")
                );

                list.add(s);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}