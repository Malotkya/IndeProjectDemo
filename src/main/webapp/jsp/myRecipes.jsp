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
                <li class="row">
                    <a href="Recipe?id=${recipe.id}" class="col-9 row">
                        <figure class="col">
                            <img alt="A picture will go here" src="img/0.jpg" class=" img-fluid img-thumbnail mx-auto d-block"/>
                        </figure>
                        <h3 class="col-9">${recipe.name}</h3>
                    </a>
                    <form action="Account" method="post" class="col confirm">
                        <input type="hidden" name="id" value="${recipe.id}"/>
                        <input type="submit" name="submit" value="Delete" class="btn btn-danger">
                    </form>
                    <!-- TODO: add to calendar option -->
                </li>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>