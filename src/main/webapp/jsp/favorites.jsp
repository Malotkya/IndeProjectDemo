<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Favorites</h2>
<c:choose>
    <c:when test="${empty sessionScope.user.favorites}">
        <h3>
            No Recipe's where found!<br />
            <a href="Search">Find some Recipes</a> |
            <a href="NewRecipe">Add your own Recipe</a>
        </h3>
    </c:when>
    <c:otherwise>
        <ul class="table table-striped">
            <c:forEach var="recipe" items="${sessionScope.user.favorites}">
                <li class="row">
                    <a href="Recipe?id=${recipe.id}" class="col-9 row">
                        <figure class="col">
                            <img alt="A picture will go here" src="img/0.jpg" class=" img-fluid img-thumbnail mx-auto d-block"/>
                        </figure>
                        <h3 class="col-9">${recipe.name}</h3>
                    </a>
                    <a href="Unlike?=${recipe.id}" class="col">Unlike</a>

                </li>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>