<%@ page import="com.qirsam.http.service.TicketService" %>
<%@ page import="com.qirsam.http.dto.TicketDto" %>
<%@ page import="java.util.List" %>
<%--<%@ taglib prefix="c" uri="http://mycompany.com" %>--%>
<%@ include file="index.html"%><%--
  Created by IntelliJ IDEA.
  User: qirsam
  Date: 24.04.2022
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Купленные билеты</h1>
<ul>
    <%
        Integer flightId = Integer.valueOf(request.getParameter("flightId"));
        List<TicketDto> tickets = TicketService.getInstance().findAllByFlightId(flightId);
        for (TicketDto ticket : tickets) {
            out.write(String.format("<li>%s</s>", ticket.getSeatNo()));
        }
    %>
</ul>
</body>
</html>
