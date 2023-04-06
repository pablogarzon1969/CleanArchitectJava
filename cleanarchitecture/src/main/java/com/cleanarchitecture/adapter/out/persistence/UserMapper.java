package com.cleanarchitecture.adapter.out.persistence;

import com.cleanarchitecture.domain.User;

public class UserMapper {


    public static User entityToDomain(UserEntity usuarioEntity) {
        User usuario = new User();
        usuario.setId(usuarioEntity.getId());
        usuario.setNombre(usuarioEntity.getNombre());
        usuario.setEmail(usuarioEntity.getEmail());
        usuario.setPassword(usuarioEntity.getPassword());
        return usuario;
    }

    public static UserEntity domainToEntity(User usuario) {
        UserEntity usuarioEntity = new UserEntity();
        usuarioEntity.setId(usuario.getId());
        usuarioEntity.setNombre(usuario.getNombre());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setPassword(usuario.getPassword());
        return usuarioEntity;
    }
}
