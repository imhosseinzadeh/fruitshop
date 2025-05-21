package com.imho.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CustomerRegisterRequest(Long id,
                                      @NotBlank @Pattern(regexp = "\\d{10}") String nationalId,
                                      @NotBlank String password,
                                      @NotBlank String name,
                                      @NotBlank String phone,
                                      @NotBlank String address) {
}
