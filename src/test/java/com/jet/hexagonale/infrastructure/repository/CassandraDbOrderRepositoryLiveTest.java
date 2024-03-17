package com.jet.hexagonale.infrastructure.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import com.jet.hexagonale.domain.Order;
import com.jet.hexagonale.domain.Product;
import com.jet.hexagonale.domain.repository.OrderRepository;
import com.jet.hexagonale.infrastruture.repository.cassandra.SpringDataCassandraOrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/*
 To run this test we need to run the databases first.
 A dedicated docker-compose.yml file is located under the resources directory.
 We can run it by simple executing `docker-compose up`.
 */

@SpringJUnitConfig
@SpringBootTest
@TestPropertySource("classpath:ddd-layers-test.properties")
class CassandraDbOrderRepositoryLiveTest {
    @Autowired
    private SpringDataCassandraOrderRepository cassandraOrderRepository;

    @Autowired
    private OrderRepository orderRepository;

    @AfterEach
    void cleanUp() {
        cassandraOrderRepository.deleteAll();
    }

    @Test
    void shouldFindById_thenReturnOrder() {

        // given
        final UUID id = UUID.randomUUID();
        final Order order = createOrder(id);
        order.addOrder(new Product(UUID.randomUUID(), BigDecimal.TEN, "second"));
        order.complete();

        // when
        orderRepository.save(order);

        final Optional<Order> result = orderRepository.findById(id);

        assertEquals(order, result.get());
    }

    private Order createOrder(UUID id) {
        return new Order(id, new Product(UUID.randomUUID(), BigDecimal.TEN, "product"));
    }
}
