package ru.boldyrev.ma.spring1.bulletinboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.boldyrev.ma.spring1.bulletinboard.entity.*;
import ru.boldyrev.ma.spring1.bulletinboard.service.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
public class AppUserController {

    @Autowired
    AdService adService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CompanyService companyService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MessageSource messageSource;

    // Возвращает форму регистрации
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationForm(Model uiModel) {
        List<Category> listOfCategory = categoryService.getListOfCategory();
        List<Company> listOfCompany = companyService.getListOfCompany();
        AppUser appUser = new AppUser();
        uiModel.addAttribute("listOfCategory", listOfCategory);
        uiModel.addAttribute("listOfCompany", listOfCompany);
        uiModel.addAttribute("appUser", appUser);
        return "app-user/registration";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("email") String email,
                               @RequestParam("login") String login,
                               @RequestParam("password") String password,
                               Model uiModel,
                               Locale locale) {
/*           if (bindingResult.hasErrors()) {
               uiModel.addAttribute("message", messageSource.getMessage("app_user_create_fail", new Object[]{}, locale));
               return "app-user/registration";
           }
           if (appUserService.findAppUserByLogin(appUser.getLogin()) != null) {
               uiModel.addAttribute("message", messageSource.getMessage("app_user_login_exist", new Object[]{}, locale));
               return "app-user/registration";
           }*/
        AppUser appUser = new AppUser();
        appUser.setFirstName(firstName);
        appUser.setLastName(lastName);
        appUser.setEmail(email);
        appUser.setLogin(login);
        appUser.setPassword(password);
        System.out.println(appUser.toString());
/*        Role role = new Role();
        role.setName("user");
        roleService.persist(role);
        appUser.setRole(role);*/
/*        appUserService.persist(appUser);
        List<Ad> listOfAd = adService.getListOfAd();
        List<Category> listOfCategory = categoryService.getListOfCategory();
        List<Company> listOfCompany = companyService.getListOfCompany();
        uiModel.addAttribute("listOfAd", listOfAd);
        uiModel.addAttribute("listOfCategory", listOfCategory);
        uiModel.addAttribute("listOfCompany", listOfCompany);*/
        return "home-page";
    }


    // Принимает данные формы
    /*@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(Model uiModel,
                               @ModelAttribute("appUser") @Valid AppUser appUser,
                               BindingResult bindingResult,
                               Locale locale) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("message", messageSource.getMessage("app_user_create_fail", new Object[]{}, locale));
            return "app-user/registration";
        }
        if (appUserService.findAppUserByLogin(appUser.getLogin()) != null) {
            uiModel.addAttribute("message", messageSource.getMessage("app_user_login_exist", new Object[]{}, locale));
            return "app-user/registration";
        }
        appUserService.saveAppUser(appUser);
        return "redirect:/home-page";
    }*/
}