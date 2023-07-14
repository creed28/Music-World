package com.musicworld.musicworld.controller;

import com.musicworld.musicworld.converter.ProductConverter;
import com.musicworld.musicworld.dto.ProductDTO;
import com.musicworld.musicworld.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductConverter productConverter;

    @GetMapping("/all")
    public List<ProductDTO> getAllProducts(){
        return productService.getProducts().stream().map(product -> productConverter.convertEntityToDto(product))
                .collect(Collectors.toList());
    }

    @GetMapping("/product/{id}")
    public ProductDTO getProduct(@PathVariable Long id){
        if(productService.getProductById(id) == null){
            return null;
        }
        return productConverter.convertEntityToDto(productService.getProductById(id));
    }

    @PostMapping("/add")
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO){
        return productConverter.convertEntityToDto(productService.createProduct
                (productConverter.convertDtoToEntity(productDTO)));
    }

    @PutMapping("/update")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO){
        return productConverter.convertEntityToDto(productService.updateProduct
                (productConverter.convertDtoToEntity(productDTO)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}