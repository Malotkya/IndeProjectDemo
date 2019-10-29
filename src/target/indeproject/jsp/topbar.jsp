<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 9/25/2019
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Nav Bar -->
<nav class="navbar navbar-expand-sm bg-info navbar-dark row">
    <a href="index.jsp" class="navbar-brand mr-auto"><h1>Inde Project</h1></a>

    <ul class="navbar-nav">
        <c:choose>
            <c:when test="${empty sessionScope.user}" >
                <li class="nav-item">
                    <a class="nav-link" href="Login">Log In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="NewUser">Sign Up</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="nav-item">
                    <a class="navbar-brand" href="Account">Welcome - ${sessionScope.user.firstName}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Logout">Log Out</a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>
