package com.imho.domain.service.impl;

import com.imho.domain.entity.user.Manager;
import com.imho.domain.service.ManagerService;
import com.imho.repository.user.ManagerRepository;

public class ManagerServiceImpl extends UserServiceImpl<Manager, ManagerRepository> implements ManagerService {

    public ManagerServiceImpl(ManagerRepository repository) {
        super(repository);
    }
}
