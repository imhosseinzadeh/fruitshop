package com.imho.repository.user;

import com.imho.domain.entity.user.Customer;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;

public class CustomerRepositoryImpl extends UserRepositoryImpl<Customer> implements CustomerRepository {
    public CustomerRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }

    protected EntityGraph<Customer> getEntityGraph() {
        return (EntityGraph<Customer>) em.getEntityGraph(Customer.ENTITY_GRAPH_NAME);
    }
}
