package com.dev.ecommerce.domain;

import com.dev.ecommerce.enums.StatusCode;

public class CreateUserResponse {
    private final String uuid;
    private final String message;
    private final StatusCode status;

    public CreateUserResponse(String uuid, String message, StatusCode status) {
        this.uuid = uuid;
        this.message = message;
        this.status = status;
    }
}
