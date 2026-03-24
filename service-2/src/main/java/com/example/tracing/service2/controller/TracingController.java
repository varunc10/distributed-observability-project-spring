package com.example.tracing.service2.controller;

import com.example.tracing.service2.client.Service4Client;
import com.example.tracing.service2.core.Order;
import com.example.tracing.service2.core.OrderRequest;
import com.example.tracing.service2.core.User;
import com.example.tracing.service2.repository.OrderRepository;
import com.example.tracing.service2.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tracing/service2")
@Slf4j
public class TracingController {

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final Service4Client service4Client;

    public TracingController(final OrderRepository orderRepository,
                             final UserRepository userRepository,
                             final Service4Client service4Client) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.service4Client = service4Client;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {
        log.info("Received request to create order {}", orderRequest);

        log.info("Fetching user {}", orderRequest.getUserId());
        Optional<User> optionalUser = userRepository.findById(orderRequest.getUserId());
        if (optionalUser.isEmpty()) {
            log.warn("User {} not found", orderRequest.getUserId());
            return ResponseEntity.notFound().build();
        }
        User user = optionalUser.get();
        Order order = Order.builder()
                .orderNumber(orderRequest.getOrderNumber())
                .user(user)
                .build();
        Order savedOrder = orderRepository.save(order);
        log.info("Created order {}", savedOrder);
        try {
            log.info("Sending order to service4 {}", savedOrder);
            service4Client.createOrder(orderRequest);
        } catch (Exception e) {
            log.error("Exception occurred while creating order {}", e.getMessage(), e);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Order created");
    }
}
