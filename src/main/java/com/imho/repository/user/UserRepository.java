package com.imho.repository.user;

import com.imho.domain.entity.user.User;
import com.imho.repository.base.BaseRepository;

import java.util.Optional;

public interface UserRepository<T extends User> extends BaseRepository<T, Long> {
    Optional<T> findByNationalIdAndPassword(String nationalId);

    boolean existsByNationalId(String nationalId);
}
