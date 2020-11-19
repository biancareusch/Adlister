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
        <img class="card-img-top" height="150px" src="${userPic}" alt="User Profile Image">
        <div class="card-body">
            <div class="card-header">
                <h3>User Information</h3>
            </div>
            <div class="card-text">
                <br>
                <c:out value="${sessionScope.user.firstName}">.</c:out>
                <c:out value="${sessionScope.user.lastName}">.</c:out>
                <br>
                <c:out value="${sessionScope.user.email}">.</c:out>
                <br>
            </div>
        </div>
        <div class="card-body">
            <form action="/profile" method="post">
                <div class="form-group">
                    <input type="url" id="userPicture" placeholder="img URL Here" name="userPicture">
                    <input name="userID" id="userID" type="hidden" value="${user.id}">
                    <input type="submit" class="btn" value="Update Profile Picture">
                </div>
            </form>
            <c:if test="${sessionScope.PictureError != error}">
                <div class="alert alert-warning" role="alert">
                    Couldn't upload file, try again.
                </div>
            </c:if>
        </div>
    </div>

    <h1>Here are your ads!</h1>

    <c:forEach var="ad" items="${ads}">
    <div class="col-md-6">
        <h2>${ad.title}</h2>
        <p>${ad.description}</p>
    </div>
    </c:forEach>
    </p>
    <jsp:include page="partials/footer.jsp" />
</body>
</html>
