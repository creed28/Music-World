package com.musicworld.musicworld.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orderProducts")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String name;

    private Integer quantity;

    private Double price;

    private String description;

    private String image;

    private Double discount;

    private String brand;

    @OneToMany(mappedBy = "orderProduct")
    private Set<Review> reviews;
}