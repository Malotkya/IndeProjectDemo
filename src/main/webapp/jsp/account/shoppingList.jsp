<script src="js/list.js"></script>

<h2>Shopping List</h2>
<input type="date" id="listPicker" value="${date}"/>
<input type="hidden" id="units" value='${applicationScope['units'].json}' />
<ul id="shoppingList" class="list-group">
    <li>
        <select class="m-1 volume">
            <c:forEach items="${applicationScope['units'].volumes}" var="volume">
                <option value="${volume.code}">${volume.name}</option>
            </c:forEach>
        </select>
        <select class="m-1 weight">
            <c:forEach items="${applicationScope['units'].weights}" var="weight">
                <option value="${weight.code}">${weight.name}</option>
            </c:forEach>
        </select>
    </li>
</ul>