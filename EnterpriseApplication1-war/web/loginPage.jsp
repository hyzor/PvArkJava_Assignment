<%-- 
    Document   : newjsp
    Created on : Apr 20, 2015, 11:57:29 AM
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
        <h1>Login</h1>
        <form action="loginCheck.jsp" method="post">
            <p>
                Username <input type="text" name="username"/><br/>
                Password <input type="text" name="password"/><br/>
                <input type ="submit" value="Submit"/>
            </p>
        </form>
    </body>
</html>
