package com.imho.domain.service.impl;

import com.imho.domain.entity.user.Customer;
import com.imho.domain.exception.DuplicateValue;
import com.imho.domain.service.CustomerService;
import com.imho.dto.request.CustomerRegisterRequest;
import com.imho.repository.user.CustomerRepository;

public class CustomerServiceImpl extends UserServiceImpl<Customer, CustomerRepository> implements CustomerService {

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

    @Override
    public void register(CustomerRegisterRequest registerRequest) {
        Customer customer = Customer.builder()
                .nationalId(registerRequest.nationalId())
                .password(registerRequest.password())
                .name(registerRequest.name())
                .phone(registerRequest.phone())
                .address(registerRequest.address())
                .build();

        if (existsByNationalId(customer.getNationalId())) {
            throw new DuplicateValue("invalid national id");
        }

        saveOrUpdate(customer); // must remove
    }

}
