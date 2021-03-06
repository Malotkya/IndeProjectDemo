<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 9/25/2019
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="jsp/header.jsp"%>
<%@include file="jsp/topbar.jsp"%>
<c:choose>
    <c:when test="${empty users}">
        <h3>No Results Found!</h3>
    </c:when>
    <c:otherwise>
        <table class="table table-striped">
            <tr>
                <th>User Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>User Name</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.userName}</td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<%@include file="jsp/footer.jsp"%>
