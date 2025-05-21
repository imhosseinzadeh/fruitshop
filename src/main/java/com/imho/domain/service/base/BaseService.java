package com.imho.domain.service.base;

import com.imho.domain.entity.base.BaseEntity;

import java.util.List;

public interface BaseService<E extends BaseEntity<ID>, ID> {
    void saveOrUpdate(E entity);

    void deleteById(ID id);

    E findById(ID id);

    boolean existsById(ID id);

    List<E> findAll();
}
