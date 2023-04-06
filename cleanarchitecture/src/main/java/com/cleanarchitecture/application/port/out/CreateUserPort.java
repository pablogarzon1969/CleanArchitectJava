package com.cleanarchitecture.application.port.out;

import com.cleanarchitecture.domain.User;

public interface CreateUserPort {

    void create(User usuario);
}