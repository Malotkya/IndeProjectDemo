<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<script src="js/weekly.js"></script>

<jsp:useBean id="now" class="java.util.Date" />
<f:formatDate var="date" pattern='yyyy-MM-dd' value='${now}' />

<c:set var="daysOfWeek" value="${['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']}" />

<h2>Weekly Planner</h2>
<input type="date" id="weekPicker" value="${date}" class="float-left"/>
<button type="button" id="weekToList" class="btn btn-info float-right">Build Shopping List</button>
<
<div class="d-flex flex-column" id="week">
    <c:forEach var="day" items="${daysOfWeek}">
        <section class="card flex-row">
            <h3 class="bg-light align-middle col-3 mb-0">${day}</h3>
            <div class="d-flex flex-row day col-9"></div>
        </section>
    </c:forEach>
</div>