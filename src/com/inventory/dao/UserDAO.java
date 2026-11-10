package com.inventory.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserDAO{
   public boolean login(String username, String password){
       boolean status = false;
       try{
        Connection con = DBConnection.getConnection();
        String sql = "select * from users where username=? and password =?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            status = true;
    }}
       catch(Exception e){
     e.printStackTrace();
          }
      return status;
}
}