package com.imho.domain.service;

import com.imho.domain.entity.Order;
import com.imho.domain.entity.enumeration.OrderStatus;
import com.imho.domain.service.base.BaseService;
import com.imho.dto.request.CreateOrderRequest;

import java.util.List;

public interface OrderService extends BaseService<Order, Long> {

    void create(CreateOrderRequest request);

    List<Order> getByCustomerId(Long customerId);

    List<Order> getByStatus(OrderStatus status);

    void deliverOrder(Long orderId);

    void cancelOrder(Long orderId);

}
