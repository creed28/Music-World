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
public class Product extends ProductModel{

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<OrderProduct> orderProducts;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<CartProduct> cartProducts;

//    public Product(String name, String description){
//        this.name = name;
//        this.description = description;
//    }
}