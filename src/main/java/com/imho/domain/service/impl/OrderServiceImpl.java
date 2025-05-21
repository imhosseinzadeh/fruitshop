package com.imho.domain.service.impl;

import com.imho.domain.entity.Order;
import com.imho.domain.entity.OrderItem;
import com.imho.domain.entity.enumeration.OrderStatus;
import com.imho.domain.entity.user.Customer;
import com.imho.domain.service.CustomerService;
import com.imho.domain.service.FruitService;
import com.imho.domain.service.OrderService;
import com.imho.domain.service.base.BaseServiceImpl;
import com.imho.dto.request.CreateOrderRequest;
import com.imho.repository.OrderRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderServiceImpl extends BaseServiceImpl<Order, Long, OrderRepository> implements OrderService {
    private final CustomerService customerService;
    private final FruitService fruitService;

    public OrderServiceImpl(OrderRepository repository,
                            CustomerService customerService,
                            FruitService fruitService) {
        super(repository);
        this.customerService = customerService;
        this.fruitService = fruitService;

    }

    @Override
    public void create(CreateOrderRequest request) {
        Customer customer = customerService.findById(request.customerId());

        Set<OrderItem> items = request.orderItems()
                .stream()
                .map(orderItemDto -> OrderItem.builder()
                        .fruit(fruitService.findById(orderItemDto.fruitId()))
                        .weight(orderItemDto.weight())
                        .build())
                .collect(Collectors.toSet());

        items.forEach(orderItem ->
                fruitService.decreaseInventoryWeight(orderItem.getFruit(), orderItem.getWeight()));

        Order order = Order.builder()
                .customer(customer)
                .status(OrderStatus.IN_PROGRESS)
                .build();

        items.forEach(order::addOrderItem);

        customer.addOrder(order);
    }

    @Override
    public List<Order> getByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public List<Order> getByStatus(OrderStatus status) {
        return repository.findByStatus(status);
    }

    @Override
    public void deliverOrder(Long orderId) {
        Order order = findById(orderId);
        order.setStatus(OrderStatus.DELIVERED);
        saveOrUpdate(order); // must remove
    }

    @Override
    public void cancelOrder(Long orderId) {
        Order order = findById(orderId);
        order.setStatus(OrderStatus.CANCELLED);
        saveOrUpdate(order); // must remove
    }
}
