<%-- 
    Document   : loginCheck
    Created on : Apr 20, 2015, 12:47:49 PM
    Author     : Jesper
--%>

<%@page import="com.MyPackage.SqlBean" %>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>    
        <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        SqlBean sqlBean = (SqlBean)session.getAttribute("sqlBean");
        
        Statement statement = sqlBean.getConnection().createStatement();
        
        String sql = "SELECT Password FROM TEST.USERS WHERE Username="+"'"+username+"'";
        ResultSet rs = statement.executeQuery(sql);
        
        boolean userFound = false;
        
        while (rs.next()) {
            if (password.equals(rs.getString("password"))) {
                session.setAttribute("username", username);
                userFound = true;
                response.sendRedirect("home.jsp");
            }
        }
        
        if (!userFound) {
            response.sendRedirect("error.jsp");
        }
    %>
    </body>
</html>
