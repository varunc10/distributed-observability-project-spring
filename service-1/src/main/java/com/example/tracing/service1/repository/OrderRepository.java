package com.example.tracing.service1.repository;

import com.example.tracing.service1.core.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order save(Order order);

    Optional<Order> findById(long id);

    Optional<Order> findByOrderNumber(String orderNumber);

    void deleteById(long id);
}
