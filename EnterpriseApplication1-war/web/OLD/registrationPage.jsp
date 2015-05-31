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
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700|Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
        <title>Registration page</title>
    </head>
    <body>
        <div class="main">
            <div class="login">
                <div class="inset">
                    <form action="${pageContext.request.contextPath}/UserRegistrationServlet" method="post">
                        <div>
                            <span><label>Username</label></span>
                            <span><input type="text" class="textbox" id="active" name="username"></span>
                        </div>
                        <div>
                            <span><label>Password</label></span>
                            <span><input type="password" class="textbox" name="password"></span>
                        </div>
                        <div>
                            <span><label>E-mail</label></span>
                            <span><input type="text" class="textbox" name="email"></span>
                        </div>
                        <%--<input type ="submit" value="Register"/>--%>
                        <div class="sign">
                        <div class="submit">
                            <input type="submit" value="Register" >
                        </div>
                    </form>

                    <form action="loginPage.jsp" method="post">
                        <div class="submit">
                            <input type="submit" value="Cancel" >
                        </div>
                    </form>
                    </div>
                    <div class="clear"> </div>
                </div>
            </div>
        </div>
    </body>
</html>
