package com.imho.repository;

import com.imho.domain.entity.Fruit;
import com.imho.repository.base.BaseRepository;

import java.util.List;

public interface FruitRepository extends BaseRepository<Fruit, Long> {
    boolean existsByName(String name);

    List<Fruit> findFruitsWithInventoryLessThan(Double threshold);
}
