package com.imho.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderItemDto(@NotNull @Positive Long fruitId,
                           @NotNull @Positive Double weight) {

}
