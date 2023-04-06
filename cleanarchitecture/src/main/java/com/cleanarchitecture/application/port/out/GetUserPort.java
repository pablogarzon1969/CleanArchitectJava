package com.cleanarchitecture.application.port.out;

import com.cleanarchitecture.domain.User;

import java.util.List;

public interface GetUserPort {
    List<User> getAllUsers();
    User getUserById(Long userId);
}
