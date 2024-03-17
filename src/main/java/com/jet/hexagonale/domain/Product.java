package com.jet.hexagonale.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@EqualsAndHashCode
public class Product {
    private final UUID id;
    private final BigDecimal price;
    private final String name;
    @JsonCreator
    public Product(@JsonProperty("id") final UUID id, @JsonProperty("price") final BigDecimal price, @JsonProperty("name") final String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
}
