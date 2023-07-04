package com.musicworld.musicworld.controller;

import com.musicworld.musicworld.model.Category;
import com.musicworld.musicworld.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category existingCategory){
        return categoryService.updateCategory(existingCategory);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}