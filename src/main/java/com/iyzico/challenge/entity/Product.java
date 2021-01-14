package com.iyzico.challenge.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    @Size(max = 255)
    private String productName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private long remainingStock;

    @Column(nullable = false)
    @Size(max = 100)
    private long count;

    @Column(nullable = false)
    private BigDecimal price;

}
