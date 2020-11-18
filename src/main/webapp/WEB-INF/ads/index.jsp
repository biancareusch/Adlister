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
</form>
<div class="row">
    <div class="col-lg-12 card-margin">
        <div class="card search-form">
            <div class="card-body p-0">
                <form id="search-form">
                    <div class="row">
                        <div class="col-12">
                            <div class="row no-gutters">
                                <div class="col-lg-8 col-md-6 col-sm-12 p-0">
                                    <input type="text" placeholder="Search..." class="form-control" id="ad-search" name="ad-search">
                                </div>
                                <div class="result-sorting col-4">
                                    <span>Sort By:</span>
                                    <select class="form-control border-0" id="sort">
                                        <option value="1">Relevance</option>
                                        <option value="2">Names (A-Z)</option>
                                        <option value="2">Names (A-Z)</option>
                                        <option value="3">Distance</option>
                                    </select>
                                </div>
                                <div class="col-lg-1 col-md-3 col-sm-12 p-0">
                                    <button type="submit" class="btn btn-base">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <h1>Here Are all the ads!</h1>


    <c:forEach var="ad" items="${ads}">
        <div class="card">
            <div class="card-body">
                <div class="card-title">
                    <h2><c:out value="${ad.title}" /></h2>
                </div>
                <div class="card-text">
                    <p><c:out value="${ad.description}"/></p>
                </div>
                <form action="../ads" method="POST">
                    <input name="ad-ID" id="ad-ID" type="hidden" value="${ad.id}">
                    <input name="userID" id="userID" type="hidden" value="${ad.userId}">
                    <input type="submit" class="btn btn-primary" value="see details...">
                </form>
            </div>
        </div>
    </c:forEach>

</div>
</body>
</html>



