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
<ul class="nav nav-pills flex-flex col-12 col-md-2">
    <li class="nav-item">
        <strong>Recipe</strong>
    </li>
    <li class="nav-item ">
        <a class="nav-link ${favsBtn}" data-toggle="tab" href="#favs">Favorite Recipes</a>
    </li>
    <li class="nav-item">
        <a class="nav-link ${ownedBtn}" data-toggle="tab" href="#owned">My Recipes</a>
    </li>
    <li class="nav-item">
        <a class="nav-link ${importBtn}"  data-toggle="tab" href="#import">Import Recipe</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " href="NewRecipe">New Recipe</a>
    </li>

    <li class="nav-item">
        <strong>Planning</strong>
    </li>
    <li class="nav-item">
        <a class="nav-link ${plannerBtn}" id="plannerBtn" data-toggle="tab" href="#planner">Weekly Planner</a>
    </li>
    <li class="nav-item">
        <a class="nav-link ${listBtn}" id="listBtn" data-toggle="tab" href="#list">Shopping List</a>
    </li>

    <li class="nav-item">
        <strong>Settings</strong>
    </li>
    <li class="nav-item">
        <a class="nav-link ${settingsBtn}" data-toggle="tab" href="#settings">Account Settings</a>
    </li>
</ul>

<main class="tab-content col">
    <article class="tab-pane fade d-hidden ${favsPane}" id="favs">
        <%@include file="jsp/favorites.jsp"%>
    </article>

    <article class="tab-pane fade d-hidden ${ownedPane}" id="owned">
        <%@include file="jsp/myRecipes.jsp"%>
    </article>

    <article class="tab-pane fade d-hidden ${importPane}" id="import">
        <%@include file="jsp/import.jsp"%>
    </article>

    <article class="tab-pane fade d-hidden ${plannerPane}" id="planner">
        <%@include file="jsp/weekly.jsp"%>
    </article>

    <article class="tab-pane fade d-hidden ${listPane}" id="list">
        <%@include file="jsp/shoppingList.jsp"%>
    </article>

    <article class="tab-pane fade d-hidden ${settingsPane}" id="settings">
        <%@include file="jsp/settings.jsp"%>
    </article>
</main>
</div>

<script src="js/account.js"></script>
<%@include file="jsp/footer.jsp"%>
