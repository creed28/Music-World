package com.musicworld.musicworld.repository;

import com.musicworld.musicworld.model.CartProduct;
import org.springframework.stereotype.Repository;

@Repository
public class CartProductRepository extends ParentRepository<CartProduct> {

    @Override
    public Class<CartProduct> getEntityClass(){
        return CartProduct.class;
    }
}