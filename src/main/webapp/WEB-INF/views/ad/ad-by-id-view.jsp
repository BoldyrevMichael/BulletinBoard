<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set value="${pageContext.request.contextPath}" var="contextPath"/>
<c:set value="${contextPath}/resources" var="resPath"/>

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

    <title>BulletinBoard Объявление ${ad.name}</title>
</head>
<body>

<%@include file="/WEB-INF/views/blocks/header.jsp" %>

<!-- Begin page content -->
<main role="main" class="container">
    <h1 class="mt-5">Объявление ${ad.name}</h1>
    <div class="card">
        <div class="card-body">
            <div class="form-group row border">
                <label for="cardWithName" class="col-sm-2 col-form-label">Заголовок объявления:</label>
                <p class="form-control-plaintext col-sm-10" id="cardWithName">${ad.name}</p>
            </div>
            <div class="form-group row border">
                <label for="cardWithContent" class="col-sm-2 col-form-label">Содержание объявления:</label>
                <p class="form-control-plaintext col-sm-10" id="cardWithContent">${ad.content}</p>
            </div>
            <div class="form-group row border">
                <label for="cardWithCategoryName" class="col-sm-2 col-form-label">Наименование категории:</label>
                <p class="form-control-plaintext col-sm-10" id="cardWithCategoryName">${ad.category.name}</p>
            </div>
            <div class="form-group row border">
                <label for="cardWithAdPhone" class="col-sm-2 col-form-label">Телефон:</label>
                <p class="form-control-plaintext col-sm-10" id="cardWithAdPhone">${ad.phone}</p>
            </div>
            <div class="card">
                <div class="card-body">
                    <p>Компания</p>
                    <div class="form-group row border">
                        <label for="cardWithCompanyName" class="col-sm-2 col-form-label">Наименование
                            компании:</label>
                        <p class="form-control-plaintext col-sm-10" id="cardWithCompanyName">${ad.company.name}</p>
                    </div>
                    <div class="form-group row border">
                        <label for="cardWithCompanyAddress" class="col-sm-2 col-form-label">Адрес компании:</label>
                        <p class="form-control-plaintext col-sm-10"
                           id="cardWithCompanyAddress">${ad.company.address}</p>
                    </div>
                    <div class="form-group row border">
                        <label for="cardWithCompanyDescription" class="col-sm-2 col-form-label">Описание
                            компании:</label>
                        <p class="form-control-plaintext col-sm-10"
                           id="cardWithCompanyDescription">${ad.company.description}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <a type="button" class="btn btn-outline-secondary"
       href="${contextPath}/list-of-ad/ad/edit/${ad.id}">Редактировать</a>
    <a type="button" class="btn btn-outline-secondary"
       href="${contextPath}/list-of-ad/ad/remove/${ad.id}">Удалить</a>
</main>

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
    var url = "${contextPath}/list-of-ad/list-of-ad-ajax";
    var contextPath = "${contextPath}";
</script>
<script src="${resPath}/js/get-data-for-content-home-page.js"></script>

</body>
</html>
