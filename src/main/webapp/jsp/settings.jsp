<div class="row">
<h2 class="col-12">User Name: ${sessionScope.user.userName}</h2>

<form action="Account" method="post" class="form col-md-6">
    <h3>User Settings</h3>
    <label for="firstName">First Name: </label>
    <input type="text" id="firstName" name="firstName"
           value="${sessionScope.user.firstName}" class="form-control"/>
    <label for="lastName">Last Name: </label>
    <input type="text" id="lastName" name="lastName"
           value="${sessionScope.user.lastName}" class="form-control"/>
    <label for="email">Email: </label>
    <input type="email" id="email" name="email"
           value="${sessionScope.user.email}" class="form-control"/>
    <input type="submit" name="submit" value="Update" class="btn btn-primary form-control mt-1"/>
</form>

<form action="Account" method="post" class="form col-md-6">
    <h3>Change Your Password</h3>
    <label for="oldPassword">Old Password</label>
    <input type="password" id="oldPassword" name="oldPassword" class="form-control">
    <label for="newPassword1">New Password</label>
    <input type="password" id="newPassword1" name="newPassword1" class="form-control">
    <label for="newPassword2">Re-Enter New Password</label>
    <input type="password" id="newPassword2" name="newPassword2" class="form-control">
    <input type="submit" name="submit" value="Change Password" class="btn btn-primary form-control mt-1"/>
</form>
</div>