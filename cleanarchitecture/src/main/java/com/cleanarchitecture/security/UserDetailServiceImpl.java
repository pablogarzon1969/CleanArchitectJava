package com.cleanarchitecture.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cleanarchitecture.adapter.out.persistence.UserRepository;
import com.cleanarchitecture.adapter.out.persistence.UserEntity;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       UserEntity usuario= userRepository.findOneByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("El usuario con email"+ email + "no existe"));
       return new UserDetailsImpl(usuario);
    }
}
