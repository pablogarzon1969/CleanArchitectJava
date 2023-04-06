package com.cleanarchitecture.application.service;

import com.cleanarchitecture.adapter.out.kafka.KafkaConsumer;
import com.cleanarchitecture.adapter.out.persistence.UserPersistenceAdapter;
import com.cleanarchitecture.application.port.in.UserCommand;
import com.cleanarchitecture.application.port.in.UserServicePort;
import com.cleanarchitecture.application.port.out.CreateUserPort;
import com.cleanarchitecture.application.port.out.DeleteUserPort;
import com.cleanarchitecture.application.port.out.GetUserPort;
import com.cleanarchitecture.application.port.out.UpdateUserPort;
import com.cleanarchitecture.common.UseCase;
import com.cleanarchitecture.domain.User;
import com.cleanarchitecture.adapter.out.kafka.KafkaProducerConfig;
import lombok.AllArgsConstructor;

import java.util.List;

@UseCase
@AllArgsConstructor
public class UserService implements UserServicePort {

    private KafkaProducerConfig kafkaProducerConfig;
    private UserPersistenceAdapter usuarioPersistenceAdapter;

    private final CreateUserPort createUserPort;
    private final DeleteUserPort deleteUserPort;
    private final GetUserPort getUserPort;
    private final UpdateUserPort updateUserPort;


    @Override
    public void createUser(UserCommand user) {
        User userDomain=new User(
                user.getId(),
                user.getNombre(),
                user.getEmail(),
                user.getPassword()
        );
        createUserPort.create(userDomain);
    }

    @Override
    public User getUserById(Long userId) {
        return getUserPort.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        kafkaProducerConfig.kafkaTemplate().send("test-topic","Hola mundial");
        return getUserPort.getAllUsers();
    }

    @Override
    public User updateUser(UserCommand user) {
        User userDomain=new User(
                user.getId(),
                user.getNombre(),
                user.getEmail(),
                user.getPassword()
        );
        return updateUserPort.updateUser(userDomain);
    }

    @Override
    public void deleteUser(Long userId) {
        deleteUserPort.deleteUser(userId);
    }
}