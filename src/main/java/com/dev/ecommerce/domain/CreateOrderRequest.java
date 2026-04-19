package com.dev.ecommerce.domain;

import com.dev.ecommerce.data.Product;

import java.util.List;

public class CreateOrderRequest {
    private String id;
    private String userId;
    private List<Product> productDetails;

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public List<Product> getProductDetails() {
        return productDetails;
    }
}
