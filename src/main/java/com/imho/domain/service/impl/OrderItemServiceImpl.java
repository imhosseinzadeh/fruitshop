package com.imho.domain.service.impl;

import com.imho.domain.entity.OrderItem;
import com.imho.domain.service.OrderItemService;
import com.imho.domain.service.base.BaseServiceImpl;
import com.imho.repository.OrderItemRepository;

import java.util.List;

public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem, Long, OrderItemRepository> implements OrderItemService {

    public OrderItemServiceImpl(OrderItemRepository repository) {
        super(repository);
    }

    @Override
    public List<OrderItem> getByOrderId(Long orderId) {
        return repository.findByOrderId(orderId);
    }
}
