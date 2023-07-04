package com.musicworld.musicworld.controller;

import com.musicworld.musicworld.model.Order;
import com.musicworld.musicworld.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAllOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order existingOrder){
        return orderService.updateOrder(existingOrder);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}