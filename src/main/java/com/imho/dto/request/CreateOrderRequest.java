package com.imho.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record CreateOrderRequest(@NotNull @Positive Long customerId,
                                 @NotNull @NotEmpty List<OrderItemDto> orderItems) {
}
