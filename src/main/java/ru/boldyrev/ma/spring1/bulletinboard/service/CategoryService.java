package ru.boldyrev.ma.spring1.bulletinboard.service;

import ru.boldyrev.ma.spring1.bulletinboard.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getListOfCategory();

    Category findCategoryById(String categoryId);

    void persist(Category category);

    void deleteById(String categoryId);

    void setName(String name, String categoryId);
}