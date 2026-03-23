package com.example.tracing.service1.core;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "orders",
    indexes = {
        @Index(name = "order_number", columnList = "orderNumber")
    }
)
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String orderNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Builder
    public Order(final String orderNumber, final User user) {
        this.orderNumber = orderNumber;
        this.user = user;
    }
}
