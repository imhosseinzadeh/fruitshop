package com.imho.domain.service.impl.transactional;

import com.imho.domain.entity.Fruit;
import com.imho.domain.service.FruitService;
import com.imho.util.EntityManagerUtil;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TransactionFruitServiceImpl implements FruitService {

    private final FruitService fruitService;

    @Override
    public void addFruit(Fruit fruit) {
        EntityManagerUtil.beginTransaction();
        fruitService.addFruit(fruit);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public void updateFruit(Fruit fruit) {
        EntityManagerUtil.beginTransaction();
        fruitService.updateFruit(fruit);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public void increaseInventoryWeight(Fruit fruit, Double quantity) {
        EntityManagerUtil.beginTransaction();
        fruitService.increaseInventoryWeight(fruit, quantity);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public void decreaseInventoryWeight(Fruit fruit, Double weight) {
        EntityManagerUtil.beginTransaction();
        fruitService.decreaseInventoryWeight(fruit, weight);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public List<Fruit> findFruitsWithInventoryLessThan(Double threshold) {
        EntityManagerUtil.beginTransaction();
        List<Fruit> fruits = fruitService.findFruitsWithInventoryLessThan(threshold);
        EntityManagerUtil.commitTransaction();

        return fruits;
    }

    @Override
    public void saveOrUpdate(Fruit entity) {
        EntityManagerUtil.beginTransaction();
        fruitService.saveOrUpdate(entity);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public void deleteById(Long id) {
        EntityManagerUtil.beginTransaction();
        fruitService.deleteById(id);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public Fruit findById(Long id) {
        EntityManagerUtil.beginTransaction();
        Fruit fruit = fruitService.findById(id);
        EntityManagerUtil.commitTransaction();

        return fruit;
    }

    @Override
    public boolean existsById(Long id) {
        EntityManagerUtil.beginTransaction();
        boolean exists = fruitService.existsById(id);
        EntityManagerUtil.commitTransaction();

        return exists;
    }

    @Override
    public List<Fruit> findAll() {
        EntityManagerUtil.beginTransaction();
        List<Fruit> fruits = fruitService.findAll();
        EntityManagerUtil.commitTransaction();

        return fruits;
    }
}
