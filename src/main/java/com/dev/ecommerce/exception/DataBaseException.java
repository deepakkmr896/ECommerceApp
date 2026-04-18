package com.dev.ecommerce.exception;

import com.dev.ecommerce.enums.ErrorCode;

public class DataBaseException extends AppException {
    public DataBaseException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public DataBaseException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }
}
