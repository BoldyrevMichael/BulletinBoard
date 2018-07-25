<%@page pageEncoding="UTF-8" %>
<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="${contextPath}/home-page">Bulletin Board</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link <%= (request.getRequestURI().contains("home-page") ? "active" : "") %>"
                       href="${contextPath}/home-page">Главная <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/list-of-ad/add">Добавить объявление</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle <%= (request.getRequestURI().contains("list-of-ad-by-category-id") ? "active" : "") %>"
                       data-toggle="dropdown" href="#" role="button"
                       aria-haspopup="true" aria-expanded="false">Категории</a>
                    <div class="dropdown-menu">
                        <c:if test="${not empty listOfCategory }">
                            <c:forEach items="${listOfCategory }" var="category">
                                <a class="dropdown-item"
                                   href="${contextPath}/list-of-ad/list-of-ad-by-category-id/${category.id}">${category.name}</a>
                            </c:forEach>
                        </c:if>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Изменить список категорий</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle <%= (request.getRequestURI().contains("list-of-ad-by-company-id") ? "active" : "") %>"
                       data-toggle="dropdown" href="home-page" role="button"
                       aria-haspopup="true" aria-expanded="false">Компании</a>
                    <div class="dropdown-menu">
                        <c:if test="${not empty listOfCompany }">
                            <c:forEach items="${listOfCompany }" var="company">
                                <a class="dropdown-item"
                                   href="${contextPath}/list-of-ad/list-of-ad-by-company-id/${company.id}">${company.name}</a>
                            </c:forEach>
                        </c:if>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Изменить список компаний</a>
                    </div>
                </li>
            </ul>
            <div class="dropdown">
                <a class="btn btn-secondary dropdown-toggle" href="#" role="button"
                   id="dropdownMenuLinkForAuthorization" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">
                    Авторизация
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="#">Вход</a>
                    <a class="dropdown-item" href="${contextPath}/registration">Регистрация</a>
                </div>
            </div>
            <div class="dropdown">
                <a class="btn btn-secondary dropdown-toggle" href="#" role="button"
                   id="dropdownMenuLinkForChangeLanguage" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">
                    Выбрать язык
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="#">РУС</a>
                    <a class="dropdown-item" href="#">ENG</a>
                </div>
            </div>
        </div>
    </nav>
</header>