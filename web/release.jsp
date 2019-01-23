<%-- 
    Document   : release
    Created on : 23.01.2019, 18:13:00
    Author     : OnTheRockz
--%>

<%@page import="CarSharing.logic.RentManager"%>
<%@page import="CarSharing.model.Kunde"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Kunde kunde = (Kunde) request.getSession().getAttribute("kunde");
    
    String carName = request.getParameter("carname");
    int accID = kunde.getId();
    
    RentManager.releaseCar(carName, accID);

%>
    <jsp:forward page="dashboard.jsp"/>