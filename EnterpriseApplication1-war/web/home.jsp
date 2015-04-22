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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700|Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
        <title>Home page</title>
    </head>
    <body>
        <div class="main">
            <div class="login">
                <div class="inset">
                    <div>
                        <h1>Welcome 
                            <%
                                String username = session.getAttribute("username").toString();
                                out.println(username + "!");
                            %>
                            </h1>
                    </div>

                    <div class="sign">
                        <div class="submit">
                            <form action="logout.jsp" method="post">
                                    <input type ="submit" value="Logout"/>
                            </form>
                        </div>
                    </div>
                    <div class="clear"> </div>
                </div>
            </div>
        </div>
    </body>
</html>
