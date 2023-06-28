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

    public void getOrderProducts() {
        List<OrderProduct> orderProductList = orderProductRepository.findAll();
        for (OrderProduct orderProduct : orderProductList) {
            System.out.println(orderProduct.getName());
        }
    }

    public void getOrderProductById(Long id) {
        OrderProduct orderProduct = orderProductRepository.findById(id);
        System.out.println(orderProduct.getName());
    }

    public void createOrderProduct(OrderProduct product) {
        orderProductRepository.create(product);
        getOrderProducts();
    }

}