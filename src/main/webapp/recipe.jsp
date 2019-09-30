<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 9/30/2019
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="jsp/header.jsp"%>
<script src="js/recipe.js"></script>

<form action="updateRecipe.jsp">
    <input type="hidden" id="ingredients" name="ingredients" value="${recipe.ingredients}"/>
    <input type="hidden" id="directions" name="directions" value="${recipe.directions}"/>
    <input type="hidden" name="id" value="${recipe.id}"/>
    <!-- Add an element for javascript to read to remove ability to edit. -->

    <div id="recipeName">
        <h2>${recipe.name}</h2>
    </div>

    <input type="submit" value="save" id="submit"/>
    <input type="button" value="cancel" />

    <!-- Tags are a reach goal, but div tag is still here for spacing -->
    <div id="tags"></div>

    <h3>Ingredients</h3>
    <ul id="ingredientsList"></ul>
    <button>Add Ingredient</button>
    <div id="ingredientInput"></div>

    <h3>Instructions</h3>
    <ol id="directionsList"></ol>
    <button>Add Instruction</button>
    <div id="directionInput"></div>

</form>
<%@include file="jsp/footer.jsp"%>
<script>init()</script>
