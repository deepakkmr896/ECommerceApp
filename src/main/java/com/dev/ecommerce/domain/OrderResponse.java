package com.dev.ecommerce.domain;

import com.dev.ecommerce.data.Product;
import com.dev.ecommerce.data.User;

import java.util.List;

public class OrderResponse {
    private String id;
    private User user;
    private List<Product> products;

    public OrderResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> productDetails) {
        this.products = productDetails;
    }
}
