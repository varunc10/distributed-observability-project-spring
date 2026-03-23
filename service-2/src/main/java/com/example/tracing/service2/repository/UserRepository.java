package com.example.tracing.service2.repository;

import com.example.tracing.service2.core.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    User save(User user);

    Optional<User> findById(long id);

    Optional<User> findByEmail(String email);

    void deleteById(long id);
}
