package com.dev.ecommerce.service.impl;

import com.dev.ecommerce.data.User;
import com.dev.ecommerce.domain.CreateUserRequest;
import com.dev.ecommerce.domain.CreateUserResponse;
import com.dev.ecommerce.domain.UserResponse;
import com.dev.ecommerce.enums.ErrorCode;
import com.dev.ecommerce.enums.StatusCode;
import com.dev.ecommerce.exception.AppException;
import com.dev.ecommerce.mappers.OrderMapper;
import com.dev.ecommerce.repository.UserRepository;
import com.dev.ecommerce.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse getUser(String uuid) throws AppException {
        Optional<User> user = this.userRepository.getUser(uuid);
        if (user.isEmpty()) {
            throw new AppException(String.format("User not found, uuid %s", uuid), ErrorCode.USER_NOT_FOUND);
        }

        return new UserResponse(user.get());
    }

    @Override
    public CreateUserResponse saveUser(CreateUserRequest userRequest) throws AppException {
        if (userRequest == null || Strings.isBlank(userRequest.getUuid())) {
            throw new AppException("User Data is not present!!", ErrorCode.INSUFFICIENT_INPUT_DATA);
        }
        User user = OrderMapper.map(userRequest);
        this.userRepository.saveUser(user);
        return new CreateUserResponse(user.getUuid(), "User Created Successfully!!", StatusCode.SUCCESS);
    }
}
