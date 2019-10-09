<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 9/25/2019
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Nav Bar -->
<nav class="navbar navbar-expand-sm bg-info navbar-dark row">
    <a href="index.jsp" class="navbar-brand mr-auto"><h1>Inde Project</h1></a>

    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" data-toggle="modal" data-target="#loginModal">Log In</a>
        </li>
        <li class="nav-item">
            <a class="nav-link">Sign Up</a>
        </li>
    </ul>
</nav>

<!-- Login Modal -->
<form class="modal form" id="loginModal" ACTION="j_security_check" METHOD="POST">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title">Login</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <div class="modal-body">
                <label for="username">Username:</label>
                <input type="text" name="j_username" id="username" class="form-control"/>
                <label for="password">Password:</label>
                <input type="password" name="j_password" id="password" class="form-control"/>
            </div>

            <div class="modal-footer">
                <input type="submit" value="Login" class="btn btn-primary form-control" />
            </div>

        </div>
    </div>
</form>
