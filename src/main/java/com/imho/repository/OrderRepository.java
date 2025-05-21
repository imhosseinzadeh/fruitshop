package com.imho.repository;

import com.imho.domain.entity.Order;
import com.imho.domain.entity.enumeration.OrderStatus;
import com.imho.repository.base.BaseRepository;

import java.util.List;

public interface OrderRepository extends BaseRepository<Order, Long> {

    List<Order> findByCustomerId(Long id);

    List<Order> findByStatus(OrderStatus status);
}
