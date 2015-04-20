<%-- 
    Document   : home
    Created on : Apr 20, 2015, 12:58:39 PM
    Author     : Jesper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome 
        <%
            String username = session.getAttribute("username").toString();
            out.println(username);
        %>
        !</h1>
        
        <form action="logout.jsp" method="post">
            <p>
                <input type ="submit" value="Logout"/>
            </p>
        </form>
    </body>
</html>
