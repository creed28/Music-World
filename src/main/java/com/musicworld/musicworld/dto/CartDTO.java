package com.musicworld.musicworld.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long id;
    private AppUserDTO appUser;
    private Set<CartProductDTO> cartProducts;
}