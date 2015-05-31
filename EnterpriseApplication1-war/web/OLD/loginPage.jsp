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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700|Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
        <title>Login page</title>
    </head>
    <body>
        <div class="main">
            <div class="login">
                <div class="inset">
                    <form action="${pageContext.request.contextPath}/LoginCheckServlet" method="post">
                        <div>
                            <span><label>Username</label></span>
                            <span><input type="text" class="textbox" id="active" name="username"></span>
                        </div>
                        <div>
                            <span><label>Password</label></span>
                            <span><input type="password" class="password" name="password"></span>
                        </div>
                        <div class="sign">
                            <div class="submit">
                                <input type="submit" value="Login" >
                            </div>
                            <%--
                            <span class="forget-pass">
                                <a href="#">Forgot Password?</a>
                            </span>
                            --%>
                    </form>

                    <form action="registrationPage.jsp" method="post">
                        <div class="submit">
                            <input type="submit" value="Register" >
                        </div>

                    </form>
                </div>
                <div class="clear"> </div>
            </div>
        </div>
    </div>
</body>
</html>
