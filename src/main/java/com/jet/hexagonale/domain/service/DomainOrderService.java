package com.jet.hexagonale.domain.service;

import com.jet.hexagonale.domain.Order;
import com.jet.hexagonale.domain.Product;
import com.jet.hexagonale.domain.repository.OrderRepository;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class DomainOrderService implements OrderService {
    private final OrderRepository orderRepository;

/**
*
 * @param product
 * @return
*/
    @Override
    public UUID createOrder(final Product product) {
        final Order order = new Order(UUID.randomUUID(), product);
        orderRepository.save(order);

        return order.getId();
    }

/**
*
 * @param id
 * @param product
*/
    @Override
    public void addProduct(final UUID id, final Product product) {
        final Order order = getOrder(id);
        order.addOrder(product);

        orderRepository.save(order);
    }

/**
*
 * @param id
*/
    @Override
    public void completeOrder(final UUID id) {
        final Order order = getOrder(id);
        order.complete();

        orderRepository.save(order);
    }

/**
*
 * @param id
 * @param productId
*/
    @Override
    public void deleteProduct(final UUID id, final UUID productId) {
        final Order order = getOrder(id);
        order.removeOrder(productId);

        orderRepository.save(order);
    }

    private Order getOrder(UUID id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Order with given id doesn't exist"));
    }
}
