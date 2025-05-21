package com.imho.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateFruitRequest(@NotBlank String name,
                                 @NotBlank String description,
                                 @NotNull @Positive Double price,
                                 @NotNull @Positive Double inventoryWeight) {
}
