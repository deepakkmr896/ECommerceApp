package com.dev.ecommerce.mappers;

import com.dev.ecommerce.data.Order;
import com.dev.ecommerce.data.User;
import com.dev.ecommerce.domain.CreateOrderRequest;
import com.dev.ecommerce.domain.CreateUserRequest;
import com.dev.ecommerce.domain.OrderResponse;
import com.dev.ecommerce.enums.ErrorCode;
import com.dev.ecommerce.exception.AppException;
import com.dev.ecommerce.exception.MapperException;

public class OrderMapper {
    public static Order map(CreateOrderRequest createOrderRequest) throws AppException {
        try {
            Order order = new Order(createOrderRequest.getId());
            order.setProducts(createOrderRequest.getProductDetails());
            return order;
        } catch (Exception e) {
            throw new MapperException("Exception while mapping Order!!", ErrorCode.MAPPER_EXCEPTION);
        }
    }

    public static OrderResponse map(Order order) throws AppException {
        try {
            return new OrderResponse(order.getId(), order.getUser(), order.getProducts());
        } catch (Exception e) {
            throw new MapperException("Exception while mapping Order!!", ErrorCode.MAPPER_EXCEPTION);
        }
    }

    public static User map(CreateUserRequest createUserRequest) throws AppException {
        try {
            User user = new User(createUserRequest.getUserId());
            user.setName(createUserRequest.getName());
            user.setAge(createUserRequest.getAge());
            user.setGender(createUserRequest.getGender().name());
            user.setEmail(createUserRequest.getEmail());
            user.setPhone(createUserRequest.getPhone());
            return user;
        } catch (Exception e) {
            throw new MapperException("Exception while mapping User from CreateUserRequest!!", ErrorCode.MAPPER_EXCEPTION);
        }
    }
}
