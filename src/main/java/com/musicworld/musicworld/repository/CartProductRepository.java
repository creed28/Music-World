package com.musicworld.musicworld.repository;

import com.musicworld.musicworld.model.CartProduct;
import org.springframework.stereotype.Repository;

@Repository
public class CartProductRepository extends ParentRepository<CartProduct> {
    @Override
    public String getEntityName() {
        return CartProduct.class.getSimpleName();
    }
}