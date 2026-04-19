package com.dev.ecommerce.controller;

import com.dev.ecommerce.domain.CreateProductRequest;
import com.dev.ecommerce.enums.StatusCode;
import com.dev.ecommerce.exception.AppException;
import com.dev.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<StatusCode> save(@RequestBody CreateProductRequest request) throws AppException {
        return new ResponseEntity<>(this.productService.save(request), HttpStatus.CREATED);
    }
}
