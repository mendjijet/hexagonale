package com.jet.hexagonale.infrastruture.configuration;

import com.jet.hexagonale.HexagonaleApplication;
import com.jet.hexagonale.domain.repository.OrderRepository;
import com.jet.hexagonale.domain.service.DomainOrderService;
import com.jet.hexagonale.domain.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = HexagonaleApplication.class)
public class BeanConfiguration {
    @Bean
    OrderService orderService(final OrderRepository orderRepository) {
        return new DomainOrderService(orderRepository);
    }
}
