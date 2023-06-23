package com.musicworld.musicworld.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "order")
@Table(name = "orders")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseModel {
    private Double totalPrice;

    private Double discount;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "appUser_id")
    private AppUser appUser;

    @OneToMany(mappedBy = "order")
    private Set<OrderProduct> orderProducts;
}