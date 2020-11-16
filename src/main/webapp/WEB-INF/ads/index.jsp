<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Here Are all the ads!</h1>


    <c:forEach var="ad" items="${ads}">
        <form action="/ads/detail" method="post">
        <div class="card">
            <div class="card-body">
                <div class="card-title">
                    <p name="adID">${ad.id}</p>
                    <h2>${ad.title}</h2>
                </div>
                <div class="card-text">
                    <p>${ad.description}</p>
                </div>
<a href="/ads/detail" class="btn btn-primary" type="submit">See details...</a>
            </div>
        </div>
        </form>
    </c:forEach>

</div>

</body>
</html>
