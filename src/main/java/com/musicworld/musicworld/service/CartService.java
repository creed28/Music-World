package com.musicworld.musicworld.service;

import com.musicworld.musicworld.model.Cart;
import com.musicworld.musicworld.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void getCartById(Long id) {
        Cart cart = cartRepository.findById(id);
        System.out.println(cart.getCartProducts());
    }

    public void createCart(Cart cart) {
        cartRepository.create(cart);
        getCartById(cart.getId());
    }

    public void updateCart(Cart existingCart) {
        cartRepository.update(existingCart);
        getCartById(existingCart.getId());
    }

    public void deleteCart(Long id) {
        cartRepository.delete(id);
    }
}