 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Список перелетов</h1>
<ul>
    <c:forEach var="flight" items="${requestScope.flights}">
        <li>
            <a href="${pageContext.request.contextPath}/tickets?flightId=${flight.id}">${flight.description}</a>
        </li>
    </c:forEach>
</ul>
<%--var writer = resp.getWriter();--%>
<%--writer.write("<ul>");--%>
<%--    flightService.findAll().forEach(flightDto -> {--%>
<%--    writer.write("""--%>
<%--    <li>--%>
<%--        <a href="/tickets?flightId=%d">%s</a>--%>
<%--    </li>--%>
<%--    """.formatted(flightDto.getId(), flightDto.getDescription()));--%>
<%--    });--%>
<%--    writer.write("</ul>");--%>
</body>
</html>
