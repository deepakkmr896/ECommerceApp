package com.dev.ecommerce.service.impl;

import com.dev.ecommerce.dao.ProductDAO;
import com.dev.ecommerce.data.Order;
import com.dev.ecommerce.data.Product;
import com.dev.ecommerce.data.User;
import com.dev.ecommerce.domain.CreateOrderRequest;
import com.dev.ecommerce.domain.CreateOrderResponse;
import com.dev.ecommerce.domain.OrderResponse;
import com.dev.ecommerce.enums.ErrorCode;
import com.dev.ecommerce.enums.StatusCode;
import com.dev.ecommerce.exception.AppException;
import com.dev.ecommerce.exception.OrderException;
import com.dev.ecommerce.mappers.OrderMapper;
import com.dev.ecommerce.dao.OrderDAO;
import com.dev.ecommerce.dao.UserDAO;
import com.dev.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO;
    private final UserDAO userDAO;
    private final ProductDAO productDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO, UserDAO userDAO, ProductDAO productDAO) {
        this.orderDAO = orderDAO;
        this.userDAO = userDAO;
        this.productDAO = productDAO;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest orderRequest) throws AppException {
        Optional<User> user = this.userDAO.getUser(orderRequest.getUserId());
        if (user.isEmpty()) {
            throw new OrderException(String.format("User not found for userId : %s", orderRequest.getUserId()), ErrorCode.USER_NOT_FOUND);
        }

        Order order = new Order();
        order.setUser(user.get());

        for (String productId: orderRequest.getProductIds()) {
            Optional<Product> product = this.productDAO.getProduct(productId);
            if (product.isEmpty()) {
                throw new AppException(String.format("Product not available for id:: %s", productId), ErrorCode.PRODUCT_NOT_FOUND);
            }
            if (product.get().getOrder() != null) {
                throw new AppException(String.format("Product: %s is already ordered, try different from stock!", productId), ErrorCode.PRODUCT_ALREADY_ORDERED);
            }
            product.get().setOrder(order);
        }

        this.orderDAO.save(Optional.of(order));

        return new CreateOrderResponse(order.getId(), "Order Created Successfully!!", StatusCode.SUCCESS);
    }

    @Override
    public OrderResponse retrieveOrder(String id, String userId) throws AppException {
        Optional<User> user = this.userDAO.getUser(userId);
        if (user.isEmpty()) {
            throw new OrderException(String.format("User not found for userId : %s", userId), ErrorCode.USER_NOT_FOUND);
        }

        Optional<Order> order = this.orderDAO.getOrder(id, user.get());
        if (order.isEmpty()) {
            throw new OrderException("No Record Found!!", ErrorCode.ORDER_NOT_FOUND);
        }

        return OrderMapper.map(order.get());
    }
}
