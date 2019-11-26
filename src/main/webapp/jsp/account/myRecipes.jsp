<h2>Your Recipes</h2>
<c:choose>
    <c:when test="${empty sessionScope.user.recipes}">
        <h3>
            No Recipe's where found!<br />
            <a href="NewRecipe">Add your own Recipe</a>
        </h3>
    </c:when>
    <c:otherwise>
        <ul>
            <c:forEach var="recipe" items="${sessionScope.user.recipes}">
                <c:set var="button" value='
                <form action="${thisPage}" method="post" class="col confirm">
                    <input type="hidden" name="id" value="${recipe.id}"/>
                    <input type="submit" name="submitType" value="Delete" class="btn btn-danger">
                </form>' />
                <c:set var="target" value="owned${recipe.id}" />
                <%@include file="../listItemRecipe.jsp"%>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>