package com.musicworld.musicworld.controller;

import com.musicworld.musicworld.converter.OrderConverter;
import com.musicworld.musicworld.dto.OrderDTO;
import com.musicworld.musicworld.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderConverter orderConverter;

    @GetMapping("/all")
    public List<OrderDTO> getAllOrders(){
        return orderService.getOrders().stream().map(order -> orderConverter.convertEntityToDto(order))
                .collect(Collectors.toList());
    }

    @GetMapping("/order/{id}")
    public OrderDTO getOrder(@PathVariable Long id){
        if(orderService.getOrderById(id) == null){
            return null;
        }
        return orderConverter.convertEntityToDto(orderService.getOrderById(id));
    }

    @PostMapping("/add")
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO){
        return orderConverter.convertEntityToDto(orderService.createOrder
                (orderConverter.convertDtoToEntity(orderDTO)));
    }

    @PutMapping("/update")
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO){
        return orderConverter.convertEntityToDto(orderService.updateOrder
                (orderConverter.convertDtoToEntity(orderDTO)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}