<%-- 
    Document   : dashboard
    Created on : 07.01.2019, 20:35:49
    Author     : Dome
--%>

<%@page import="CarSharing.logic.RentManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="CarSharing.model.Auto"%>
<%@page import="CarSharing.model.Kunde"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% 
            Kunde kunde = (Kunde) request.getSession().getAttribute("kunde");
        %>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car-Sharing - Dashboard</title>
    </head>
    <body>
        
        <h1> Willkommen <%=kunde%> </h1>
        
        <jsp:include page="menu.jsp"/>
        <jsp:include page="autos.jsp"/>
    </body>
</html>
