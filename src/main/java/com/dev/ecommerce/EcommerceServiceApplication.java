package com.dev.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceServiceApplication {
	/***
	 * Ecommerce APP
	 * Controller:
	 * OrderController -> customer can place the order and get the status
	 * PinServiceabilityController -> it will show the destination of the shipping of the item to be delivered or not
	 * PaymentController -> this is to make the payment and will return the status
	 * create the services:
	 * 1. OrderService -> customer can place order -> return the order status
	 * 2.
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(EcommerceServiceApplication.class, args);
		System.out.println("========== EcommerceServiceApp STARTED!! ============");
	}
}
