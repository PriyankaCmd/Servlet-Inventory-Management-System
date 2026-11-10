package com.inventory.dao;
import java.sql.Connection;
import java.util.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.inventory.model.Product;
public class ProductDAO{
public Product getProductById(int id){
    Product p=null;
     try{
        Connection con = DBConnection.getConnection();
        String sql = "Select * from products where product_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs =  ps.executeQuery(); 
        if(rs.next()){
          p= new Product();
          p.setProductId(rs.getInt("product_id"));
          p.setName(rs.getString("product_name"));
          p.setCategory(rs.getString("category"));
          p.setPrice(rs.getDouble("price"));
          p.setQuantity(rs.getInt("quantity"));
     }
 }catch(Exception e){
    e.printStackTrace();
  }
return p;
}
public boolean updateProduct(Product p){
boolean status = false;
  try{
      Connection con = DBConnection.getConnection();
      String sql= "Update products set product_name=?, category=? ,price=?, quantity=? where product_id=?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1,p.getName());
     ps.setString(2,p.getCategory());
      ps.setDouble(3,p.getPrice());
      ps.setInt(4, p.getQuantity());
       ps.setInt(5, p.getProductId());
      status = ps.executeUpdate()>0;
}
catch(Exception e){
 e.printStackTrace();
}
return status;
}
public boolean deleteProduct(int id){
	boolean status = false;
	try{
		Connection con = DBConnection.getConnection();
		String sql = "delete from products where product_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		status = ps.executeUpdate()>0;
}catch(Exception e){
e.printStackTrace();
}
return status;
}
public List<Product> searchProducts(String keyword) {

    List<Product> list = new ArrayList<>();

    try {
        Connection con = DBConnection.getConnection();

        String sql =
"SELECT * FROM products WHERE LOWER(product_name) LIKE LOWER(?) OR LOWER(category) LIKE LOWER(?)";
        PreparedStatement ps = con.prepareStatement(sql);

        String search = "%" + keyword.trim() + "%";

        ps.setString(1, search);
        ps.setString(2, search);
        
        System.out.println("Searching: " + keyword);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {

            Product p = new Product();

            p.setProductId(rs.getInt("product_id"));
            p.setName(rs.getString("product_name"));
            p.setCategory(rs.getString("category"));
            p.setPrice(rs.getDouble("price"));
            p.setQuantity(rs.getInt("quantity"));

            list.add(p);
        }

    } catch(Exception e){
        e.printStackTrace();
    }

    return list;
}public List<Product> getLowStock(){
    List<Product> list = new ArrayList<>();

    try{
        Connection con = DBConnection.getConnection();
        String sql = "select * from products where quantity < 2";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Product p = new Product();
            p.setProductId(rs.getInt("product_id"));
            p.setName(rs.getString("product_name"));
            p.setCategory(rs.getString("category"));
            p.setPrice(rs.getDouble("price"));
            p.setQuantity(rs.getInt("quantity"));
            list.add(p);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    return list;
}
public List<Product> getAllProducts() {
    List<Product> list = new ArrayList<>();

    try {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from products");

        while (rs.next()) {
            Product p = new Product();
            System.out.println(rs.getString("product_name"));
            p.setProductId(rs.getInt("product_id"));
            p.setName(rs.getString("product_name"));
            p.setCategory(rs.getString("category"));
            p.setPrice(rs.getDouble("price"));
            p.setQuantity(rs.getInt("quantity"));

            list.add(p);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
}
           
           
