package com.jet.hexagonale.domain.repository;

import com.jet.hexagonale.domain.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Optional<Order> findById(UUID id);

    void save(Order order);
}
