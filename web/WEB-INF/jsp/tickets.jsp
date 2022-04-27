<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty requestScope.tickets}">
<h1>Купленные билеты</h1>
<ul>
    <c:forEach var="ticket" items="${requestScope.tickets}">
        <li>${fn:toLowerCase(ticket.seatNo)}</li>
    </c:forEach>
    </c:if>

    <%--    <%--%>
    <%--        Integer flightId = Integer.valueOf(request.getParameter("flightId"));--%>
    <%--        List<TicketDto> tickets = TicketService.getInstance().findAllByFlightId(flightId);--%>
    <%--        for (TicketDto ticket : tickets) {--%>
    <%--            out.write(String.format("<li>%s</s>", ticket.getSeatNo()));--%>
    <%--        }--%>
    <%--&lt;%&ndash;    %>&ndash;%&gt; сделал через jstl --%>
</ul>
</body>
</html>
