package com.imho.controller;

import com.imho.domain.service.OrderService;
import com.imho.dto.request.CreateOrderRequest;
import com.imho.util.ValidationUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    public void createOrder(CreateOrderRequest createOrderRequest) {
        ValidationUtil.validate(createOrderRequest);

        orderService.create(createOrderRequest);
    }
}
