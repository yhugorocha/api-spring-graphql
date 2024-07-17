package com.hugodev.ApiGraphQL.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "cotegory_id")
    private Category category;

    public Product (String name, BigDecimal price, Category category){
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
