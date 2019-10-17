<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 10/9/2019
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="jsp/header.jsp"%>
<form class="form" id="loginModal" action="j_security_check" method="POST">
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
<%@include file="jsp/footer.jsp"%>
