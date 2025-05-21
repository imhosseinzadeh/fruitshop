package com.imho.domain.service.impl.transactional;

import com.imho.domain.entity.user.Customer;
import com.imho.domain.service.CustomerService;
import com.imho.dto.request.CustomerRegisterRequest;
import com.imho.dto.request.UserLoginRequest;
import com.imho.util.EntityManagerUtil;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TransactionCustomerServiceImpl implements CustomerService {

    private final CustomerService customerService;

    @Override
    public void register(CustomerRegisterRequest registerRequest) {
        EntityManagerUtil.beginTransaction();
        customerService.register(registerRequest);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public String login(UserLoginRequest userLoginRequest) {
        EntityManagerUtil.beginTransaction();
        String login = customerService.login(userLoginRequest);
        EntityManagerUtil.commitTransaction();

        return login;
    }

    @Override
    public boolean existsByNationalId(String nationalId) {
        EntityManagerUtil.beginTransaction();
        boolean result = customerService.existsByNationalId(nationalId);
        EntityManagerUtil.commitTransaction();

        return result;
    }

    @Override
    public void saveOrUpdate(Customer entity) {
        EntityManagerUtil.beginTransaction();
        customerService.saveOrUpdate(entity);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public void deleteById(Long id) {
        EntityManagerUtil.beginTransaction();
        customerService.deleteById(id);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public Customer findById(Long id) {
        EntityManagerUtil.beginTransaction();
        Customer customer = customerService.findById(id);
        EntityManagerUtil.commitTransaction();

        return customer;
    }

    @Override
    public boolean existsById(Long id) {
        EntityManagerUtil.beginTransaction();
        boolean result = customerService.existsById(id);
        EntityManagerUtil.commitTransaction();

        return result;
    }

    @Override
    public List<Customer> findAll() {
        EntityManagerUtil.beginTransaction();
        List<Customer> customers = customerService.findAll();
        EntityManagerUtil.commitTransaction();

        return customers;
    }
}
