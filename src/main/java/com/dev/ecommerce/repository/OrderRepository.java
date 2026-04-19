package com.dev.ecommerce.repository;

import com.dev.ecommerce.data.Order;
import com.dev.ecommerce.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findByIdAndUser(String id, User user);
}
