package com.musicworld.musicworld.service;

import com.musicworld.musicworld.model.Cart;
import com.musicworld.musicworld.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Long id) {
        return cartRepository.findById(id);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.create(cart);
    }

    public Cart updateCart(Cart existingCart) {
        return cartRepository.update(existingCart);
    }

    public void deleteCart(Long id) {
        cartRepository.delete(id);
    }
}