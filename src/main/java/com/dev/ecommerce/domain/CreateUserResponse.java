package com.dev.ecommerce.domain;

import com.dev.ecommerce.enums.StatusCode;

public class CreateUserResponse {
    private final String userId;
    private final String message;
    private final StatusCode status;

    public CreateUserResponse(String userId, String message, StatusCode status) {
        this.userId = userId;
        this.message = message;
        this.status = status;
    }
}
