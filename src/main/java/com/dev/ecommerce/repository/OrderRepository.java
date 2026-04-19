package com.dev.ecommerce.repository;

import com.dev.ecommerce.data.Order;
import com.dev.ecommerce.enums.ErrorCode;
import com.dev.ecommerce.exception.AppException;
import com.dev.ecommerce.exception.DataBaseException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {
    /**
     * Custom data prepared to test
     * @param id
     * @return
     */
    private static Map<String, Map<String, Order>> existingOrderMap = new HashMap<>();

    // String , List
    // String, Map<String, order>, products -> List


    public Optional<Order> getOrder(String id, String userId) throws AppException {
        try {
            if (existingOrderMap.containsKey(userId)) {
                Map<String, Order> allOrders = existingOrderMap.get(userId);
                if (allOrders.containsKey(id)) {
                    return Optional.of(allOrders.get(id));
                }
            }

            return Optional.empty();
        } catch (Exception e) {
            throw new DataBaseException("DB Error while retrieving order!!", ErrorCode.DB_ERROR);
        }
    }

    public void save(Optional<Order> order) throws AppException {
        if (order.isEmpty()) {
            throw new AppException("Order data is Empty!!", ErrorCode.EMPTY_DATA);
        }

        try {
            Order orderData = order.get();

            if (existingOrderMap.containsKey(orderData.getUser().getUserId())) {
                Map<String, Order> orderMap = existingOrderMap.get(orderData.getUser().getUserId());
                orderMap.put(orderData.getId(), orderData);
                existingOrderMap.put(orderData.getUser().getUserId(), orderMap);
            }
            Map<String, Order> orderMap = new HashMap<>();
            orderMap.put(orderData.getId(), orderData);
            existingOrderMap.put(orderData.getUser().getUserId(), orderMap);
        } catch (Exception ex) {
            throw new DataBaseException("DB Error while creating order!!", ErrorCode.DB_ERROR);
        }
    }
}
