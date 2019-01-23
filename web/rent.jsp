<%-- 
    Document   : rent
    Created on : 23.01.2019, 16:59:13
    Author     : OnTheRockz
--%>

<%@page import="CarSharing.model.Kunde"%>
<%@page import="CarSharing.logic.RentManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Kunde kunde = (Kunde) request.getSession().getAttribute("kunde");
    
    String carName = request.getParameter("carname");
    int accID = kunde.getId();
    
    RentManager.rentCar(carName, accID);
%>

    <jsp:forward page="dashboard.jsp"/>