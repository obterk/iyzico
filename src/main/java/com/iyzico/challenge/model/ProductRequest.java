package com.iyzico.challenge.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest implements Serializable {

    private static final long serialVersionUID = -9105264583109034181L;

    @NotNull
    private long productId;

    @NotNull
    private String productName;

    @NotNull
    private String description;

    @NotNull
    private long remainingStock;

    @NotNull
    private long count;

    @NotNull
    private BigDecimal price;
}
