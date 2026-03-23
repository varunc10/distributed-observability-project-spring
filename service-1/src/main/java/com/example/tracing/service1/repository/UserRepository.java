package com.example.tracing.service1.repository;

import com.example.tracing.service1.core.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    Optional<User> findById(long id);

    Optional<User> findByEmail(String email);

    void deleteById(long id);
}
