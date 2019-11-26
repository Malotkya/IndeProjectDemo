<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="tab" value="favs" />

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
        <ul>
            <c:forEach var="recipe" items="${sessionScope.user.favorites}">
                <c:set var="button" value='
                <form action="${thisPage}" method="post" class="col confirm">
                    <input type="hidden" name="id" value="${recipe.id}"/>
                    <input type="submit" name="submitType" value="Unlike" class="btn btn-danger">
                </form>' />
                <c:set var="target" value="favs${recipe.id}" />
                <%@include file="../listItemRecipe.jsp"%>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>