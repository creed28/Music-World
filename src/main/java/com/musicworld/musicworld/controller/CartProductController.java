package com.musicworld.musicworld.controller;

import com.musicworld.musicworld.model.CartProduct;
import com.musicworld.musicworld.service.CartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartProducts")
public class CartProductController {
    @Autowired
    private CartProductService cartProductService;

    @GetMapping("/all")
    public List<CartProduct> getAllCartProducts(){
        return cartProductService.getCartProducts();
    }

    @GetMapping("/cartProduct/{id}")
    public CartProduct getCartProduct(@PathVariable Long id){
        return cartProductService.getCartProductById(id);
    }

    @PostMapping("/add")
    public CartProduct addCartProduct(@RequestBody CartProduct cartProduct){
        return cartProductService.createCartProduct(cartProduct);
    }

    @PutMapping("/update")
    public CartProduct updateCartProduct(@RequestBody CartProduct existingCartProduct){
        return cartProductService.updateCartProduct(existingCartProduct);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCartProduct(@PathVariable Long id){
        cartProductService.deleteCartProduct(id);
    }
}