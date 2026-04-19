package com.dev.ecommerce.controller;

import com.dev.ecommerce.domain.CreateUserRequest;
import com.dev.ecommerce.domain.CreateUserResponse;
import com.dev.ecommerce.domain.UserResponse;
import com.dev.ecommerce.exception.AppException;
import com.dev.ecommerce.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) throws AppException {
        CreateUserResponse response = this.userService.saveUser(createUserRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserResponse> createUser(@PathVariable String uuid) throws AppException {
        UserResponse response = this.userService.getUser(uuid);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
