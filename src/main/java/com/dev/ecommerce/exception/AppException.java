package com.dev.ecommerce.exception;

import com.dev.ecommerce.enums.ErrorCode;

public class AppException extends Exception {
    private ErrorCode errorCode;

    public AppException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public AppException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}
