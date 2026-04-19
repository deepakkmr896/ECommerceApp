package com.dev.ecommerce.service.impl;

import com.dev.ecommerce.data.Product;
import com.dev.ecommerce.domain.CreateProductRequest;
import com.dev.ecommerce.enums.StatusCode;
import com.dev.ecommerce.dao.ProductDAO;
import com.dev.ecommerce.exception.AppException;
import com.dev.ecommerce.mappers.OrderMapper;
import com.dev.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public StatusCode save(CreateProductRequest request) throws AppException {
        Product product = OrderMapper.map(request);
        this.productDAO.save(product);

        return StatusCode.SUCCESS;
    }
}
