package com.imho.repository.base;

import com.imho.domain.entity.base.BaseEntity;
import com.imho.domain.entity.base.BaseEntity_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<E extends BaseEntity<I>, I> implements BaseRepository<E, I> {
    protected final EntityManager em;

    public BaseRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(E entity) {
        em.persist(entity);
    }

    @Override
    public void update(E entity) {
        em.merge(entity);
    }

    @Override
    public void deleteById(I id) {
        findById(id).ifPresent(em::remove);
    }

    @Override
    public Optional<E> findById(I id) {
        return Optional.ofNullable(
                em.find(
                        getEntityClass(),
                        id
                )
        );
    }

    @Override
    public boolean existsById(I id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<E> from = query.from(getEntityClass());
        query.select(cb.count(from));
        query.where(
                cb.equal(from.get(BaseEntity_.ID), id)
        );
        return em.createQuery(query).getSingleResult() > 0;
    }

    @Override
    public List<E> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<E> query = cb.createQuery(getEntityClass());
        Root<E> from = query.from(getEntityClass());
        query.select(from);
        TypedQuery<E> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }

    protected abstract Class<E> getEntityClass();
}
