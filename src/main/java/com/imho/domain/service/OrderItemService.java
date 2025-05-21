package com.imho.domain.service;

import com.imho.domain.entity.OrderItem;
import com.imho.domain.service.base.BaseService;

import java.util.List;

public interface OrderItemService extends BaseService<OrderItem, Long> {

    List<OrderItem> getByOrderId(Long orderId);
}
