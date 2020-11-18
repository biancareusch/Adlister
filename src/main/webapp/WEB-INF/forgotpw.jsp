<%--
  Created by IntelliJ IDEA.
  User: patrick
  Date: 11/18/20
  Time: 2:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Forgot your password" />
    </jsp:include>
</head>
<body>
<form class="form-signin" action="/login" method="POST">
    <div class="text-center mb-4">
        <%--Todo: Logo Here--%>
        <h1 class="h3 mb-3 font-weight-normal">Forgot Password</h1>
        <p>Forgot your password? No worries we'll send you a password reset link through your email, just fill out this form</p>
    </div>
    <%--Todo:Input validations--%>
    <div class="form-label-group">
        <input type="text" id="inputUsername" name="inputUsername" class="form-control" placeholder="Username" required autofocus>
        <label for="inputUsername">Username</label>
    </div>
    <div class="form-label-group">
        <input type="text" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email" required>
        <label for="inputEmail">Email</label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    <p class="mt-5 mb-3 text-muted text-center">&copy; 2020</p>
</form>
</body>
</html>