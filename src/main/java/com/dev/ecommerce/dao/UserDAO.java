package com.dev.ecommerce.dao;

import com.dev.ecommerce.data.User;
import com.dev.ecommerce.enums.ErrorCode;
import com.dev.ecommerce.exception.AppException;
import com.dev.ecommerce.exception.DataBaseException;
import com.dev.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAO {
    private final UserRepository userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUser(String userId) throws AppException {
        try {
            return this.userRepository.findById(userId);
        } catch (Exception e) {
            throw new DataBaseException("Error while fetching User Data!!", ErrorCode.DB_ERROR);
        }
    }

    public void saveUser(User user) throws AppException {
        try {
            this.userRepository.save(user);
        } catch (Exception e) {
            throw new DataBaseException("Error while saving user data!!", ErrorCode.DB_ERROR);
        }
    }
}
