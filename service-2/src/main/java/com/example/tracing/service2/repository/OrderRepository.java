package com.example.tracing.service2.repository;

import com.example.tracing.service2.core.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, Long> {
    Order save(Order order);

    Optional<Order> findById(long id);

    Optional<Order> findByOrderNumber(String orderNumber);

    void deleteById(long id);
}
