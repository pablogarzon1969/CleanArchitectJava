package com.cleanarchitecture.adapter.in.web;

import com.cleanarchitecture.application.port.in.UserCommand;
import com.cleanarchitecture.common.WebAdapter;
import com.cleanarchitecture.domain.User;
import lombok.AllArgsConstructor;
import com.cleanarchitecture.adapter.out.persistence.UserEntity;
import com.cleanarchitecture.application.port.in.UserServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@RestController
@AllArgsConstructor
//@RequestMapping("api/users")
public class UserController {

    private final UserServicePort userServicePort;

    // build create User REST API
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserCommand user){
        userServicePort.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userServicePort.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping(path = "/api/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userServicePort.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody UserCommand user){
        user.setId(userId);
        User updatedUser = userServicePort.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userServicePort.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
