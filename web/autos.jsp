<%-- 
    Document   : autos
    Created on : 07.01.2019, 19:51:40
    Author     : Dome
--%>

<%@page import="CarSharing.model.Buchung"%>
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
            
            ArrayList<Auto> cars = RentManager.getUnusedCars();
            ArrayList<Buchung> rents = RentManager.getRentCars( kunde.getId() );
            
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car-Sharing - Fahrzeuge</title>
    </head>
    <body>
        <h1>Fahrzeuge</h1>
        <h3>Verfügbare Fahrzeuge</h3>
        <!--Liste der verfügbaren Fahrzeuge generieren mit Button zum Mieten-->
        <%
            for(Auto car : cars){
                %>
                <%=car%> <br>
                <%
            }
        %>
        <h3>Gemietete Fahrzeuge</h3>
        <!--Liste der gemieteten Fahrzeuge des Nutzers mit Button zum Freigeben-->
        <%
            for(Buchung rent : rents){
                %>
                <%=rent%> <br>
                <%
            }
        
        %>
    </body>
</html>
