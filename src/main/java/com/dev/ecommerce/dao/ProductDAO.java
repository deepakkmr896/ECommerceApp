package com.dev.ecommerce.dao;

import com.dev.ecommerce.data.Product;
import com.dev.ecommerce.enums.ErrorCode;
import com.dev.ecommerce.exception.AppException;
import com.dev.ecommerce.exception.DataBaseException;
import com.dev.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductDAO {
    private final ProductRepository productRepository;

    public ProductDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProduct(String id) throws AppException {
        try {
            return this.productRepository.findById(id);
        } catch (Exception e) {
            throw new DataBaseException(String.format("Error while retrieving product data for product id: %s", id), ErrorCode.DB_ERROR);
        }
    }

    public void save(Product product) throws AppException {
        try {
            this.productRepository.save(product);
        } catch (Exception e) {
            throw new DataBaseException("Error while saving Product!!", ErrorCode.DB_ERROR);
        }
    }
}
