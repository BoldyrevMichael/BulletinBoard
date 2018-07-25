package ru.boldyrev.ma.spring1.bulletinboard;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import ru.boldyrev.ma.spring1.bulletinboard.config.AppConfig;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Ad;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Category;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Company;
import ru.boldyrev.ma.spring1.bulletinboard.service.AdService;
import ru.boldyrev.ma.spring1.bulletinboard.service.CategoryService;
import ru.boldyrev.ma.spring1.bulletinboard.service.CompanyService;

public class TestFillDataBase {

    final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    final CategoryService categoryService = context.getBean(CategoryService.class);

    final CompanyService companyService = context.getBean(CompanyService.class);

    final AdService adService = context.getBean(AdService.class);



    @Test
    private void testPersist() {
//Исключительно для заполнения базы данными
/*        for (int i = 0; i < 11; i++) {
            final Category category = new Category();
            category.setName("category" + i);
            categoryService.persist(category);
            final Company company = new Company();
            company.setName("company" + (i+100));
            company.setDescription("description" + (i+100));
            company.setAddress("address" + (i+100));
            companyService.persist(company);
            for (int j = 0; j < 31; j++) {
                final Ad ad = new Ad();
                ad.setName("Advertisement" + i);
                ad.setCategory(category);
                ad.setCompany(company);
                ad.setContent("Advertisement" + i + "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Optio, reprehenderit officia maiores velit similique placeat atque deleniti voluptates illo, facere exercitationem ducimus. Tenetur ea nemo, totam quasi ducimus nobis provident!");
                ad.setPhone("Advertisement" + i + " phone: 12345");
                adService.persist(ad);
            }
        }*/
    }
}