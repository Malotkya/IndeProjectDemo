<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="jsp/header.jsp"%>
<%@include file="jsp/topbar.jsp"%>
<c:choose>
    <c:when test="${empty results}">
        <%@include file="jsp/searchBar.jsp"%>
    </c:when>
    <c:otherwise>
        <!-- Display Results Here -->
    </c:otherwise>
</c:choose>
<%@include file="jsp/footer.jsp"%>
