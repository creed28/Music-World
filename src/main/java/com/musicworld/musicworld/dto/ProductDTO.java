package com.musicworld.musicworld.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private String description;
    private String brand;
    private String image;
    private Double discount;
    private CategoryDTO category;
}