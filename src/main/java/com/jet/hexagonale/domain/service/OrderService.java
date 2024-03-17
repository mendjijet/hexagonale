package com.jet.hexagonale.domain.service;

import com.jet.hexagonale.domain.Product;

import java.util.UUID;

public interface OrderService {
    UUID createOrder(Product product);

    void addProduct(UUID id, Product product);

    void completeOrder(UUID id);

    void deleteProduct(UUID id, UUID productId);
}
