package com.imho.repository;

import com.imho.domain.entity.OrderItem;
import com.imho.domain.entity.OrderItem_;
import com.imho.domain.entity.Order_;
import com.imho.repository.base.BaseRepositoryImpl;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class OrderItemRepositoryImpl extends BaseRepositoryImpl<OrderItem, Long> implements OrderItemRepository {
    public OrderItemRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<OrderItem> getEntityClass() {
        return OrderItem.class;
    }

    @Override
    public List<OrderItem> findByOrderId(Long orderId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<OrderItem> query = cb.createQuery(OrderItem.class);
        Root<OrderItem> from = query.from(OrderItem.class);
        Join<Object, Object> order = from.join(OrderItem_.ORDER);
        query.select(from).where(cb.equal(order.get(Order_.ID), orderId));
        TypedQuery<OrderItem> typedQuery = em.createQuery(query);
        typedQuery.setHint("jakarta.persistence.fetchgraph", getEntityGraph());
        return typedQuery.getResultList();
    }

    protected EntityGraph<OrderItem> getEntityGraph() {
        return (EntityGraph<OrderItem>) em.getEntityGraph(OrderItem.ENTITY_GRAPH_NAME);
    }
}
