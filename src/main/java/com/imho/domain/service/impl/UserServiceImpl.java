package com.imho.domain.service.impl;

import com.imho.context.SecurityContextHolder;
import com.imho.domain.entity.user.User;
import com.imho.domain.exception.UnauthorizedAccessException;
import com.imho.domain.service.UserService;
import com.imho.domain.service.base.BaseServiceImpl;
import com.imho.dto.request.UserLoginRequest;
import com.imho.repository.user.UserRepository;

import java.util.Optional;

public class UserServiceImpl<U extends User, R extends UserRepository<U>> extends BaseServiceImpl<U, Long, R>
        implements UserService<U> {

    public UserServiceImpl(R repository) {
        super(repository);
    }

    @Override
    public String login(UserLoginRequest userLoginRequest) {
        Optional<U> optUser = repository.findByNationalIdAndPassword(userLoginRequest.nationalId());

        if (optUser.isEmpty()) {
            throw new UnauthorizedAccessException("invalid username or password");
        }

        U user = optUser.get();
        if (!user.getPassword().equals(userLoginRequest.password())) {
            throw new UnauthorizedAccessException("invalid username or password");
        }

        SecurityContextHolder.setUser(user);

        // TODO: Implement logic to generate and return an authentication token
        return "Logged in successfully";
    }

    @Override
    public boolean existsByNationalId(String nationalId) {
        return repository.existsByNationalId(nationalId);
    }
}
