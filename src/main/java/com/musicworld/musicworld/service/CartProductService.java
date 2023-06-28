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

    public void getCartProducts() {
        List<CartProduct> cartProductList = cartProductRepository.findAll();
        for (CartProduct cartProduct : cartProductList) {
            System.out.println(cartProduct.getProduct().getName());
        }
    }

    public void createCartProduct(CartProduct cartProduct) {
        cartProductRepository.create(cartProduct);
        getCartProducts();
    }

    public void updateCartProduct(CartProduct existingCartProduct) {
        cartProductRepository.update(existingCartProduct);
        getCartProducts();
    }

    public void deleteCartProduct(Long id) {
        cartProductRepository.delete(id);
        getCartProducts();
    }
}