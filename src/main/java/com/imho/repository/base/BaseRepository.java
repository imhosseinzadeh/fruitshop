package com.imho.repository.base;

import com.imho.domain.entity.base.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<E extends BaseEntity<I>, I> {
    void save(E entity);

    void update(E entity);

    void deleteById(I id);

    Optional<E> findById(I id);

    boolean existsById(I id);

    List<E> findAll();
}
