package com.dev.ecommerce.data;

import java.util.List;

public class Order {
    private String id;
    private List<Product> products;
    private User user;

    public Order(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
