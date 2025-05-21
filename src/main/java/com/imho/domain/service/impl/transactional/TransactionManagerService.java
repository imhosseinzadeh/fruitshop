package com.imho.domain.service.impl.transactional;

import com.imho.domain.entity.user.Manager;
import com.imho.domain.service.ManagerService;
import com.imho.dto.request.UserLoginRequest;
import com.imho.util.EntityManagerUtil;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TransactionManagerService implements ManagerService {

    private final ManagerService managerService;

    @Override
    public String login(UserLoginRequest userLoginRequest) {
        EntityManagerUtil.beginTransaction();
        String result = managerService.login(userLoginRequest);
        EntityManagerUtil.commitTransaction();

        return result;
    }

    @Override
    public boolean existsByNationalId(String nationalId) {
        EntityManagerUtil.beginTransaction();
        boolean result = managerService.existsByNationalId(nationalId);
        EntityManagerUtil.commitTransaction();

        return result;
    }

    @Override
    public void saveOrUpdate(Manager entity) {
        EntityManagerUtil.beginTransaction();
        managerService.saveOrUpdate(entity);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public void deleteById(Long id) {
        EntityManagerUtil.beginTransaction();
        managerService.deleteById(id);
        EntityManagerUtil.commitTransaction();
    }

    @Override
    public Manager findById(Long id) {
        EntityManagerUtil.beginTransaction();
        Manager result = managerService.findById(id);
        EntityManagerUtil.commitTransaction();

        return result;
    }

    @Override
    public boolean existsById(Long id) {
        EntityManagerUtil.beginTransaction();
        boolean result = managerService.existsById(id);
        EntityManagerUtil.commitTransaction();

        return result;
    }

    @Override
    public List<Manager> findAll() {
        EntityManagerUtil.beginTransaction();
        List<Manager> managers = managerService.findAll();
        EntityManagerUtil.commitTransaction();

        return managers;
    }
}
