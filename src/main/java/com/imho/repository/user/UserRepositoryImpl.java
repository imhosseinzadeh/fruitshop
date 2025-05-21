package com.imho.repository.user;

import com.imho.domain.entity.user.User;
import com.imho.domain.entity.user.User_;
import com.imho.repository.base.BaseRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Optional;

public abstract class UserRepositoryImpl<T extends User> extends BaseRepositoryImpl<T, Long> implements UserRepository<T> {
    public UserRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Optional<T> findByNationalIdAndPassword(String nationalId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(getEntityClass());
        Root<T> from = query.from(getEntityClass());
        query.select(from).where(cb.and(
                cb.equal(from.get(User_.NATIONAL_ID), nationalId)
        ));

        return Optional.ofNullable(em.createQuery(query).getSingleResult());
    }

    @Override
    public boolean existsByNationalId(String nationalId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<User> from = query.from(User.class);
        query.select(cb.count(from)).where(cb.equal(from.get(User_.NATIONAL_ID), nationalId));
        return em.createQuery(query).getSingleResult() > 0;
    }
}
