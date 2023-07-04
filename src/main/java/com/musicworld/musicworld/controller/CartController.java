package com.musicworld.musicworld.controller;

import com.musicworld.musicworld.model.Cart;
import com.musicworld.musicworld.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/all")
    public List<Cart> getAllCarts(){
        return cartService.getCarts();
    }

    @GetMapping("/cart/{id}")
    public Cart getCartById(@PathVariable Long id){
        return cartService.getCartById(id);
    }

    @PostMapping("/add")
    public Cart addCart(@RequestBody Cart cart){
        return cartService.createCart(cart);
    }

    @PutMapping("/update")
    public Cart updateCart(@RequestBody Cart existingCart){
        return cartService.updateCart(existingCart);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCart(@PathVariable Long id){
        cartService.deleteCart(id);
    }
}