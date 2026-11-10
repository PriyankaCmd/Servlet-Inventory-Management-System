package com.inventory.servlet;
import com.inventory.dao.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
public class LoginServlet extends HttpServlet{
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      UserDAO userDAO = new UserDAO();
      if(userDAO.login(username,password)){
                  response.sendRedirect("dashboard.jsp");
     }
     else{
         response.getWriter().println("Invalid Login!");
     }
}
}
       