<%--
  Created by IntelliJ IDEA.
  User: qirsam
  Date: 28.04.2022
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<%@include file="header.jsp"%>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="email"><fmt:message key="page.login.email"/>
            <input type="text" name="email" id="email" value="${param.email}" required>
        </label><br>
        <label for="password"><fmt:message key="page.login.password"/>
            <input type="password" name="password" id="password" required>
        </label><br>
        <button type="submit"><fmt:message key="page.login.login.button"/></button>
        <a href="${pageContext.request.contextPath}/registration">
            <button type="button"><fmt:message key="page.login.registration.button"/></button>
        </a>
        <c:if test="${param.error != null}">
         <div>
<%--             <span style="color: red">Email or password is not correct</span>--%>
             <span style="color: red"><fmt:message key="page.login.error"/></span>
         </div>
        </c:if>
    </form>
</body>
</html>
