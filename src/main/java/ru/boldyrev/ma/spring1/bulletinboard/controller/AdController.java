package ru.boldyrev.ma.spring1.bulletinboard.controller;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.boldyrev.ma.spring1.bulletinboard.controller.ajax.ListOfAdAjax;
import ru.boldyrev.ma.spring1.bulletinboard.dto.AdDto;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Ad;
import ru.boldyrev.ma.spring1.bulletinboard.entity.AppUser;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Category;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Company;
import ru.boldyrev.ma.spring1.bulletinboard.service.AdService;
import ru.boldyrev.ma.spring1.bulletinboard.service.CategoryService;
import ru.boldyrev.ma.spring1.bulletinboard.service.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/list-of-ad")
public class AdController {

    @Autowired
    AdService adService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addAdForm(Model uiModel) {
        List<Category> listOfCategory = categoryService.getListOfCategory();
        List<Company> listOfCompany = companyService.getListOfCompany();
        uiModel.addAttribute("listOfCategory", listOfCategory);
        uiModel.addAttribute("listOfCompany", listOfCompany);
        Ad ad = new Ad();
        ad.setAppUser(new AppUser());
        uiModel.addAttribute("ad", ad);
        return "ad/ad-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAd(Model uiModel) {
        List<Category> listOfCategory = categoryService.getListOfCategory();
        List<Company> listOfCompany = companyService.getListOfCompany();
        uiModel.addAttribute("listOfCategory", listOfCategory);
        uiModel.addAttribute("listOfCompany", listOfCompany);
        return "ad/ad-add";
    }

    @RequestMapping(value = "/ad/{ad-id}", method = RequestMethod.GET)
    public String viewAd(@PathVariable("ad-id") String adId, Model uiModel) {
        AdDto adDto = adService.findAdDtoById(adId);
        List<Category> listOfCategory = categoryService.getListOfCategory();
        List<Company> listOfCompany = companyService.getListOfCompany();
        uiModel.addAttribute("ad", adDto);
        uiModel.addAttribute("listOfCategory", listOfCategory);
        uiModel.addAttribute("listOfCompany", listOfCompany);
        return "ad/ad-by-id-view";
    }

    @RequestMapping(value = "/ad/edit/{ad-id}", method = RequestMethod.GET)
    public String editAd(@PathVariable("ad-id") String adId, Model uiModel) {
        AdDto adDto = adService.findAdDtoById(adId);
        List<Category> listOfCategory = categoryService.getListOfCategory();
        List<Company> listOfCompany = companyService.getListOfCompany();
        uiModel.addAttribute("ad", adDto);
        uiModel.addAttribute("listOfCategory", listOfCategory);
        uiModel.addAttribute("listOfCompany", listOfCompany);
        return "ad/ad-by-id-edit";
    }

    @RequestMapping(value = "/ad/edit/after-edit/save", method = RequestMethod.POST)
    public String editAdSave(@ModelAttribute("ad") Ad ad,
                             BindingResult bindingResult,
                             @RequestParam("adId") String adId,
                             @RequestParam("adName") String adName,
                             @RequestParam("adContent") String adContent,
                             @RequestParam("categoryId") String categoryId,
                             @RequestParam("companyName") String companyName,
                             @RequestParam("companyAddress") String companyAddress,
                             @RequestParam("companyDescription") String companyDescription,
                             @RequestParam("adPhone") String adPhone,
                             Model uiModel) {
        Category category = categoryService.findCategoryById(categoryId);
        if (bindingResult.hasErrors() || category == null) {
            return "redirect:/list-of-ad/ad/edit/" + adId;
        }
        adService.setCategory(category, adId);
        adService.setName(adName, adId);
        adService.setContent(adContent, adId);
        adService.setPhone(adPhone, adId);
        Company company = companyService.findCompanyByName(companyName);
        if (company == null) {
            company = new Company();
            company.setName(companyName);
            company.setAddress(companyAddress);
            company.setDescription(companyDescription);
            adService.setCompany(company, adId);
            return "redirect:/home-page";
        }
        companyService.setName(companyName, company.getId());
        companyService.setAddress(companyAddress, company.getId());
        companyService.setDescription(companyDescription, company.getId());
        adService.setCompany(company, adId);
        return "redirect:/home-page";
    }

    @RequestMapping(value = "/list-of-ad-by-category-id/{category-id}", method = RequestMethod.GET)
    public String viewListOfAdByCategoryId(@PathVariable("category-id") String categoryId, Model uiModel) {
        List<Ad> listOfAd = adService.getListOfAdByCategoryId(categoryId);
        List<Category> listOfCategory = categoryService.getListOfCategory();
        List<Company> listOfCompany = companyService.getListOfCompany();
        uiModel.addAttribute("listOfAd", listOfAd);
        uiModel.addAttribute("listOfCategory", listOfCategory);
        uiModel.addAttribute("listOfCompany", listOfCompany);
        uiModel.addAttribute("categoryId", categoryId);
        return "list-of-ad-by-category-id";
    }

    @RequestMapping(value = "/list-of-ad-by-company-id/{company-id}", method = RequestMethod.GET)
    public String viewListOfAdByCompanyId(@PathVariable("company-id") String companyId, Model uiModel) {
        List<Ad> listOfAd = adService.getListOfAdByCompanyId(companyId);
        List<Category> listOfCategory = categoryService.getListOfCategory();
        List<Company> listOfCompany = companyService.getListOfCompany();
        uiModel.addAttribute("listOfAd", listOfAd);
        uiModel.addAttribute("listOfCategory", listOfCategory);
        uiModel.addAttribute("listOfCompany", listOfCompany);
        uiModel.addAttribute("companyId", companyId);
        return "list-of-ad-by-company-id";
    }

    /**
     * Методы, обрабатывающие асинхронные запросы
     */
    @RequestMapping(value = "/list-of-ad-ajax", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    /**
     * @param currentPage-текущая страница(блок из numberOfAdPerPage объявлений)
     * @param numberOfAdPerPage - количество статей в одном блоке
     * @param order - порядок сортировки(ASC-прямая, DESC-обратная)
     * @param orderBy - поле по которому происходит сортировка
     * @return объект класса ListOfAdAjax, который содержит список объявлений,
     * данный объект преобразовывается в JSON-формат
     */
    public ListOfAdAjax listOfAdAjax(@RequestParam("currentPage") Integer currentPage,
                                     @RequestParam("numberOfAdPerPage") Integer numberOfAdPerPage,
                                     @RequestParam("order") String order,
                                     @RequestParam("orderBy") String orderBy) {
        //объект, который будет содержать информацию о сортировке
        Sort sort = null;
        if (order.equalsIgnoreCase("DESC")) {
            //конструктор Sort принимает в качестве параметров тип сортировки и поле,
            //по которому будет происходить соритровка
            sort = new Sort(Sort.Direction.DESC, orderBy);
        } else {
            sort = new Sort(Sort.Direction.ASC, orderBy);
        }
        //создаётся объект с информацией о номере текущего блока, количестве объявлений в блоке и сортировке
        PageRequest pageable = PageRequest.of(currentPage, numberOfAdPerPage, sort);
        Page<Ad> pageWithListOfAd = adService.getListOfAdForPage(pageable);
        ListOfAdAjax responsive = new ListOfAdAjax();
        //из объекта Page возвращаем итератор и с помощью библиотеки google guava создаем списочный массив
        responsive.setListOfAd(Lists.newArrayList(pageWithListOfAd.iterator()));
        return responsive;
    }

    @RequestMapping(value = "/list-of-ad-by-category-id-ajax", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    /**
     * @param currentPage-текущая страница(блок из numberOfAdPerPage объявлений)
     * @param numberOfAdPerPage - количество статей в одном блоке
     * @param order - порядок сортировки(ASC-прямая, DESC-обратная)
     * @param orderBy - поле по которому происходит сортировка
     * @param categoryId - id категории, объявления которой будут выводиться на странице
     * @return объект класса ListOfAdAjax, который содержит список объявлений,
     * данный объект преобразовывается в JSON-формат
     */
    public ListOfAdAjax listOfAdByCategoryIdAjax(@RequestParam("currentPage") Integer currentPage,
                                                 @RequestParam("numberOfAdPerPage") Integer numberOfAdPerPage,
                                                 @RequestParam("order") String order,
                                                 @RequestParam("orderBy") String orderBy,
                                                 @RequestParam("categoryId") String categoryId) {
        //объект, который будет содержать информацию о сортировке
        Sort sort = null;
        if (order.equalsIgnoreCase("DESC")) {
            //конструктор Sort принимает в качестве параметров тип сортировки и поле,
            //по которому будет происходить соритровка
            sort = new Sort(Sort.Direction.DESC, orderBy);
        } else {
            sort = new Sort(Sort.Direction.ASC, orderBy);
        }
        //создаётся объект с информацией о номере текущего блока, количестве объявлений в блоке и сортировке
        PageRequest pageable = PageRequest.of(currentPage, numberOfAdPerPage, sort);
        Page<Ad> pageWithListOfAd = adService.getListOfAdByCategoryIdForPage(categoryId, pageable);
        ListOfAdAjax responsive = new ListOfAdAjax();
        //из объекта Page возвращаем итератор и с помощью библиотеки google guava создаем списочный массив
        responsive.setListOfAd(Lists.newArrayList(pageWithListOfAd.iterator()));
        return responsive;
    }

    @RequestMapping(value = "/list-of-ad-by-company-id-ajax", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    /**
     * @param currentPage-текущая страница(блок из numberOfAdPerPage объявлений)
     * @param numberOfAdPerPage - количество статей в одном блоке
     * @param order - порядок сортировки(ASC-прямая, DESC-обратная)
     * @param orderBy - поле по которому происходит сортировка
     * @param companyId - id категории, объявления которой будут выводиться на странице
     * @return объект класса ListOfAdAjax, который содержит список объявлений,
     * данный объект преобразовывается в JSON-формат
     */
    public ListOfAdAjax listOfAdByCompanyIdAjax(@RequestParam("currentPage") Integer currentPage,
                                                @RequestParam("numberOfAdPerPage") Integer numberOfAdPerPage,
                                                @RequestParam("order") String order,
                                                @RequestParam("orderBy") String orderBy,
                                                @RequestParam("companyId") String companyId) {
        //объект, который будет содержать информацию о сортировке
        Sort sort = null;
        if (order.equalsIgnoreCase("DESC")) {
            //конструктор Sort принимает в качестве параметров тип сортировки и поле,
            //по которому будет происходить соритровка
            sort = new Sort(Sort.Direction.DESC, orderBy);
        } else {
            sort = new Sort(Sort.Direction.ASC, orderBy);
        }
        //создаётся объект с информацией о номере текущего блока, количестве объявлений в блоке и сортировке
        PageRequest pageable = PageRequest.of(currentPage, numberOfAdPerPage, sort);
        Page<Ad> pageWithListOfAd = adService.getListOfAdByCompanyIdForPage(companyId, pageable);
        ListOfAdAjax responsive = new ListOfAdAjax();
        //из объекта Page возвращаем итератор и с помощью библиотеки google guava создаем списочный массив
        responsive.setListOfAd(Lists.newArrayList(pageWithListOfAd.iterator()));
        return responsive;
    }
}
