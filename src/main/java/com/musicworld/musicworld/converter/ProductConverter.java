package com.musicworld.musicworld.converter;

import com.musicworld.musicworld.dto.ProductDTO;
import com.musicworld.musicworld.model.Product;
import com.musicworld.musicworld.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryConverter categoryConverter;

    public ProductDTO convertEntityToDto(Product product){
        ModelMapper modelMapper = new ModelMapper();
        ProductDTO map = modelMapper.map(product, ProductDTO.class);
        if(product.getCategory() != null) {
            map.setCategory(categoryConverter.convertEntityToDto(product.getCategory()));
        }
        return map;
    }

    public Product convertDtoToEntity(ProductDTO productDTO){
        ModelMapper modelMapper = new ModelMapper();
        Product map = modelMapper.map(productDTO, Product.class);
        if(productDTO.getId() != null) {
            Product existingProduct = productService.getProductById(productDTO.getId());
            checkProductFields(productDTO, map, existingProduct);
        }
        return map;
    }

    private void checkProductFields(ProductDTO productDTO, Product map, Product existingProduct) {
        if(productDTO.getBrand() == null){
            map.setBrand(existingProduct.getBrand());
        }
        if(productDTO.getName() == null){
            map.setName(existingProduct.getName());
        }
        if(productDTO.getDescription() == null){
            map.setDescription(existingProduct.getDescription());
        }
        if(productDTO.getImage() == null){
            map.setImage(existingProduct.getImage());
        }
        if(productDTO.getDiscount() == null){
            map.setDiscount(existingProduct.getDiscount());
        }
        if(productDTO.getPrice() == null){
            map.setPrice(existingProduct.getPrice());
        }
        if(productDTO.getQuantity() == null){
            map.setQuantity(existingProduct.getQuantity());
        }
        if(productDTO.getCategory() == null){
            map.setCategory(existingProduct.getCategory());
        }
    }
}