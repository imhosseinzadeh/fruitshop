package com.imho.domain.entity;


import com.imho.domain.entity.base.BaseEntity;
import com.imho.domain.entity.enumeration.OrderStatus;
import com.imho.domain.entity.user.Customer;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Order.TABLE_NAME)
@NamedEntityGraph(
        name = Order.ENTITY_GRAPH_NAME,
        attributeNodes = {
                @NamedAttributeNode(Order_.CUSTOMER),
                @NamedAttributeNode(Order_.ITEMS)
        }
)
@Getter
@Setter
@NoArgsConstructor
public class Order extends BaseEntity<Long> {
    public static final String ENTITY_GRAPH_NAME = "Order_graph";
    public static final String TABLE_NAME = "orders";
    public static final String CUSTOMER_ID = "customer_id";
    public static final String TOTAL_PRICE = "total_price";
    public static final String STATUS = "status";

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = CUSTOMER_ID)
    private Customer customer;

    @Column(name = TOTAL_PRICE)
    private Double totalPrice;

    @Column(name = STATUS)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private Set<OrderItem> items = new HashSet<>();

    @Builder
    public Order(Customer customer, Double totalPrice, OrderStatus status) {
        setCustomer(customer);
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItem.setOrder(this);
    }

    public Double calculateTotalPrice() {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getWeight()).sum();
    }
}
