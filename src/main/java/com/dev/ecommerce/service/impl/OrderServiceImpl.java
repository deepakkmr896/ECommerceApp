package com.dev.ecommerce.service.impl;

import com.dev.ecommerce.data.Order;
import com.dev.ecommerce.data.User;
import com.dev.ecommerce.domain.CreateOrderRequest;
import com.dev.ecommerce.domain.CreateOrderResponse;
import com.dev.ecommerce.domain.OrderResponse;
import com.dev.ecommerce.enums.ErrorCode;
import com.dev.ecommerce.enums.StatusCode;
import com.dev.ecommerce.exception.AppException;
import com.dev.ecommerce.exception.OrderException;
import com.dev.ecommerce.mappers.OrderMapper;
import com.dev.ecommerce.repository.OrderRepository;
import com.dev.ecommerce.repository.UserRepository;
import com.dev.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest orderRequest) throws AppException {
        Optional<Order> existingOrder = this.orderRepository.getOrder(orderRequest.getId(), orderRequest.getUuid());

        if (existingOrder.isPresent()) {
            throw new OrderException(String.format("Order is already present id : %s", orderRequest.getId()), ErrorCode.ORDER_ALREADY_EXISTS);
        }

        Optional<User> user = this.userRepository.getUser(orderRequest.getUuid());
        if (user.isEmpty()) {
            throw new OrderException(String.format("User not found for uuid : %s", orderRequest.getUuid()), ErrorCode.USER_NOT_FOUND);
        }

        Order order = OrderMapper.map(orderRequest);
        order.setUser(user.get());

        this.orderRepository.save(Optional.of(order));

        return new CreateOrderResponse(order.getId(), "Order Created Successfully!!", StatusCode.SUCCESS);
    }

    // TODO - need to add validation for the retrieval of the order based on the user id
    @Override
    public OrderResponse retrieveOrder(String id, String uuid) throws AppException {
        Optional<Order> order = this.orderRepository.getOrder(id, uuid);
        if (order.isEmpty()) {
            throw new OrderException("No Record Found!!", ErrorCode.ORDER_NOT_FOUND);
        }

        return OrderMapper.map(order.get());
    }
}
