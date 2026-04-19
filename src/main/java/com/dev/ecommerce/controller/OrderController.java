package com.dev.ecommerce.controller;

import com.dev.ecommerce.domain.CreateOrderRequest;
import com.dev.ecommerce.domain.CreateOrderResponse;
import com.dev.ecommerce.domain.OrderResponse;
import com.dev.ecommerce.exception.AppException;
import com.dev.ecommerce.exception.OrderException;
import com.dev.ecommerce.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 * Customer can place the order and get the status
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    /***
     * create the order
     * @param createOrderRequest
     * @return
     * @throws OrderException
     */
    @PostMapping
    public ResponseEntity<CreateOrderResponse> doOrder(@RequestBody CreateOrderRequest createOrderRequest) throws AppException {
        return new ResponseEntity<>(orderService.createOrder(createOrderRequest), HttpStatus.CREATED);
    }


    /***
     * Retrieve the order
     * @param id
     * @return
     * @throws AppException
     */
    @GetMapping("/{id}/{uuid}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable String id, @PathVariable String uuid) throws AppException {
        return new ResponseEntity<>(orderService.retrieveOrder(id, uuid), HttpStatus.OK);
    }
}
