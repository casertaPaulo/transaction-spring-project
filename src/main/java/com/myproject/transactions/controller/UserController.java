package com.myproject.transactions.controller;

import com.myproject.transactions.entity.UserEntity;
import com.myproject.transactions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> listAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findUserById(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable("id") Long id ) throws Exception {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
}
