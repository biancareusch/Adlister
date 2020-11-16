<%--
  Created by IntelliJ IDEA.
  User: bianca
  Date: 11/16/20
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="ad Detail" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Ad Overview</h1>

<c:forEach var="ad" items="${ads}">
    <c:if test="${ad.id == sessionScope.adID}">
    <div class="col-md-9">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
<%--            <p>${ad.user_id}</p>--%>
        </div>
    </c:if>
</c:forEach>
</div>
</body>
</html>
