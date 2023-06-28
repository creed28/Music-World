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

    public void getOrders() {
        List<Order> orderList = orderRepository.findAll();
        for (Order order : orderList) {
            System.out.println(order.getTotalPrice());
        }
    }

    public void getOrderById(Long id) {
        Order order = orderRepository.findById(id);
        System.out.println(order.getTotalPrice());
    }

    public void createOrder(Order order) {
        orderRepository.create(order);
        getOrders();
    }

}