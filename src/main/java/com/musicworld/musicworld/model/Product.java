package com.musicworld.musicworld.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel{
    private String name;

    private Double price;

    private Integer quantity;

    private Double discount;

    private String description;

    private String brand;

    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<OrderProduct> orderProducts;

    @OneToMany(mappedBy = "product")
    private Set<CartProduct> cartProducts;
}