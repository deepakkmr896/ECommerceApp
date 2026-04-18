package com.dev.ecommerce.domain;

import com.dev.ecommerce.data.User;

public class UserResponse {
    private final User user;

    public UserResponse(User user) {
        this.user = user;
    }
}
