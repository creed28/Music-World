package com.musicworld.musicworld.repository;

import com.musicworld.musicworld.model.Cart;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository extends ParentRepository<Cart> {
    @Override
    public String getEntityName() {
        return Cart.class.getSimpleName();
    }
}