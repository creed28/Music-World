package com.musicworld.musicworld.service;

import com.musicworld.musicworld.model.Order;
import com.musicworld.musicworld.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.create(order);
    }

    public Order updateOrder(Order existingOrder) {
        return orderRepository.update(existingOrder);
    }

    public void deleteOrder(Long id) {
        orderRepository.delete(id);
    }
}