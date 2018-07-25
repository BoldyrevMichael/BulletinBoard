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

    <title>BulletinBoard Добавление объявления</title>
</head>
<body>

<%@include file="/WEB-INF/views/blocks/header.jsp" %>

<!-- Begin page content -->
<main role="main" class="container">
    <h1 class="mt-5">Добавление объявления</h1>
    <form:form modelAttribute="ad" action="${contextPath}/list-of-ad/ad/add" method="post">
        <div class="card">
            <div class="card-body">
                <div class="form-group row border">
                    <label for="cardWithId" class="col-sm-2 col-form-label">Id объявления:</label>
                    <div class="form-control-plaintext col-sm-10">
                        <input type="text" value="${ad.id}" readonly class="form-control" id="cardWithId"
                               name="adId"
                               placeholder="${ad.id}">
                    </div>
                </div>
                <div class="form-group row border">
                    <form:label path="name" for="cardWithName" class="col-sm-2 col-form-label">Заголовок объявления:</form:label>
                    <div class="form-control-plaintext col-sm-10">
                        <form:input path="name" type="text" class="form-control" id="cardWithName" name="adName"
                               placeholder="Name"/>
                    </div>
                </div>
                <div class="form-group row border">
                    <form:label path="content" for="cardWithContent" class="col-sm-2 col-form-label">Содержание объявления:</form:label>
                    <div class="form-control-plaintext col-sm-10">
                            <form:textarea path="content" class="form-control" cols="30" rows="7"
                                      id="cardWithContent" name="adContent" placeholder="Content"></form:textarea>
                    </div>
                </div>
                <div class="form-group row border">
                    <label for="cardWithCategory" class="col-sm-2 col-form-label">Наименование
                        категории:</label>
                    <div class="form-control-plaintext col-sm-10">
                        <select class="form-control" id="cardWithCategory" name="categoryId">
                            <option value="не выбрана" selected>Выберите категорию.
                                Текущая: не выбрана</option>
                            <c:forEach items="${listOfCategory }" var="category">
                                <option value=${category.id}>${category.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group row border">
                    <form:label path="phone" for="cardWithAdPhone" class="col-sm-2 col-form-label">Телефон:</form:label>
                    <div class="form-control-plaintext col-sm-10">
                        <form:input path="phone" type="text" class="form-control" id="cardWithAdPhone"
                               placeholder="phone" name="adPhone"/>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body">
                        <p>Компания</p>
                        <div class="form-group row border">
                            <label for="cardWithCompanyName" class="col-sm-2 col-form-label">Наименование
                                компании:</label>
                            <div class="form-control-plaintext col-sm-10">
                                <input type="text" class="form-control" id="cardWithCompanyName"
                                       placeholder="name of company" name="companyName">
                            </div>
                        </div>
                        <div class="form-group row border">
                            <label for="cardWithCompanyAddress" class="col-sm-2 col-form-label">Адрес
                                компании:</label>
                            <div class="form-control-plaintext col-sm-10">
                                <input type="text" class="form-control" id="cardWithCompanyAddress"
                                       placeholder="address of company" name="companyAddress">
                            </div>
                        </div>
                        <div class="form-group row border">
                            <label for="cardWithCompanyDescription" class="col-sm-2 col-form-label">Описание
                                компании:</label>
                            <div class="form-control-plaintext col-sm-10">
                            <textarea class="form-control" cols="30" rows="5"
                                      id="cardWithCompanyDescription"
                                      placeholder="description of company" name="companyDescription"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-outline-secondary">Сохранить изменения</button>
    </form:form>
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
