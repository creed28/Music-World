package com.musicworld.musicworld.controller;

import com.musicworld.musicworld.converter.CategoryConverter;
import com.musicworld.musicworld.dto.CategoryDTO;
import com.musicworld.musicworld.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryConverter categoryConverter;

    @GetMapping("/all")
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getCategories().stream().map(category -> categoryConverter.convertEntityToDto(category))
                .collect(Collectors.toList());
    }

    @GetMapping("/category/{id}")
    public CategoryDTO getCategory(@PathVariable Long id){
        if(categoryService.getCategoryById(id) == null){
            return null;
        }
        return categoryConverter.convertEntityToDto(categoryService.getCategoryById(id));
    }

    @PostMapping("/add")
    public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryConverter.convertEntityToDto(categoryService.createCategory
                (categoryConverter.convertDtoToEntity(categoryDTO)));
    }

    @PutMapping("/update")
    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryConverter.convertEntityToDto(categoryService.updateCategory
                (categoryConverter.convertDtoToEntity(categoryDTO)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}