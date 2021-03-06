<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="jsp/header.jsp"%>
<%@include file="jsp/topbar.jsp"%>
<%@include file="jsp/searchBar.jsp"%>

<c:set var="thisPage" value="Search" scope="request"/>

<c:if test="${results != null}">
    <ul>
    <c:choose>
        <c:when test="${empty results}">
            <li>
                <strong>There are no results to display</strong>
            </li>
        </c:when>
        <c:otherwise>
            <c:forEach items="${results}" var="recipe">
                <c:set var="target" value="search${recipe.id}" />
                <%@include file="jsp/listItemRecipe.jsp"%>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </ul>
</c:if>
<script src="js/search.js"></script>
<%@include file="jsp/footer.jsp"%>
