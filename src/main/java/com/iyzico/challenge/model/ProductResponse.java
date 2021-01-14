package com.iyzico.challenge.model;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
public class ProductResponse {

    private String productName;
    private String description;
    private long remainingStock;
    private long count;
    private BigDecimal price;

}
