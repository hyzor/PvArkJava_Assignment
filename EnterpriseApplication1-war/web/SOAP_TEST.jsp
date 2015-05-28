<%-- 
    Document   : SOAP_TEST
    Created on : May 27, 2015, 9:49:36 PM
    Author     : Hyzor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SOAP test page</title>
    </head>
    <body>
        <h1>This is a SOAP test page</h1>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	com.MyPackage.WSDL.NewWebService_Service service = new com.MyPackage.WSDL.NewWebService_Service();
	com.MyPackage.WSDL.NewWebService port = service.getNewWebServicePort();
	 // TODO initialize WS operation arguments here
	java.lang.String name = "";
	// TODO process result here
	java.lang.String result = port.hello(name);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
