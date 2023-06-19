package com.musicworld.musicworld.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "appUsers")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser extends BaseModel{
    @Column(name = "username", unique = true)
    private String username;

    private String email;

    private String password;

    @OneToMany(mappedBy = "appUser")
    private Set<Order> orders;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private Set<Review> reviews;

    @OneToOne(mappedBy = "appUser")
    private Cart cart;
}