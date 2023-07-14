package com.musicworld.musicworld.converter;

import com.musicworld.musicworld.dto.AppUserDTO;
import com.musicworld.musicworld.dto.CategoryDTO;
import com.musicworld.musicworld.model.AppUser;
import com.musicworld.musicworld.model.Category;
import com.musicworld.musicworld.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CategoryConverter {

    @Autowired
    private CategoryService categoryService;

    public CategoryDTO convertEntityToDto(Category category){
        ModelMapper modelMapper = new ModelMapper();
        CategoryDTO map = modelMapper.map(category, CategoryDTO.class);
        if(category.getParentCategory() != null) {
            setSubCategories(category, map);
        }
        if(category.getSubCategories() != null){
            map.setSubCategories(category.getSubCategories().stream().map(this::convertEntityToDto)
                    .collect(Collectors.toSet()));
        }
        return map;
    }

    public Category convertDtoToEntity(CategoryDTO categoryDTO){
        ModelMapper modelMapper = new ModelMapper();
        Category map = modelMapper.map(categoryDTO, Category.class);
        if(categoryDTO.getId() == null && categoryDTO.getParentCategory() != null) {
            convertParentToEntity(categoryDTO, map);
        }
//        if(categoryDTO.getId() != null) {
//            Category existingCategory = categoryService.getCategoryById(categoryDTO.getId());
//            checkProductFields(categoryDTO, map, existingCategory);
//        }
        return map;
    }

    private void convertParentToEntity(CategoryDTO categoryDTO, Category map){
        Category parentCategory = categoryService.getCategoryById(categoryDTO.getParentCategory().getId());
        Set<Category> parentSubCategories = Collections.emptySet();
        if(parentCategory.getSubCategories() != null) {
            parentSubCategories = parentCategory.getSubCategories();
            parentSubCategories.add(map);
        } else {
            parentSubCategories.add(map);
        }
        parentCategory.setSubCategories(parentSubCategories);
        map.setParentCategory(parentCategory);
    }

    private void setSubCategories(Category category, CategoryDTO map){
        Category parentCategory = categoryService.getCategoryById(category.getParentCategory().getId());
        ModelMapper modelMapper = new ModelMapper();
        CategoryDTO parentMap = modelMapper.map(parentCategory, CategoryDTO.class);
        Set<CategoryDTO> parentSubCategories = Collections.emptySet();
        if(parentCategory.getSubCategories() != null){
            parentMap.setSubCategories(parentCategory.getSubCategories().stream().map(this::convertEntityToDto)
                    .collect(Collectors.toSet()));
           parentSubCategories = parentMap.getSubCategories();
           parentSubCategories.add(map);
        } else{
            parentSubCategories.add(map);
        }
        parentMap.setSubCategories(parentSubCategories);
        map.setParentCategory(parentMap);
    }

    private void checkProductFields(CategoryDTO categoryDTO, Category map, Category existingCategory) {
        if(categoryDTO.getName() == null){
            map.setName(existingCategory.getName());
        }
        if(categoryDTO.getParentCategory() == null){
            map.setParentCategory(existingCategory.getParentCategory());
        }
        if(categoryDTO.getSubCategories() == null){
            map.setSubCategories(existingCategory.getSubCategories());
        }
    }
}