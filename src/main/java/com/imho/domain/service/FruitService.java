package com.imho.domain.service;

import com.imho.domain.entity.Fruit;
import com.imho.domain.service.base.BaseService;

import java.util.List;

public interface FruitService extends BaseService<Fruit, Long> {

    void addFruit(Fruit fruit);

    void updateFruit(Fruit fruit);

    void increaseInventoryWeight(Fruit fruit, Double quantity);

    void decreaseInventoryWeight(Fruit fruit, Double weight);

    List<Fruit> findFruitsWithInventoryLessThan(Double threshold);
}
