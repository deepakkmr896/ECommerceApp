package com.dev.ecommerce.data;

import jakarta.persistence.*;

@Entity
@Table(name = "dev_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    private String sku;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return this.order;
    }
}
