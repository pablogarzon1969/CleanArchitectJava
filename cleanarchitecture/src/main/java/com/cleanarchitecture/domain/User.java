package com.cleanarchitecture.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    public Long id;
    public String nombre;
    public String email;
    public String password;

    public User(Long id, String nombre, String email, String password) {
        this.id = id;
        this.nombre= nombre;
        this.email = email;
        this.password = password;
    }
}
