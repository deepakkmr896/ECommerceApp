package com.dev.ecommerce.service;

import com.dev.ecommerce.domain.CreateProductRequest;
import com.dev.ecommerce.enums.StatusCode;
import com.dev.ecommerce.exception.AppException;

public interface ProductService {
    StatusCode save(CreateProductRequest request) throws AppException;
}
