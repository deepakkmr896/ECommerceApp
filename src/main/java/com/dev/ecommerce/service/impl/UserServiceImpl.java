package com.dev.ecommerce.service.impl;

import com.dev.ecommerce.data.User;
import com.dev.ecommerce.domain.CreateUserRequest;
import com.dev.ecommerce.domain.CreateUserResponse;
import com.dev.ecommerce.domain.UserResponse;
import com.dev.ecommerce.enums.ErrorCode;
import com.dev.ecommerce.enums.StatusCode;
import com.dev.ecommerce.exception.AppException;
import com.dev.ecommerce.mappers.OrderMapper;
import com.dev.ecommerce.dao.UserDAO;
import com.dev.ecommerce.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserResponse getUser(String userId) throws AppException {
        Optional<User> user = this.userDAO.getUser(userId);
        if (user.isEmpty()) {
            throw new AppException(String.format("User not found, userId %s", userId), ErrorCode.USER_NOT_FOUND);
        }

        return new UserResponse(user.get());
    }

    @Override
    public CreateUserResponse saveUser(CreateUserRequest userRequest) throws AppException {
        if (userRequest == null || Strings.isBlank(userRequest.getPhone())) {
            throw new AppException("User Data is not present!!", ErrorCode.INSUFFICIENT_INPUT_DATA);
        }

        User user = OrderMapper.map(userRequest);
        this.userDAO.saveUser(user);
        return new CreateUserResponse(user.getUserId(), "User Created Successfully!!", StatusCode.SUCCESS);
    }
}
