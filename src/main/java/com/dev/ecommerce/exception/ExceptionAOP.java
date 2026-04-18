package com.dev.ecommerce.exception;

import com.dev.ecommerce.dto.ErrorResponse;
import com.dev.ecommerce.enums.ErrorCode;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAOP {

    @ExceptionHandler(exception = OrderException.class)
    public ResponseEntity<?> handleOrderException(OrderException ex) {
        System.out.printf("Encountered OrderException:: error code: %s, Error: %s%n", ex.getErrorCode().getCode(), ex);

        ErrorResponse error = new ErrorResponse(ex.getMessage(), ex.getErrorCode().getCode(), ex.getErrorCode().getId());

        return new ResponseEntity<>(error, HttpStatusCode.valueOf(500));
    }

    @ExceptionHandler(exception = DataBaseException.class)
    public ResponseEntity<?> handleAppException(DataBaseException ex) {
        System.out.printf("Encountered DataBaseException:: error code: %s, Error: %s%n", ex.getErrorCode().getCode(), ex);

        ErrorResponse error = new ErrorResponse("We encountered some internal error!!", ErrorCode.INTERNAL_ERROR.getCode(), ex.getErrorCode().getId());

        return new ResponseEntity<>(error, HttpStatusCode.valueOf(500));
    }

    @ExceptionHandler(exception = AppException.class)
    public ResponseEntity<?> handleAppException(AppException ex) {
        System.out.printf("Encountered AppException:: error code: %s, Error: %s%n", ex.getErrorCode().getCode(), ex);

        ErrorResponse error = new ErrorResponse(ex.getMessage(), ex.getErrorCode().getCode(), ex.getErrorCode().getId());

        return new ResponseEntity<>(error, HttpStatusCode.valueOf(500));
    }


    @ExceptionHandler(exception = Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex) {
        System.out.printf("Encountered Exception:: Error: %s%n", ex);

        ErrorResponse error = new ErrorResponse("We encountered some internal error!!", ErrorCode.GENERIC_ERROR.getCode(), ErrorCode.GENERIC_ERROR.getId());

        return new ResponseEntity<>(error, HttpStatusCode.valueOf(500));
    }
}
