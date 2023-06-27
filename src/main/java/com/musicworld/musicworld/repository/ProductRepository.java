package com.musicworld.musicworld.repository;

import com.musicworld.musicworld.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends ParentRepository<Product> {
    @Override
    public String getEntityName() {
        return Product.class.getSimpleName();
    }
}