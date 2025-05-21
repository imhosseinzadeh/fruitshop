package com.imho.domain.entity.user;

import com.imho.domain.entity.Order;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NamedEntityGraph(
        name = Customer.ENTITY_GRAPH_NAME,
        attributeNodes = {@NamedAttributeNode(com.imho.domain.entity.user.Customer_.ORDERS)}
)
@Getter
@Setter
@NoArgsConstructor
public class Customer extends User {
    public static final String ENTITY_GRAPH_NAME = "Customer_graph";
    public static final String ADDRESS = "address";
    public static final String PHONE = "phone";

    @Column(name = ADDRESS)
    private String address;

    @Column(name = PHONE)
    private String phone;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Order> orders = new HashSet<>();

    @Builder
    public Customer(String name, String nationalId, String password, String address, String phone) {
        super(name, nationalId, password);
        this.address = address;
        this.phone = phone;
    }

    public void addOrder(Order order) {
        order.setCustomer(this);
    }
}
