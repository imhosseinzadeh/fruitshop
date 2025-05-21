package com.imho.domain.service;

import com.imho.domain.entity.user.Customer;
import com.imho.dto.request.CustomerRegisterRequest;

public interface CustomerService extends UserService<Customer> {

    void register(CustomerRegisterRequest registerRequest);
}
