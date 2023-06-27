package com.musicworld.musicworld.repository;

import com.musicworld.musicworld.model.OrderProduct;
import org.springframework.stereotype.Repository;

@Repository
public class OrderProductRepository extends ParentRepository<OrderProduct> {
    @Override
    public String getEntityName() {
        return OrderProduct.class.getSimpleName();
    }
}