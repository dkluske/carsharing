<%-- 
    Document   : dashboard
    Created on : 07.01.2019, 20:35:49
    Author     : Dome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car-Sharing - Dashboard</title>
        <link rel="stylesheet" type="text/css" href="CSS\\welcomeCSS.css"/>
    </head>
    <body>
        <h1>Dashboard</h1>
        <jsp:include page="checkSession.jsp"/>
        <div id ="back_dash">
            <div id="dash_head">
                <jsp:include page="menu.jsp"/>
            </div>
            <div id="dash_body">
                <jsp:include page="autos.jsp"/>
            </div>
        </div>
    </body>
</html>
