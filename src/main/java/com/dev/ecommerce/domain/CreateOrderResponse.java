package com.dev.ecommerce.domain;

import com.dev.ecommerce.enums.StatusCode;

public class CreateOrderResponse {
    private String id;

    private String message;

    private StatusCode status;

    public CreateOrderResponse(String id, String message, StatusCode status) {
        this.id = id;
        this.message = message;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }


    public StatusCode getStatus() {
        return status;
    }
}
