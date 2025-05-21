package com.imho.domain.entity;

import com.imho.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = OrderItem.TABLE_NAME)
@Entity
@NamedEntityGraph(
        name = OrderItem.ENTITY_GRAPH_NAME,
        attributeNodes = {
                @NamedAttributeNode(OrderItem_.ORDER)
        }
)
@Getter
@Setter
@NoArgsConstructor
public class OrderItem extends BaseEntity<Long> {
    public static final String ENTITY_GRAPH_NAME = "orderItem_graph";
    public static final String TABLE_NAME = "order_items";
    public static final String PRICE = "price";
    public static final String QUANTITY = "inventoryWeight";
    public static final String FRUIT_ID = "fruit_id";
    public static final String ORDER_ID = "order_id";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = FRUIT_ID)
    private Fruit fruit;

    @Column(name = PRICE)
    private double price;

    @Column(name = QUANTITY)
    private Double weight;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = ORDER_ID)
    private Order order;

    @Builder
    public OrderItem(Fruit fruit, double price, Double weight, Order order) {
        this.fruit = fruit;
        this.price = price;
        this.weight = weight;
        setOrder(order);
    }

    public void setOrder(Order order) {
        this.order = order;
        order.getItems().add(this);
    }

}
