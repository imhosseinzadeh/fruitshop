package com.imho.repository;

import com.imho.domain.entity.Fruit;
import com.imho.domain.entity.Fruit_;
import com.imho.repository.base.BaseRepositoryImpl;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class FruitRepositoryImpl extends BaseRepositoryImpl<Fruit, Long> implements FruitRepository {
    public FruitRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public boolean existsByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<Fruit> from = query.from(Fruit.class);
        query.select(cb.count(from)).where(cb.equal(from.get(Fruit_.NAME), name));
        return em.createQuery(query).getSingleResult() > 0;
    }

    @Override
    protected Class<Fruit> getEntityClass() {
        return Fruit.class;
    }

    @Override
    public List<Fruit> findFruitsWithInventoryLessThan(Double threshold) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Fruit> query = cb.createQuery(Fruit.class);
        Root<Fruit> from = query.from(Fruit.class);
        query.select(from).where(cb.lessThan(from.get(Fruit_.INVENTORY_WEIGHT), threshold));
        return em.createQuery(query).getResultList();
    }

    protected EntityGraph<Fruit> getEntityGraph() {
        return (EntityGraph<Fruit>) em.getEntityGraph(Fruit.ENTITY_GRAPH_NAME);
    }
}
