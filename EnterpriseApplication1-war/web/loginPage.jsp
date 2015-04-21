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
        <title>Login page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="${pageContext.request.contextPath}/LoginCheckServlet" method="post">
            <p>
                Username <input type="text" name="username"/><br/>
                Password <input type="text" name="password"/><br/>
                <input type ="submit" value="Login"/>
            </p>
        </form>
        <form action="registrationPage.jsp" method="post">
            <p>
                <input type ="submit" value="Register"/>
            </p>
        </form>
    </body>
</html>
