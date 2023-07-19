package com.musicworld.musicworld.dto;

import com.musicworld.musicworld.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductDTO {
    private Long id;
    private Integer quantity;
    private Double price;
    private String description;
    private String image;
    private String brand;
    private String name;
    private Double discount;
    private Product product;
}