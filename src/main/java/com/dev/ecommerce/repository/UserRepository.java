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

    public Optional<User> getUser(String uuid) throws AppException {
        try {
            if (userData.containsKey(uuid)) {
                return Optional.of(userData.get(uuid));
            }

            return Optional.empty();
        } catch (Exception e) {
            throw new DataBaseException("Error while fetching User Data!!", ErrorCode.DB_ERROR);
        }
    }

    public void saveUser(User user) throws AppException {
        try {
            userData.put(user.getUuid(), user);
        } catch (Exception e) {
            throw new DataBaseException("Error while saving user data!!", ErrorCode.DB_ERROR);
        }
    }
}
