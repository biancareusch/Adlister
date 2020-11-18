<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Welcome, ${sessionScope.user.username}!</h1>
    <div class="card">
        <img class="card-img-top" src="..." alt="Card image cap">
        <div class="card-body">
            <div class="card-header">
                <h3>User Information</h3>
            </div>
            <div class="card-text">
                <c:out value="${sessionScope.user.firstName}"></c:out>
                <c:out value="${sessionScope.user.lastName}"></c:out>
                <br>
                <c:out value="${sessionScope.user.firstName}"></c:out>
                <br>
                <c:out value="${sessionScope.user.email}"></c:out>
            </div>
        </div>
        <div class="card-body">
            <form action="/profile" method="post">
                <div class="form-group">
                    <input type="file" class="form-control-file" id="userPicture" name="userPicture">
                    <input type="submit" class="btn" value="Upload File">
                </div>
            </form>
        </div>
    </div>

    <h1>Here are your ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>
