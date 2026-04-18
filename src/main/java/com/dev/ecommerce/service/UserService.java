package com.dev.ecommerce.service;

import com.dev.ecommerce.domain.CreateUserRequest;
import com.dev.ecommerce.domain.CreateUserResponse;
import com.dev.ecommerce.domain.UserResponse;
import com.dev.ecommerce.exception.AppException;

public interface UserService {
    UserResponse getUser(String uuid) throws AppException;
    CreateUserResponse saveUser(CreateUserRequest userRequest) throws AppException;
}
