package com.musicworld.musicworld.service;

import com.musicworld.musicworld.model.OrderProduct;
import com.musicworld.musicworld.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    public List<OrderProduct> getOrderProducts() {
        return orderProductRepository.findAll();
    }

    public OrderProduct getOrderProductById(Long id) {
        return orderProductRepository.findById(id);
    }

    public OrderProduct createOrderProduct(OrderProduct product) {
        return orderProductRepository.create(product);
    }

    public OrderProduct updateOrderProduct(OrderProduct existingOrderProduct) {
        return orderProductRepository.update(existingOrderProduct);
    }

    public void deleteOrderProduct(Long id) {
        orderProductRepository.delete(id);
    }
}