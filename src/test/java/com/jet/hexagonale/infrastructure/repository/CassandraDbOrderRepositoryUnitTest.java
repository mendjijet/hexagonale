package com.jet.hexagonale.infrastructure.repository;

import com.jet.hexagonale.domain.Order;
import com.jet.hexagonale.domain.Product;
import com.jet.hexagonale.infrastruture.repository.cassandra.CassandraDbOrderRepository;
import com.jet.hexagonale.infrastruture.repository.cassandra.OrderEntity;
import com.jet.hexagonale.infrastruture.repository.cassandra.SpringDataCassandraOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CassandraDbOrderRepositoryUnitTest {
    private SpringDataCassandraOrderRepository springDataCassandraOrderRepository;
    private CassandraDbOrderRepository cassandraDbOrderRepository;

    @BeforeEach
    void setUp() {
        springDataCassandraOrderRepository = mock(SpringDataCassandraOrderRepository.class);

        cassandraDbOrderRepository = new CassandraDbOrderRepository(springDataCassandraOrderRepository);
    }

    @Test
    void shouldFindById_thenReturnOrder() {
        final UUID id = UUID.randomUUID();
        final OrderEntity orderEntity = createOrderEntity(id);
        when(springDataCassandraOrderRepository.findById(id)).thenReturn(Optional.of(orderEntity));

        final Optional<Order> result = cassandraDbOrderRepository.findById(id);

        assertEquals(orderEntity.toOrder(), result.get());
    }

    @Test
    void shouldSaveOrder_viaSpringDataOrderRepository() {
        final UUID id = UUID.randomUUID();
        final OrderEntity orderEntity = createOrderEntity(id);

        cassandraDbOrderRepository.save(orderEntity.toOrder());

        verify(springDataCassandraOrderRepository).save(any(OrderEntity.class));
    }

    private OrderEntity createOrderEntity(UUID id) {
        Order o = new Order(id, new Product(UUID.randomUUID(), BigDecimal.TEN, "product"));
        return new OrderEntity(o);
    }
}
