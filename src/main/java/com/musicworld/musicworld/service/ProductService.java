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

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.create(product);
    }

    public Product updateProduct(Product existingProduct) {
        return productRepository.update(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }
}