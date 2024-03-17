package com.jet.hexagonale.infrastruture.repository.cassandra;

import java.math.BigDecimal;
import java.util.UUID;

import com.jet.hexagonale.domain.OrderItem;
import com.jet.hexagonale.domain.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
@Getter
@Setter
public class OrderItemEntity {

   private UUID productId;
    private BigDecimal price;

    public OrderItemEntity() {
    }

    public OrderItemEntity(final OrderItem orderItem) {
        this.productId = orderItem.getProductId();
        this.price = orderItem.getPrice();
    }

    public OrderItem toOrderItem() {
        return new OrderItem(new Product(productId, price, ""));
    }
}
