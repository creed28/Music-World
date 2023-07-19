package com.musicworld.musicworld.dto;

import com.musicworld.musicworld.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProductDTO {
    private Long id;
    private Integer quantity;
    private Product product;
}