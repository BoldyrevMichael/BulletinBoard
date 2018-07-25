package ru.boldyrev.ma.spring1.bulletinboard.dto;

import ru.boldyrev.ma.spring1.bulletinboard.entity.Ad;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Category;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Company;

import java.util.Date;

public class AdDto {

    private String id;
    private String name;
    private Category category;
    private Company company;
    private String content;
    private String phone;
    private Date publishedDate;

    public AdDto() {
    }

    public AdDto(Ad ad) {
        this.id = ad.getId();
        this.name = ad.getName();
        this.category = ad.getCategory();
        this.company = ad.getCompany();
        this.content = ad.getContent();
        this.phone = ad.getPhone();
        this.publishedDate = ad.getPublishedDate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
