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

<div class="row">
<ul class="nav flex-column col-3">
    <li class="nav-item">
        <a class="nav-link active" data-toggle="tab" href="#favs">View Favorites</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#planner">Weekly Planner</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#list">Shopping List</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="NewRecipe">New Recipe</a>
    </li>
</ul>

<main class="tab-content col-9">
    <div class="tab-pane fade show active d-hidden" id="favs">
        <%@include file="jsp/favorites.jsp"%>
    </div>

    <div class="tab-pane fade d-hidden" id="planner">
        <%@include file="jsp/weekly.jsp"%>
    </div>

    <div class="tab-pane fade d-hidden" id="list">
        <%@include file="jsp/shoppingList.jsp"%>
    </div>
</main>
</div>
<%@include file="jsp/footer.jsp"%>
