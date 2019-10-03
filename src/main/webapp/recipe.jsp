<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 9/30/2019
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="jsp/header.jsp"%>
<%@include file="jsp/topbar.jsp"%>
<script src="js/recipe.js"></script>

<section action="#" class="row">
    <figure class="col-sm-6 col-md-4 col-lg-3" >
        <img alt="A picture will go here" src="img/0.jpg" class=" img-fluid img-thumbnail mx-auto d-block"/>
    </figure>
    <div id="recipeName" class="col">

        <!-- TODO test if user is is same as one logged in -->
        <div class="float-right">
            <a href="LikeRecipe?id=${recipe.id}">Like</a> |
            <a href="EditRecipe?id=${recipe.id}">Edit</a>
        </div>


        <h2>${recipe.name}</h2>
        <strong>By: ${recipe.user.userName}</strong>
    </div>
    <div id="tags"></div>

    <!-- Used by the javascript -->
    <input type="hidden" id="ingredients" name="ingredients" value='${recipe.ingredients}'/>
    <input type="hidden" id="directions" name="directions" value='${recipe.directions}'/>
</section><br />

<section class="row">
    <h3 class="col-12">Ingredients</h3>
    <ul id="ingredientsList" class="list-group col-12"></ul>
</section><br />

<section class="row">
    <h3 class="col-12">Instructions</h3>
    <ol id="directionsList" class="list-group col-12"></ol>
</section><br />


<%@include file="jsp/footer.jsp"%>
<script>init()</script>
