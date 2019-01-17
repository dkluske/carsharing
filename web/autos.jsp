<%-- 
    Document   : autos
    Created on : 07.01.2019, 19:51:40
    Author     : Dome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="CarSharing.model.Auto"%>
<%@page import="CarSharing.model.Kunde"%>
<%@page import="CarSharing.logic.RentManager"%>
<%@page import="CarSharing.logic.LoginManager"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car-Sharing - Fahrzeuge</title>
        <link rel="stylesheet" type="text/css" href="CSS\\welcomeCSS.css"/>
    </head>
    <body>
        <jsp:include page="checkSession.jsp"/>
        <div id="autos_back">
            <div id="autos_menu">
                <jsp:include page="menu.jsp"/>
            </div>
                <%
                    Kunde kunde = (Kunde) request.getSession().getAttribute("kunde");
                    String username = request.getParameter("username");
                    
                    ArrayList<Auto> freeautolist = RentManager.getAvailableCars();
                    
                    ArrayList<Auto> usedautolist = RentManager.getRentCars(LoginManager.getAccountId(username));
                    
                %>
            <div id="autos_1" align="left">
                <h3>Gemietete Fahrzeuge</h3>
                <!--Liste der gemieteten Fahrzeuge generieren mit Button zum Freigeben-->
                <table>
                    <tr>
                        <th>Marke</th>
                        <th>Typ</th>
                        <th>Freigeben</th>
                    </tr>
                <%
                    //For-Schleife zum auflisten der Autos {
                    for(Auto a : freeautolist){
                %>
                    <tr>
                        <td><%=a.getFabrikat()%></td>
                        <td><%=a.getModell()%></td>
                        <td>Button</td>
                    </tr>
                <%
                    // }
                    }
                %>

                </table>
            </div>
            <div id="autos_2" align="left">
                <h3>Verfügbare Fahrzeuge</h3>
                <!--Liste der verfügbaren Fahrzeuge mit Button zum Mieten-->
                <table>
                    <tr>
                        <th>Marke</th>
                        <th>Typ</th>
                        <th>Freigeben</th>
                    </tr>
                <%
                    //For-Schleife zum auflisten der Autos {
                    for(Auto a : usedautolist){
                %>
                    <tr>
                        <td><%=a.getFabrikat()%></td>
                        <td><%=a.getModell()%></td>
                        <td>Button</td>
                    </tr>
                <%
                    // }
                    }
                %>
                </table>
            </div>
        </div>
    </body>
</html>