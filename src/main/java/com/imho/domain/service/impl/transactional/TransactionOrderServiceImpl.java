package com.imho.domain.service.impl.transactional;

import com.imho.domain.entity.Order;
import com.imho.domain.entity.enumeration.OrderStatus;
import com.imho.domain.service.OrderService;
import com.imho.dto.request.CreateOrderRequest;
import com.imho.util.EntityManagerUtil;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TransactionOrderServiceImpl implements OrderService {

    private final OrderService orderService;

    @Override
    public void create(CreateOrderRequest request) {
        EntityManagerUtil.beginTransaction();
        orderService.create(request);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public List<Order> getByCustomerId(Long customerId) {
        EntityManagerUtil.beginTransaction();
        List<Order> orders = orderService.getByCustomerId(customerId);
        EntityManagerUtil.commitTransaction();

        return orders;
    }

    @Override
    public List<Order> getByStatus(OrderStatus status) {
        EntityManagerUtil.beginTransaction();
        List<Order> orders = orderService.getByStatus(status);
        EntityManagerUtil.commitTransaction();

        return orders;
    }

    @Override
    public void deliverOrder(Long orderId) {
        EntityManagerUtil.beginTransaction();
        orderService.deliverOrder(orderId);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public void cancelOrder(Long orderId) {
        EntityManagerUtil.beginTransaction();
        orderService.cancelOrder(orderId);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public void saveOrUpdate(Order entity) {
        EntityManagerUtil.beginTransaction();
        orderService.saveOrUpdate(entity);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public void deleteById(Long id) {
        EntityManagerUtil.beginTransaction();
        orderService.deleteById(id);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public Order findById(Long id) {
        EntityManagerUtil.beginTransaction();
        Order order = orderService.findById(id);
        EntityManagerUtil.commitTransaction();

        return order;
    }

    @Override
    public boolean existsById(Long id) {
        EntityManagerUtil.beginTransaction();
        boolean result = orderService.existsById(id);
        EntityManagerUtil.commitTransaction();

        return result;
    }

    @Override
    public List<Order> findAll() {
        EntityManagerUtil.beginTransaction();
        List<Order> orders = orderService.findAll();
        EntityManagerUtil.commitTransaction();

        return orders;
    }
}
