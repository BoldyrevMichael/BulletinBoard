<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set value="${pageContext.request.contextPath}" var="contextPath"/>
<c:set value="${contextPath}/resources" var="resPath"/>
<c:set value="false" var="resultOfCheckingOfListOfAdForEmpty"/>
<c:if test="${not empty listOfAd }">
    <c:set value="true" var="resultOfCheckingOfListOfAdForEmpty"/>
</c:if>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${resPath}/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link href="${resPath}/css/sticky-footer-navbar.css" rel="stylesheet">

    <!-- Own CSS -->
    <link href="${resPath}/css/custom.css" rel="stylesheet">

    <title>BulletinBoard Home page</title>
</head>
<body>

<%@include file="/WEB-INF/views/blocks/header.jsp" %>

<!-- Begin page content -->
<main role="main" class="container">
    <h1 class="mt-5">Объявления</h1>
    <div class="list-group flex-row flex-wrap d-flex p-2 bd-highlight justify-content-sm-between" id="list-of-ad">
    </div>
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center" id="pagination"></ul>
    </nav>
</main>

<div class="cleaner"></div>

<%@include file="/WEB-INF/views/blocks/footer.jsp" %>

<!-- Optional JavaScript -->
<script src="${resPath}/js/jquery-3.3.1.slim.min.js"></script>
<script>window.jQuery || document.write('<script src="${resPath}/js/jquery-slim.min.js"><\/script>')</script>
<script src="${resPath}/js/jquery-slim.min.js"></script>
<script src="${resPath}/js/popper.min.js"></script>
<script src="${resPath}/js/bootstrap.min.js"></script>
<script src="${resPath}/js/jquery.min.js"></script>
<script src="${resPath}/js/tether.min.js"></script>
<script src="${resPath}/js/jquery.twbsPagination.min.js"></script>
<script>
    var numberOfAd = 0;
    if (${resultOfCheckingOfListOfAdForEmpty}) {
        numberOfAd = ${listOfAd.size()};
    }
    var url = "${contextPath}/list-of-ad/list-of-ad-ajax";
    var contextPath = "${contextPath}";
</script>
<script src="${resPath}/js/get-data-for-content-home-page.js"></script>

</body>
</html>