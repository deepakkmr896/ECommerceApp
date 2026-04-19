package com.dev.ecommerce.dao;

import com.dev.ecommerce.data.Order;
import com.dev.ecommerce.data.User;
import com.dev.ecommerce.enums.ErrorCode;
import com.dev.ecommerce.exception.AppException;
import com.dev.ecommerce.exception.DataBaseException;
import com.dev.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderDAO {
    /**
     * Custom data prepared to test
     * @param id
     * @return
     */
    private final OrderRepository orderRepository;

    @Autowired
    public OrderDAO(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // String , List
    // String, Map<String, order>, products -> List


    public Optional<Order> getOrder(String id, User user) throws AppException {
        try {
            return this.orderRepository.findByIdAndUser(id, user);
        } catch (Exception e) {
            throw new DataBaseException("DB Error while retrieving order!!", ErrorCode.DB_ERROR);
        }
    }

    public void save(Optional<Order> order) throws AppException {
        if (order.isEmpty()) {
            throw new AppException("Order data is Empty!!", ErrorCode.EMPTY_DATA);
        }

        try {
            this.orderRepository.save(order.get());
        } catch (Exception ex) {
            throw new DataBaseException("DB Error while creating order!!", ErrorCode.DB_ERROR);
        }
    }
}
