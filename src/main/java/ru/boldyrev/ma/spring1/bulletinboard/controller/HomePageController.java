package ru.boldyrev.ma.spring1.bulletinboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Ad;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Category;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Company;
import ru.boldyrev.ma.spring1.bulletinboard.service.AdService;
import ru.boldyrev.ma.spring1.bulletinboard.service.CategoryService;
import ru.boldyrev.ma.spring1.bulletinboard.service.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/home-page")
public class HomePageController {

    @Autowired
    AdService adService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CompanyService companyService;

    @RequestMapping(method = RequestMethod.GET)
    public String goHome(Model uiModel) {
        List<Ad> listOfAd = adService.getListOfAd();
        List<Category> listOfCategory = categoryService.getListOfCategory();
        List<Company> listOfCompany = companyService.getListOfCompany();
        uiModel.addAttribute("listOfAd", listOfAd);
        uiModel.addAttribute("listOfCategory", listOfCategory);
        uiModel.addAttribute("listOfCompany", listOfCompany);
        return "home-page";
    }
}