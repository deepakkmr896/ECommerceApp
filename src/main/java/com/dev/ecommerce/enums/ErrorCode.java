package com.dev.ecommerce.enums;

public enum ErrorCode {
    GENERIC_ERROR(101),
    ORDER_NOT_FOUND(102),
    ORDER_ALREADY_EXISTS(103),
    INTERNAL_ERROR(104),
    DB_ERROR(105),
    MAPPER_EXCEPTION(106), USER_NOT_FOUND(107), INSUFFICIENT_INPUT_DATA(108);

    private int id;

    ErrorCode(int id) {
        this.id = id;
    }

    public String getCode() {
        return this.name();
    }

    public String getId() {
        return String.valueOf(this.id);
    }
}
