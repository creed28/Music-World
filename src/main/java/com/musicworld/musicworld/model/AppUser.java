package com.musicworld.musicworld.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "appUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    private String email;

    private String password;

    @OneToMany(mappedBy = "appUser")
    private Set<Order> orders;

    @OneToMany(mappedBy = "appUser")
    private Set<Review> reviews;

    @OneToOne(mappedBy = "appUser")
    private Cart cart;
}