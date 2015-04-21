<%-- 
    Document   : registrationPage
    Created on : Apr 21, 2015, 5:43:13 PM
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
        <h1>Registration</h1>
        <form action="${pageContext.request.contextPath}/UserRegistrationServlet" method="post">
            <p>
                Username <input type="text" name="username"/><br/>
                Password <input type="text" name="password"/><br/>
                E-mail <input type="text" name="email"/><br/>
                <input type ="submit" value="Register"/>
            </p>
        </form>

        <form action="loginPage.jsp" method="post">
            <p>
                <input type ="submit" value="Cancel"/>
            </p>
        </form>
    </body>
</html>
