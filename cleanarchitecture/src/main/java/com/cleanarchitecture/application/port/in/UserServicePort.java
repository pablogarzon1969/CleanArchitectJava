package com.cleanarchitecture.application.port.in;

import com.cleanarchitecture.domain.User;

import java.util.List;

public interface UserServicePort {
    void createUser(UserCommand user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(UserCommand  user);

    void deleteUser(Long userId);
}
