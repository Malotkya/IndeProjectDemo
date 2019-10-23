<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 10/10/2019
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="jsp/header.jsp"%>
<%@include file="jsp/topbar.jsp"%>
<main data-spy="scroll" data-target="#scroll-nav" data-offset="50">
    <ul class="nav flex-column" id="scroll-nav">
        <li class="nav-item">
            <a class="nav-link" href="#favs">View Favorites</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#planner">Weekly Planer</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#list">Shopping List</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="NewRecipe">New Recipe</a>
        </li>
    </ul>

    <div class="container" id="favs">
        <%@include file="jsp/favorites.jsp"%>
    </div>

    <div class="container" id="planner">
        <%@include file="jsp/weekly.jsp"%>
    </div>

    <div class="container" id="list">
        <%@include file="jsp/shopingList.jsp"%>
    </div>

</main>
<%@include file="jsp/footer.jsp"%>
