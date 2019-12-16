<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 10/9/2019
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<c:choose>
    <c:when test="${message eq null}">
        ${message}
    </c:when>
    <c:otherwise>
        You have reached this page in error!
    </c:otherwise>
</c:choose>
<br />
<button onclick="history.go(-1)">Go Back</button>
</body>
</html>
