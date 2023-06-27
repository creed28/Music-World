package com.musicworld.musicworld.repository;

import com.musicworld.musicworld.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository extends ParentRepository<Order> {
    @Override
    public String getEntityName() {
        return Order.class.getSimpleName();
    }
}