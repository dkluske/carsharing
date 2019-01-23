

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
if(request.getSession().getAttribute("kunde") == null){
    //nicht angemeldet
%>
<ul>
    <li><a href="index.jsp">Home</a></li>
</ul>
<%    
}else{
    //angemeldet
    %>
<ul>
    <li><a href="welcome.jsp">Home</a></li>
    <li><a href="dashboard.jsp">Dashboard</a></li>
    <li><a href="logout.jsp">Logout</a></li>
</ul>
    <%
}
%>

<hr/>

