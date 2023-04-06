package com.cleanarchitecture.adapter.out.persistence;

import com.cleanarchitecture.application.port.out.CreateUserPort;
import com.cleanarchitecture.application.port.out.DeleteUserPort;
import com.cleanarchitecture.application.port.out.GetUserPort;
import com.cleanarchitecture.application.port.out.UpdateUserPort;
import com.cleanarchitecture.common.PersistenceAdapter;
import com.cleanarchitecture.domain.User;

import java.util.List;

@PersistenceAdapter
public class UserPersistenceAdapter implements CreateUserPort, DeleteUserPort, GetUserPort, UpdateUserPort {
    private final UserRepository userRepository;

    public UserPersistenceAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User usuario){
        userRepository.save(UserMapper.domainToEntity(usuario));
    }

    public List<User> getAllUsers(){
        return   userRepository.findAll().stream().map(UserMapper::entityToDomain).toList();
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId).map(UserMapper::entityToDomain).orElseThrow(RuntimeException::new);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(User usuario) {
        UserEntity existingUser  =userRepository.findById(usuario.getId()).get();
        existingUser.setNombre(usuario.getNombre());
        existingUser.setPassword(usuario.getPassword());
        existingUser.setEmail(usuario.getEmail());
        UserEntity updatedUser = userRepository.save(existingUser);
        return  UserMapper.entityToDomain( updatedUser);
    }
}
