package com.dev.ecommerce.domain;

import com.dev.ecommerce.data.Product;
import com.dev.ecommerce.data.User;

import java.util.List;

public class OrderResponse {
    private final String id;
    private final User user;
    private final List<Product> products;

    public OrderResponse(String id, User user, List<Product> products) {
        this.id = id;
        this.user = user;
        this.products = products;
    }
}
