<%-- 
    Document   : login
    Created on : 07.01.2019, 18:34:33
    Author     : Dome
--%>

<%@page import="CarSharing.model.Kunde"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="CarSharing.datenbank.Datenbank"%>
<%@page import = "CarSharing.logic.LoginManager" %>

<%
   String accName = request.getParameter("name");
   String accPass = request.getParameter("passwort");
   
   Kunde kunde;
   
   if( LoginManager.checkLoginCredentials(accName, accPass) ){
       
       kunde = LoginManager.getKunde(accName);
       request.getSession().setAttribute("kunde", kunde);
       
       %>
            <jsp:forward page="dashboard.jsp"/>
       <%
   }
   else{
       
       %>
            <jsp:forward page="loginerror.jsp" />
       <%
   }
   
   
   
%>
