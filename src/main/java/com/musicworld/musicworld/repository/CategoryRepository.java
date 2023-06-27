package com.musicworld.musicworld.repository;

import com.musicworld.musicworld.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository extends ParentRepository<Category> {
    @Override
    public String getEntityName() {
        return Category.class.getSimpleName();
    }
}