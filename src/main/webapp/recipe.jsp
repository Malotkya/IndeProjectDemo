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

<form method="post" action="#">
    <section class="row" >
        <figure class="col-sm-6 col-md-4 col-lg-3" >
            <img alt="A picture will go here" src="img/0.jpg" class=" img-fluid img-thumbnail mx-auto d-block"/>
        </figure>
        <div class="col">

            <!-- TODO test if recipe.user is is same as one logged in -->
            <div class="float-right">
                <span class="edit">
                    <button type="submit" id="submit">Save</button>
                    <button type="button" id="cancel">Cancel</button>
                    <button type="button" id="delete">Delete</button>
                </span>
                <button type="button" id="edit">Edit</button>
                <button type="button" id="like">Like</button>
            </div>

            <div id="recipe_name">
                <h2>${recipe.name}</h2>
                <strong>By: ${recipe.user.userName}</strong>
            </div>
        </div>
        <div id="tags"></div>

        <!-- Used by the javascript -->
        <input type="hidden" id="ingredients" name="ingredients" value='${recipe.ingredients}'/>
        <input type="hidden" id="directions" name="directions" value='${recipe.directions}'/>
        <input type="hidden" name="id" value="${recipe.id}" />
    </section><br />

    <section class="row">
        <h3 class="col-12">Ingredients</h3>
        <ul id="ingredientsList" class="list-group col-12"></ul>
        <div class="pr-15 col-12 edit">
            <div class="list-group-item">
                <input type="text" id="newAmount"/>
                <select id="newUnit">
                    <option value=""> </option>
                    <option value="lbs" id="lbs">Pounds</option>
                    <option value="oz" id="oz">Ounces</option>
                </select>
                <input type="text" id="newIngredient" />
                <button type="button" id="addNewIngredient">Add</button>
            </div>
        </div>
    </section><br />

    <section class="row">
        <h3 class="col-12">Instructions</h3>
        <ol id="directionsList" class="list-group col-12"></ol>
    </section><br />
</form>


<%@include file="jsp/footer.jsp"%>
<script>init()</script>
