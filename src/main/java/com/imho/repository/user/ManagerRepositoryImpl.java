package com.imho.repository.user;

import com.imho.domain.entity.user.Manager;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;

public class ManagerRepositoryImpl extends UserRepositoryImpl<Manager> implements ManagerRepository {
    public ManagerRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Manager> getEntityClass() {
        return Manager.class;
    }

    protected EntityGraph<Manager> getEntityGraph() {
        return (EntityGraph<Manager>) em.getEntityGraph(Manager.ENTITY_GRAPH_NAME);
    }
}
