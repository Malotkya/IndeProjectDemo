<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 10/10/2019
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="jsp/header.jsp"%>
<%@include file="jsp/topbar.jsp"%>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<form class="form" action="NewUser" method="POST" id="newUser">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h2 class="modal-title">New User Sign Up</h2>
            </div>

            <div class="modal-body">

                <label for="username">Username:</label>
                <div class="input-group">
                    <input type="text" name="username" id="username" class="form-control"/>
                    <div class="invalid-feedback"></div>
                </div>

                <label for="password1">Enter Password:</label>
                <div class="input-group">
                    <input type="password" name="password1" id="password1" class="form-control"/>
                    <div class="invalid-feedback"></div>
                </div>

                <label for="password2">Re-Enter Password:</label>
                <div class="input-group">
                    <input type="password" name="password2" id="password2" class="form-control"/>
                    <div class="invalid-feedback"></div>
                </div>

                <label for="firstName">First Name:</label>
                <div class="input-group">
                    <input type="text" name="firstName" id="firstName" class="form-control"/>
                    <div class="invalid-feedback"></div>
                </div>

                <label for="lastName">Last Name:</label>
                <div class="input-group">
                    <input type="text" name="lastName" id="lastName" class="form-control"/>
                    <div class="invalid-feedback"></div>
                </div>

                <label for="email">Email:</label>
                <div class="input-group">
                    <input type="email" name="email" id="email" class="form-control"/>
                    <div class="invalid-feedback"></div>
                </div>
            </div>

            <div class="modal-footer flex-column">
                <div class="g-recaptcha" data-sitekey="6LeP574UAAAAABzEEyIUICAWNbbr1AzkKTImdU8G"></div>
                <input type="button" id="join" value="Join" class="btn btn-primary form-control mt-1" />
            </div>

        </div>
    </div>
</form>
<script src="js/newUser.js"></script>
<%@include file="jsp/footer.jsp"%>
