package com.imho.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserLoginRequest(
        @NotBlank @Pattern(regexp = "\\d{10}", message = "national id should be 10 digit") String nationalId,
        @NotBlank String password) {
}
