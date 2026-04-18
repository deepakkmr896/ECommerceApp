package com.dev.ecommerce.service;

import com.dev.ecommerce.domain.CreateOrderRequest;
import com.dev.ecommerce.domain.CreateOrderResponse;
import com.dev.ecommerce.domain.OrderResponse;
import com.dev.ecommerce.exception.AppException;

public interface OrderService {
    CreateOrderResponse createOrder(CreateOrderRequest orderRequest) throws AppException;
    OrderResponse retrieveOrder(String id, String uuid) throws AppException;
}
