package com.example.tracing.service2.core;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
public class User {
    private String name;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String email;

    private List<Order> orders;

    @Builder
    public User(final String name, final String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }
}
