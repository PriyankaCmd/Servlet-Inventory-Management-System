package com.inventory.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
   private static final String URL = "jdbc:mysql://localhost:3306/inventory_db";
   private static final String USER = "root";
   private static final String PASSWORD =  "0099Priy@";
   public static Connection getConnection(){
    Connection con = null;
     try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      con=DriverManager.getConnection(URL, USER, PASSWORD);
      System.out.println("Database Connected SuccessFully!");
     }
     catch(ClassNotFoundException e){
         System.out.println("Driver not found!");}
     catch(SQLException e){
         System.out.println("Connection Failed");
          e.printStackTrace();
}
 return con;
}
}
