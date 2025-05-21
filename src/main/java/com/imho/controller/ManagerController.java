package com.imho.controller;

import com.imho.domain.service.ManagerService;
import com.imho.dto.request.UserLoginRequest;
import com.imho.util.ValidationUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    public String login(UserLoginRequest loginRequest) {
        ValidationUtil.validate(loginRequest);

        return managerService.login(loginRequest);
    }
}
