<li class="row">
    <a href="Recipe?id=${recipe.id}" class="col-9 row">
        <figure class="col">
            <img alt="A picture will go here" src="img/0.jpg" class=" img-fluid img-thumbnail mx-auto d-block"/>
        </figure>
        <h3 class="col-9">${recipe.name}</h3>
    </a>
    <c:if test="${sessionScope.user != null}" >
        ${button}
        <div clss="col">
            <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#${target}">Add to Planner</button>
            <form class="collapse m-1" id="${target}" action="${thisPage}" method="post">
                <input type="date" class="date" class="float-right"/>
                <input type="hidden" name="date" id="hiddenDate" />
                <input type="hidden" value="Date" name="submitType" />
                <c:if test="${tab != null}" >
                    <input type="hidden" name="show" value="${tab}">
                </c:if>
            </form>
        </div>
    </c:if>
</li>