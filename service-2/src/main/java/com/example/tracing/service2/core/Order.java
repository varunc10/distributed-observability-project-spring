package com.example.tracing.service2.core;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
@Data
public class Order {
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String orderNumber;

    private User user;

    @Builder
    public Order(final String orderNumber, final User user) {
        this.orderNumber = orderNumber;
        this.user = user;
    }
}
