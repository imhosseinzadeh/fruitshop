package com.imho.domain.service.base;

import com.imho.domain.entity.base.BaseEntity;
import com.imho.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BaseServiceImpl<T extends BaseEntity<ID>, ID, R extends BaseRepository<T, ID>> implements BaseService<T, ID> {
    protected final R repository;

    @Override
    public void saveOrUpdate(T entity) {
        if (entity.getId() == null) {
            repository.save(entity);
        } else {
            repository.update(entity);
        }
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("not found with id " + id));
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

}
