<%-- 
    Document   : welcome
    Created on : 24.01.2019, 20:38:41
    Author     : OnTheRockz
--%>

<%@page import="CarSharing.model.Kunde"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        <% 
            Kunde kunde = (Kunde) request.getSession().getAttribute("kunde");
        %>

<h1> Willkommen <%=kunde%> </h1>
