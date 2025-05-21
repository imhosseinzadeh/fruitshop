package com.imho.controller;

import com.imho.domain.service.CustomerService;
import com.imho.dto.request.CustomerRegisterRequest;
import com.imho.dto.request.UserLoginRequest;
import com.imho.util.ValidationUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    public void register(CustomerRegisterRequest registerRequest) {
        ValidationUtil.validate(registerRequest);

        customerService.register(registerRequest);
    }

    public String login(UserLoginRequest userLoginRequest) {
        ValidationUtil.validate(userLoginRequest);

        return customerService.login(userLoginRequest);
    }
}
