package com.imho.repository;

import com.imho.domain.entity.Order;
import com.imho.domain.entity.Order_;
import com.imho.domain.entity.enumeration.OrderStatus;
import com.imho.domain.entity.user.Customer_;
import com.imho.repository.base.BaseRepositoryImpl;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Order, Long> implements OrderRepository {
    public OrderRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<Order> findByCustomerId(Long id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> query = cb.createQuery(Order.class);
        Root<Order> from = query.from(Order.class);
        Join<Object, Object> customer = from.join(Order_.CUSTOMER);
        query.select(from).where(cb.equal(customer.get(Customer_.ID), id));
        TypedQuery<Order> typedQuery = em.createQuery(query);
        typedQuery.setHint("jakarta.persistence.fetchgraph", getEntityGraph());
        return typedQuery.getResultList();
    }

    @Override
    public List<Order> findByStatus(OrderStatus status) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> query = cb.createQuery(Order.class);
        Root<Order> from = query.from(Order.class);
        query.select(from).where(cb.equal(from.get(Order_.STATUS), status));
        TypedQuery<Order> typedQuery = em.createQuery(query);
        typedQuery.setHint("jakarta.persistence.fetchgraph", getEntityGraph());
        return typedQuery.getResultList();
    }

    @Override
    protected Class<Order> getEntityClass() {
        return Order.class;
    }

    protected EntityGraph<Order> getEntityGraph() {
        return (EntityGraph<Order>) em.getEntityGraph(Order.ENTITY_GRAPH_NAME);
    }
}
