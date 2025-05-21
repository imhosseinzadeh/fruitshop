package com.imho.domain.service.impl.transactional;

import com.imho.domain.entity.OrderItem;
import com.imho.domain.service.OrderItemService;
import com.imho.util.EntityManagerUtil;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TransactionalOrderItemServiceImpl implements OrderItemService {

    private final OrderItemService orderItemService;

    @Override
    public List<OrderItem> getByOrderId(Long orderId) {
        EntityManagerUtil.beginTransaction();
        List<OrderItem> orders = orderItemService.getByOrderId(orderId);
        EntityManagerUtil.commitTransaction();

        return orders;
    }

    @Override
    public void saveOrUpdate(OrderItem entity) {
        EntityManagerUtil.beginTransaction();
        orderItemService.saveOrUpdate(entity);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public void deleteById(Long aLong) {
        EntityManagerUtil.beginTransaction();
        orderItemService.deleteById(aLong);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public OrderItem findById(Long aLong) {
        EntityManagerUtil.beginTransaction();
        OrderItem orderItem = orderItemService.findById(aLong);
        EntityManagerUtil.commitTransaction();

        return orderItem;
    }

    @Override
    public boolean existsById(Long aLong) {
        EntityManagerUtil.beginTransaction();
        boolean exists = orderItemService.existsById(aLong);
        EntityManagerUtil.commitTransaction();

        return exists;
    }

    @Override
    public List<OrderItem> findAll() {
        EntityManagerUtil.beginTransaction();
        List<OrderItem> orders = orderItemService.findAll();
        EntityManagerUtil.commitTransaction();

        return orders;
    }
}
