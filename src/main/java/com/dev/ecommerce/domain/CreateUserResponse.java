package com.dev.ecommerce.domain;

import com.dev.ecommerce.enums.StatusCode;

public class CreateUserResponse {
    private String uuid;
    private String message;
    private StatusCode status;

    public CreateUserResponse(String uuid, String message, StatusCode status) {
        this.uuid = uuid;
        this.message = message;
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StatusCode getStatus() {
        return status;
    }

    public void setStatus(StatusCode status) {
        this.status = status;
    }
}
