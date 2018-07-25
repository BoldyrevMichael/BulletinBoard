//количество объявлений на странице
var numberOfAdPerPage = 6;
//количество страниц
var totalPages = (numberOfAd % numberOfAdPerPage === 0) ? numberOfAd / numberOfAdPerPage : numberOfAd / numberOfAdPerPage + 1;
//порядок сортировки(ASC-прямая, DESC-обратная)
var order = "DESC";
//поле для сортировки
var orderBy = "publishedDate";
//номер текущей страницы
var currentPage = 0;

$(function () {
    var obj = $('#pagination').twbsPagination({
        totalPages: totalPages,
        visiblePages: (totalPages > 10) ? 10 : totalPages,
        onPageClick: function (event, page) {
            currentPage = page - 1;
            if (totalPages > 0) {
                loadListOfAd();
            }
        }
    });
});

//функция для размещения полученных данных на странице
function renderingListOfAd(listOfAd) {

    $("#list-of-ad-by-company-id").empty();

    listOfAd.forEach(function (ad) {
        //Шаблон для размещения объявления в списке
        var adBody = "<a href=" + contextPath + "/list-of-ad/ad/" + ad["id"] + " class='ad-href list-group-item list-group-item-action flex-column align-items-start d-inline-flex p-2 bd-highlight' style='width: 537px;'>"
            + "<div class='d-flex w-100 justify-content-between'>"
            + "<h5 class='mb-1 ad-name'>" + ad["name"] + "</h5>"
            + "<small class='category-name'>" + ad["category"].name + "</small>"
            + "<small class='published-date'>" + ad["name"] + "</small>"
            + "</div>"
            + "<p class='mb-1 ad-content'>" + ad["content"].substring(0, 110) + "..." + "</p>"
            + "<small class='company-name'>" + ad["company"].name + "</small>"
            + "<small class='ad-phone'>" + ad["phone"] + "</small>"
            + "</a>";
        $(adBody).appendTo("#list-of-ad-by-company-id");
    });
}

//функция для осуществления асинхронного GET запроса
function loadListOfAd() {
    //формирование строки с данными, которые необходимо передать на сервер в метод listAjax
    var data = "currentPage=" + currentPage + "&" + "order=" + order + "&" + "orderBy=" + orderBy + "&" + "numberOfAdPerPage=" + numberOfAdPerPage + "&" + "companyId=" + companyId;

    $.ajax({
        url: url,
        type: 'GET',
        data: data,
        cache: false,
        success: function (listOfAdResponsive) {
            if (!listOfAdResponsive) {
            } else {
                //если ответ содержит данные, то они размещаются на странице
                renderingListOfAd(listOfAdResponsive["listOfAd"]);
            }
        }
    });
}