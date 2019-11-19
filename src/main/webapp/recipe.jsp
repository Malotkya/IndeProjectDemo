<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 9/30/2019
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="jsp/header.jsp"%>
<%@include file="jsp/topbar.jsp"%>

<c:set var="isOwnedByUser" scope="page" value="${recipe.user.id == sessionScope.user.id}"/>

<form method="post" action="Recipe">
    <section class="row" >
        <figure class="col-sm-6 col-md-4 col-lg-3" >
            <!-- Looking to add future support to user added images -->
            <img alt="A picture will go here" src="img/0.jpg" class=" img-fluid img-thumbnail mx-auto d-block"/>
        </figure>
        <div class="col">

            <c:if test="${sessionScope.user != null}">
            <div class="float-right mt-1">
                <c:if test="${isOwnedByUser}">
                    <span class="edit">
                        <input type="submit" id="save" value="Save" class="btn btn-success"/>
                        <input type="button" id="cancel" value="Cancel" class="btn btn-secondary"/>
                        <input type="submit" id="delete" value="Delete" class="btn btn-danger"/>
                    </span>
                </c:if>
                <span class="initial">
                    <c:if test="${isOwnedByUser}">
                        <input type="button" id="edit" value="Edit" class="btn btn-primary"/>
                    </c:if>
                    <c:choose>
                        <c:when test="${isFavorite}">
                            <input type="submit" id="like" value="Unlike" class="btn btn-primary"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" id="like" value="Like" class="btn btn-primary"/>

                        </c:otherwise>
                    </c:choose>
                    <span>
                        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#dateCollapse" id="planner">Add to Planner</button><br/>
                        <div class="collapse" id="dateCollapse">
                            <!-- TODO: fix where this date input shows up -->
                            <input type="date" id="date" />
                            <input type="hidden" name="date" id="hiddenDate" />
                            <input type="hidden" value="Date" id="submitDate" />
                        </div>
                    </span>
                </span>
            </div>
            </c:if>

            <div class="initial">
                <h2 id="displayName" >${recipe.name}</h2>
                <strong>By: ${recipe.user.userName}</strong>
            </div>
            <c:if test="${isOwnedByUser}">
                <div class="edit">
                    <label for="recipeName">Recipe Name: </label>
                    <input type="text"id="editName" name="recipeName"  id="recipeName" value="${recipe.name}">
                    <br/>
                    <input type="checkbox" name="publicView"id="publicView" ${recipe.checked}>
                    <label for="publicView">Make this recipe public</label>
                </div>
            </c:if>
            <div class="w-100">
                <!--I hope to have tags added eventually-->
            </div>
        </div>


        <!-- Used by the javascript -->
        <input type="hidden" id="ingredients" name="ingredients" value='${recipe.ingredients}'/>
        <input type="hidden" id="directions" name="directions" value='${recipe.directions}'/>
        <input type="hidden" name="id" value="${recipe.id}" />
    </section><br />

    <section class="row">
        <h3 class="col-12">Ingredients</h3>
        <ul id="ingredientsList" class="list-group col-12"></ul>
        <c:if test="${isOwnedByUser}">
            <div class="pr-15 pl-0 col-12 edit">
                <div class="list-group-item">
                    <input type="text" id="newAmount" class="m-1"/><select
                        id='newUnit' class="m-1">
                        <option value=""> </option>
                        <option disabled>Volumes</option>
                        <c:forEach items="${applicationScope['units'].volumes}" var="volume">
                            <option value="${volume.code}">${volume.name}</option>
                        </c:forEach>

                        <option disabled>Weights</option>
                        <c:forEach items="${applicationScope['units'].weights}" var="weight">
                            <option value="${weight.code}">${weight.name}</option>
                        </c:forEach>
                    </select><input
                        type="text" id="newIngredient" class="m-1"/><button
                        type="button" id="addNewIngredient" class="m-1 btn btn-primary">Add</button>
                </div>
            </div>
        </c:if>
    </section><br />

    <section class="row">
        <h3 class="col-12">Instructions</h3>
        <ol id="directionsList" class="list-group col-12 initial"></ol>
        <c:if test="${isOwnedByUser}">
            <textarea id="directionsInput" class="edit list-group-item col-12"></textarea>
        </c:if>
    </section><br />
</form>

<script src="js/recipe.js"></script>
<%@include file="jsp/footer.jsp"%>
