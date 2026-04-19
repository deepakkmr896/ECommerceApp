package com.dev.ecommerce.repository;

import com.dev.ecommerce.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
