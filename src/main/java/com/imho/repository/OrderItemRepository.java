package com.imho.repository;

import com.imho.domain.entity.OrderItem;
import com.imho.repository.base.BaseRepository;

import java.util.List;

public interface OrderItemRepository extends BaseRepository<OrderItem, Long> {

    List<OrderItem> findByOrderId(Long orderId);
}
