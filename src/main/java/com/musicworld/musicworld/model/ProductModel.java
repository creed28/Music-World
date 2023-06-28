package com.musicworld.musicworld.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
@Data
public abstract class ProductModel extends BaseModel {
    private String name;

    private Double price;

    private Integer quantity;

    private Double discount;

    private String description;

    private String brand;

    private String image;
}