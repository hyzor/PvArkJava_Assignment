<%-- 
    Document   : userRegistrationSuccessPage
    Created on : Apr 21, 2015, 7:09:27 PM
    Author     : hyzor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User         
        <%
            String username = session.getAttribute("username").toString();
            out.println(username + " ");
        %>
        successfully registered!
        </h1>
        
        <form action="loginPage.jsp" method="post">
            <p>
                <input type ="submit" value="Back"/>
            </p>
        </form>
    </body>
</html>
