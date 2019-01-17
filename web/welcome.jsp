<%-- 
    Document   : welcome
    Created on : 07.01.2019, 18:36:06
    Author     : Dome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car-Sharing - Willkommen</title>
        <link rel="stylesheet" type="text/css" href="CSS\\welcomeCSS.css"/>
    </head>
    <body>
        <div class="container" id="back_welcome" align="center">
            <div id="title">
                <h1>Willkommen beim Car-Sharing</h1>
            </div>
            <div class="row" id="back_login" align="center">
                <div class="row" id="login" align="center">
                    <jsp:include page="menu.jsp"/>
                </div>
            </div>
        </div>
    </body>
</html>
