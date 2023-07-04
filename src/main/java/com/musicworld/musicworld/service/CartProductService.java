package com.musicworld.musicworld.service;

import com.musicworld.musicworld.model.CartProduct;
import com.musicworld.musicworld.repository.CartProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartProductService {

    @Autowired
    private CartProductRepository cartProductRepository;

    public List<CartProduct> getCartProducts() {
        return cartProductRepository.findAll();
    }

    public CartProduct getCartProductById(Long id) {
        return cartProductRepository.findById(id);
    }

    public CartProduct createCartProduct(CartProduct cartProduct) {
        return cartProductRepository.create(cartProduct);
    }

    public CartProduct updateCartProduct(CartProduct existingCartProduct) {
        return cartProductRepository.update(existingCartProduct);
    }

    public void deleteCartProduct(Long id) {
        cartProductRepository.delete(id);
    }
}