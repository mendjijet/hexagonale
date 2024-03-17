package com.jet.hexagonale.infrastruture.repository.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataCassandraOrderRepository extends CassandraRepository<OrderEntity, UUID> {}
