package com.musicworld.musicworld.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "carts")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseModel {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appUser_id", referencedColumnName = "id", unique = true)
    private AppUser appUser;

    @OneToMany(mappedBy = "cart")
    private Set<CartProduct> cartProducts;
}