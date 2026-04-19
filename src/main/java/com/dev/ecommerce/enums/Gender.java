package com.dev.ecommerce.enums;

public enum Gender {
    M("MALE"),
    F("FEMALE");
    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
