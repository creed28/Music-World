package com.musicworld.musicworld.service;

import com.musicworld.musicworld.model.Category;
import com.musicworld.musicworld.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void getCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        for (Category category : categoryList) {
            System.out.println(category.getName());
        }
    }

    public void getCategoryById(Long id) {
        Category category = categoryRepository.findById(id);
        System.out.println(category.getName());
    }

    public void createCategory(Category category) {
        categoryRepository.create(category);
        getCategories();
    }

    public void updateCategory(Category existingCategory) {
        categoryRepository.update(existingCategory);
        getCategories();
    }

    public void deleteCategory(Long id) {
        categoryRepository.delete(id);
        getCategories();
    }
}