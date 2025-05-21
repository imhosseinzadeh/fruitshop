package com.imho.controller;

import com.imho.domain.entity.Fruit;
import com.imho.domain.service.FruitService;
import com.imho.dto.request.CreateFruitRequest;
import com.imho.util.ValidationUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FruitController {
    private final FruitService fruitService;

    public void addFruit(CreateFruitRequest createFruitRequest) {
        ValidationUtil.validate(createFruitRequest);

        Fruit fruit = Fruit.builder()
                .name(createFruitRequest.name())
                .description(createFruitRequest.description())
                .price(createFruitRequest.price())
                .InventoryWeight(createFruitRequest.inventoryWeight())
                .build();

        fruitService.addFruit(fruit);
    }
}
