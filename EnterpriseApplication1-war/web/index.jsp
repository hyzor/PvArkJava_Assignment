<%-- 
    Document   : index
    Created on : Apr 20, 2015, 8:03:41 PM
    Author     : hyzor
--%>
<jsp:forward page="/MainServlet2" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            RequestDispatcher rd = null;
            
            if (session.getAttribute("username") == null) {
                rd = request.getRequestDispatcher("loginPage.jsp");
            } else {
                rd = request.getRequestDispatcher("home.jsp");
            }
            
            rd.forward(request, response);
        %>
    </body>
</html>
