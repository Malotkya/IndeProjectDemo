<h2>User Settings</h2>

<form action="Account" method="post" class="form">
    <h3>${sessionScope.user.userName}</h3>
    <label for="firstName">First Name: </label>
    <input type="text" id="firstName" name="firstName"
           value="${sessionScope.user.firstName}" class="form-control"/>
    <label for="lastName">Last Name: </label>
    <input type="text" id="lastName" name="lastName"
           value="${sessionScope.user.lastName}" class="form-control"/>
    <label for="email">Email: </label>
    <input type="email" id="email" name="email"
           value="${sessionScope.user.email}" class="form-control"/>
    <input type="submit" name="submit" value="Update" class="form-control"/>
</form>

<hr />

<form action="Account" method="post" class="form">
    <label for="oldPassword">Old Password</label>
    <input type="password" id="oldPassword" name="oldPassword" class="form-control">
    <label for="newPassword1">New Password</label>
    <input type="password" id="newPassword1" name="newPassword1" class="form-control">
    <label for="newPassword2">Re-Enter New Password</label>
    <input type="password" id="newPassword2" name="newPassword2" class="form-control">
</form>