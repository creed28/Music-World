package com.musicworld.musicworld.converter;

import com.musicworld.musicworld.dto.CartDTO;
import com.musicworld.musicworld.model.Cart;
import com.musicworld.musicworld.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

    @Autowired
    private CartService cartService;
    @Autowired
    private AppUserConverter appUserConverter;

    public CartDTO convertEntityToDto(Cart cart){
        ModelMapper modelMapper = new ModelMapper();
        CartDTO map = modelMapper.map(cart, CartDTO.class);
        map.setAppUser(appUserConverter.convertEntityToDto(cart.getAppUser()));
        return map;
    }

    public Cart convertDtoToEntity(CartDTO cartDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cartDTO, Cart.class);
    }
}