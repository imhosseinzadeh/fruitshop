package com.imho.domain.service;

import com.imho.domain.entity.user.User;
import com.imho.domain.service.base.BaseService;
import com.imho.dto.request.UserLoginRequest;

public interface UserService<U extends User> extends BaseService<U, Long> {

    String login(UserLoginRequest userLoginRequest);

    boolean existsByNationalId(String nationalId);

}
