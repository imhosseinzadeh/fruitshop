package com.imho.domain.service.impl;

import com.imho.domain.entity.Fruit;
import com.imho.domain.exception.InsufficientInventoryWeightException;
import com.imho.domain.service.FruitService;
import com.imho.domain.service.base.BaseServiceImpl;
import com.imho.repository.FruitRepository;

import java.util.List;

public class FruitServiceImpl extends BaseServiceImpl<Fruit, Long, FruitRepository> implements FruitService {

    public FruitServiceImpl(FruitRepository repository) {
        super(repository);
    }

    @Override
    public Fruit findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("fruit with id " + id + " not found"));
    }

    @Override
    public void addFruit(Fruit fruit) {
        if (repository.existsByName(fruit.getName())) {
            throw new RuntimeException("fruit already exists");
        }

        repository.save(fruit); // must remove
    }

    @Override
    public void updateFruit(Fruit fruit) {
        repository.findById(fruit.getId())
                .orElseThrow(() -> new RuntimeException("fruit with id " + fruit.getId() + " not found"));

        repository.save(fruit); // must remove
    }

    @Override
    public void increaseInventoryWeight(Fruit fruit, Double weight) {
        fruit.setInventoryWeight(fruit.getInventoryWeight() + weight);
        repository.update(fruit); // must remove
    }

    @Override
    public void decreaseInventoryWeight(Fruit fruit, Double weight) {
        if (fruit.getInventoryWeight() < weight) {
            throw new InsufficientInventoryWeightException("not enough inventory weight");
        }

        fruit.setInventoryWeight(fruit.getInventoryWeight() - weight);
        repository.update(fruit); // must remove
    }

    @Override
    public List<Fruit> findFruitsWithInventoryLessThan(Double threshold) {
        return repository.findFruitsWithInventoryLessThan(threshold);
    }

}
