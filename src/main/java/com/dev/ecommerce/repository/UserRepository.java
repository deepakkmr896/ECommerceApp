package com.dev.ecommerce.repository;

import com.dev.ecommerce.data.User;
import com.dev.ecommerce.enums.ErrorCode;
import com.dev.ecommerce.exception.AppException;
import com.dev.ecommerce.exception.DataBaseException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {
    private static Map<String, User> userData = new HashMap<>();

    public Optional<User> getUser(String userId) throws AppException {
        try {
            if (userData.containsKey(userId)) {
                return Optional.of(userData.get(userId));
            }

            return Optional.empty();
        } catch (Exception e) {
            throw new DataBaseException("Error while fetching User Data!!", ErrorCode.DB_ERROR);
        }
    }

    public void saveUser(User user) throws AppException {
        if (userData.containsKey(user.getUserId())) {
            throw new AppException(String.format("User already exists!! userId:: %s", user.getUserId()), ErrorCode.DUPLICATE_USER_REQUEST);
        }

        try {
            userData.put(user.getUserId(), user);
        } catch (Exception e) {
            throw new DataBaseException("Error while saving user data!!", ErrorCode.DB_ERROR);
        }
    }
}
