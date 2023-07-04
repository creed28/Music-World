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

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category) {
        return categoryRepository.create(category);
    }

    public Category updateCategory(Category existingCategory) {
        return categoryRepository.update(existingCategory);
    }

    public void deleteCategory(Long id) {
        categoryRepository.delete(id);
    }
}