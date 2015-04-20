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

<jsp:useBean id="sqlSessionBean" class="com.MyPackage.SqlBean" />

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

        Statement statement = sqlSessionBean.getConnection().createStatement();
        String sql = "SELECT Password FROM APP.USERS WHERE Username="+username;
        ResultSet rs = statement.executeQuery(sql);
        
        if (rs.next() == true) {
            if (password == rs.getString("password")) {
                session.setAttribute("username", username);
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    %>
    </body>
</html>
