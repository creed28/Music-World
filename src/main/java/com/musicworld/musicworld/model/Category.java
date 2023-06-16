package com.musicworld.musicworld.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="parentCategory")
    private Category parentCategory;

    @OneToMany(mappedBy="subCategories")
    private Set<Category> subCategories;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}