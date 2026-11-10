package com.inventory.servlet;
import com.inventory.dao.DBConnection;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.sql.*;
@WebServlet("/SalesServlet")
public class SalesServlet extends HttpServlet{
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
System.out.println("ID="+request.getParameter("productId"));
System.out.println("qty="+request.getParameter("quantity"));
int productId = Integer.parseInt(request.getParameter("productId"));
int quantity = Integer.parseInt(request.getParameter("quantity"));
try{
Connection con = DBConnection.getConnection();
String getProduct = "select price,quantity from products where product_id=?";
PreparedStatement ps0 = con.prepareStatement(getProduct);
ps0.setInt(1, productId);
ResultSet rs = ps0.executeQuery();
double price = 0;
int currentStock = 0;
if(rs.next()){
System.out.println("Price="+rs.getDouble("price"));
price= rs.getDouble("price");
currentStock=rs.getInt("quantity");
}
if(quantity<=0){
response.getWriter().println("Invalid quantity");
return;
}
if(currentStock<quantity){
response.getWriter().println("Not Enough Sttock");
return;
}
double totalAmount = price*quantity;
String insertSale = "insert into sales(product_id, quantity_sold, sale_date,  total_amount) values(?, ?, CURDATE(),  ?)";
PreparedStatement ps1 = con.prepareStatement(insertSale);
ps1.setInt(1,productId);
ps1.setInt(2,quantity);
ps1.setDouble(3,totalAmount);
System.out.println("id="+productId+"quantity="+quantity+"price="+totalAmount);
ps1.executeUpdate();
String updateStock = "update products set quantity = quantity - ? where product_id=?";
PreparedStatement ps2= con.prepareStatement(updateStock);
ps2.setInt(1,quantity);
ps2.setInt(2,productId);
int rows= ps2.executeUpdate();
System.out.println("ROWS Updated="+rows);
response.sendRedirect("ViewProductsServlet");
}catch(Exception e){
e.printStackTrace();
}

}
}
