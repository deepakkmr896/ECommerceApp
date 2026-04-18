package com.dev.ecommerce.dto;

public class ErrorResponse {
    public String error;
    public String code;
    public String id;

    public ErrorResponse(String error, String code, String id) {
        this.error = error;
        this.code = code;
        this.id = id;
    }
}
