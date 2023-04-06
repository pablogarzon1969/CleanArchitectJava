package com.cleanarchitecture.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand {
    private Long id;
    private String nombre;
    private String email;
    private String password;
}
