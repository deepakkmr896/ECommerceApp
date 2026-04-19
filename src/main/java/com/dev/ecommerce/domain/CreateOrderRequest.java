package com.dev.ecommerce.domain;

import java.util.List;

public class CreateOrderRequest {
    private String userId;
    private List<String> productIds;

    public String getUserId() {
        return userId;
    }

    public List<String> getProductIds() {
        return productIds;
    }
}
