package com.musicworld.musicworld.repository;

import com.musicworld.musicworld.model.Cart;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository extends ParentRepository<Cart> {

    @Override
    public Class<Cart> getEntityClass() {
        return Cart.class;
    }
}