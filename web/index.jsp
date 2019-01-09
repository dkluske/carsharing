<%-- 
    Document   : index
    Created on : 07.01.2019, 18:32:48
    Author     : Dome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car-Sharing</title>
        <link rel="stylesheet" type="text/css" href="CSS\\welcomeCSS.css"/>
    </head>
    <body>
        <div class="container" id="back_home" align="center">
            
            <div class="row" id="title" align="center">
                <h1>Willkommen beim Car-Sharing!</h1>
            </div>
            
            <div class="row" id="back_login" align="center">
                
                <div id="login" align="center">
                    <form action="login.jsp" method="post">
                        <h3>Login</h3>
                
                        Username: <input type="text" name="kundennummer"/><br/>
                        Passwort: <input type="password" name="passwort"/><br/>
                        <input type="submit" value="Login"/><br/>
            
                    </form>
                </div>
                
            </div>
                
    </body>
</html>
