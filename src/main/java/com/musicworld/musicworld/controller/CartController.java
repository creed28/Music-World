package com.musicworld.musicworld.controller;

import com.musicworld.musicworld.converter.CartConverter;
import com.musicworld.musicworld.dto.CartDTO;
import com.musicworld.musicworld.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartConverter cartConverter;

    @GetMapping("/all")
    public List<CartDTO> getAllCarts(){
        return cartService.getCarts().stream().map(cart -> cartConverter.convertEntityToDto(cart))
                .collect(Collectors.toList());
    }

    @GetMapping("/cart/{id}")
    public CartDTO getCart(@PathVariable Long id){
        if(cartService.getCartById(id) == null){
            return null;
        }
        return cartConverter.convertEntityToDto(cartService.getCartById(id));
    }

    @PostMapping("/add")
    public CartDTO addCart(@RequestBody CartDTO cartDTO){
        return cartConverter.convertEntityToDto(cartService.createCart
                (cartConverter.convertDtoToEntity(cartDTO)));
    }

    @PutMapping("/update")
    public CartDTO updateCart(@RequestBody CartDTO cartDTO){
        return cartConverter.convertEntityToDto(cartService.updateCart
                (cartConverter.convertDtoToEntity(cartDTO)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCart(@PathVariable Long id){
        cartService.deleteCart(id);
    }
}