<%-- 
    Document   : logout
    Created on : Apr 20, 2015, 1:06:35 PM
    Author     : Jesper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logging out...</title>
    </head>
    <body>
        <h1>Logging out...</h1>
        <%
            session.setAttribute("username", null);
            response.sendRedirect("loginPage.jsp");
        %>
    </body>
</html>
