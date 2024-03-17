package com.jet.hexagonale.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@EqualsAndHashCode
public class OrderItem {
    private UUID productId;
    private BigDecimal price;
    public OrderItem(final Product product) {
        this.productId = product.getId();
        this.price = product.getPrice();
    }
}
