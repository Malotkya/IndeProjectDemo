<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 10/9/2019
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="jsp/header.jsp"%>
<%@include file="jsp/topbar.jsp"%>
<form class="form" id="loginModal" action="j_security_check" method="POST">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h2 class="modal-title">Login</h2>
            </div>

            <div class="modal-body">
                <label for="username">Username:</label>
                <input type="text" name="j_username" value="${username}"
                       id="username" class="form-control"/>
                <label for="password">Password:</label>
                <input type="password" name="j_password" value="${password}"
                       id="password" class="form-control"/>
            </div>

            <div class="modal-footer">
                <input type="submit" value="Login" class="btn btn-primary form-control" />
            </div>

        </div>
    </div>
</form>
<c:if test="false">
    <script type="javascript">
        const init = () => {
            document.querySelector("form").submit();
        };
        window.onLoad = init;
    </script>
</c:if>
<%@include file="jsp/footer.jsp"%>
