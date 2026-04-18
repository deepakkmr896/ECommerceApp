package com.dev.ecommerce.exception;

import com.dev.ecommerce.enums.ErrorCode;

public class OrderException extends AppException {

    public OrderException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public OrderException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }
}
