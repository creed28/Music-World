package com.musicworld.musicworld.converter;

import com.musicworld.musicworld.dto.OrderDTO;
import com.musicworld.musicworld.model.Order;
import com.musicworld.musicworld.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    @Autowired
    private OrderService orderService;

    public OrderDTO convertEntityToDto(Order order){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(order, OrderDTO.class);
    }

    public Order convertDtoToEntity(OrderDTO orderDTO){
        ModelMapper modelMapper = new ModelMapper();
        Order map = modelMapper.map(orderDTO, Order.class);
        if(orderDTO.getId() != null) {
            Order existingOrder = orderService.getOrderById(orderDTO.getId());
            checkProductFields(orderDTO, map, existingOrder);
        }
        return map;
    }

    private void checkProductFields(OrderDTO orderDTO, Order map, Order existingOrder) {
        if(orderDTO.getCreatedAt() == null){
            map.setCreatedAt(existingOrder.getCreatedAt());
        }
        if(orderDTO.getDiscount() == null){
            map.setDiscount(existingOrder.getDiscount());
        }
        if(orderDTO.getTotalPrice() == null){
            map.setTotalPrice(existingOrder.getTotalPrice());
        }
    }
}