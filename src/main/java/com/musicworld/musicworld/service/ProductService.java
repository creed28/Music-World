package com.musicworld.musicworld.service;

import com.musicworld.musicworld.model.Product;
import com.musicworld.musicworld.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void getProducts() {
        List<Product> productList = productRepository.findAll();
        for (Product product : productList) {
            System.out.println(product.getName());
        }
    }

    public void getProductById(Long id) {
        Product product = productRepository.findById(id);
        System.out.println(product.getName());
    }

    public void createProduct(Product product) {
        productRepository.create(product);
        getProducts();
    }

    public void updateProduct(Product existingProduct) {
        productRepository.update(existingProduct);
        getProducts();
    }

    public void deleteProduct(Long id) {
        productRepository.delete(id);
        getProducts();
    }
}