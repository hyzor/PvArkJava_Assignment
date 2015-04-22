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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700|Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
        <title>Registration success!</title>
    </head>
    <body>
        <div class="main">
            <div class="login">
                <div class="inset">
                    <h1>Registration was successful!</h1>
                    <div class="sign">
                        <div class="submit">
                            <form action="loginPage.jsp" method="post">
                                <input type ="submit" value="Back"/>
                            </form>
                        </div>
                    </div>
                    <div class="clear"> </div>
                </div>
            </div>
        </div>
    </body>
</html>
