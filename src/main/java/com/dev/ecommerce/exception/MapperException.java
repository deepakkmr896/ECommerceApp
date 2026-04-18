package com.dev.ecommerce.exception;

import com.dev.ecommerce.enums.ErrorCode;

public class MapperException extends AppException {

    public MapperException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public MapperException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }
}
