package com.musicworld.musicworld.controller;

import com.musicworld.musicworld.model.OrderProduct;
import com.musicworld.musicworld.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderProducts")
public class OrderProductController {
    @Autowired
    private OrderProductService orderProductService;

    @GetMapping("/all")
    public List<OrderProduct> getAllOrderProducts(){
        return orderProductService.getOrderProducts();
    }

    @GetMapping("/orderProduct/{id}")
    public OrderProduct getOrderProduct(@PathVariable Long id){
        return orderProductService.getOrderProductById(id);
    }

    @PostMapping("/add")
    public OrderProduct addOrderProduct(@RequestBody OrderProduct orderProduct){
        return orderProductService.createOrderProduct(orderProduct);
    }

    @PutMapping("/update")
    public OrderProduct updateOrderProduct(@RequestBody OrderProduct existingOrderProduct){
        return orderProductService.updateOrderProduct(existingOrderProduct);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderProduct(@PathVariable Long id){
        orderProductService.deleteOrderProduct(id);
    }
}