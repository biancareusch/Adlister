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
        <jsp:param name="title" value="ad Detail"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Ad Overview</h1>

    <h1><c:out value="${sessionScope.ad.title}"/></h1>
    <h2><c:out value="${sessionScope.ad.description}"/></h2>
    <h3>Ad ID: <c:out value="${sessionScope.ad.id}"/></h3>
    <h4> Created By: <c:out value="${sessionScope.users.username}"/></h4>

</div>
<jsp:include page="../partials/footer.jsp" />
</body>
</html>
