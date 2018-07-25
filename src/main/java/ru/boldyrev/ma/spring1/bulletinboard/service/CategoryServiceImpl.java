package ru.boldyrev.ma.spring1.bulletinboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.boldyrev.ma.spring1.bulletinboard.entity.Category;
import ru.boldyrev.ma.spring1.bulletinboard.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Category> getListOfCategory() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Category findCategoryById(String categoryId) {
        return categoryRepository.getOne(categoryId);
    }

    @Override
    @Transactional
    public void persist(Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteById(String categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    @Transactional
    public void setName(String name, String categoryId) {
        categoryRepository.setName(name, categoryId);
    }
}
